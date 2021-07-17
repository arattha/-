package BOJ_GOLD5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 감소하는수_1038 {

	static int N;
	static ArrayList<Long> arr;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		arr = new ArrayList<>();
		
		for (int i = 0; i < 10; i++) {
			recur(i,1);
		}
		
		Collections.sort(arr);
		if(arr.size() <= N) System.out.println(-1);
		else System.out.println(arr.get(N));
	}


	private static void recur(long num, int len) {
		// TODO Auto-generated method stub
		if(len > 10) return;
		
		arr.add(num);
		
		for (int i = 0; i < 10; i++) {
			if(num%10 > i) {
				recur(num*10 + i, len + 1);
			}
		}
		
	}

}
