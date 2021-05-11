package BOJ_GOLD5;

import java.util.Arrays;
import java.util.Scanner;

public class 암호만들기_1759 {
	
	static int L,C;
	static char[] arr;
	static char[] res;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		L = sc.nextInt();
		C = sc.nextInt();
		
		arr = new char[C];
		res = new char[L];
		sb = new StringBuilder();
		for (int i = 0; i < C; i++) {
			arr[i]=sc.next().charAt(0);
		}
		
		Arrays.sort(arr);
		comb(0,0);
		System.out.println(sb.toString());
	}
	
	public static void comb(int cnt, int start) {
		if(cnt == L) {
			int moum = 0;
			int jaum = 0;
			for (int i = 0; i < L; i++) {
				if(res[i] == 'a' ||res[i] == 'e' ||res[i] == 'i' ||res[i] == 'o' ||res[i] == 'u' )
					moum++;
				else
					jaum++;
			}
			if(moum >=1 && jaum >=2) {
				for (int i = 0; i < L; i++) {
					sb.append(res[i]);
				}
				sb.append('\n');
			}
			
			return;
		}
		
		for (int i = start; i < C; i++) {
			res[cnt] = arr[i];
			comb(cnt+1,i+1);
		}
		
	}
	
}
