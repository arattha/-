package BOJ_GOLD4;

import java.util.Arrays;
import java.util.Scanner;

public class 단어수학 {
	
	static int[] alpha = new int[26];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N  = sc.nextInt();
		
		for (int s = 0; s < N; s++) {
			char[] a = sc.next().toCharArray();

			int t = 1;
			for (int i = a.length - 1; i >= 0; i--) {
				alpha[a[i] - 'A'] += t;
				t*=10;
			}
		}
		Arrays.sort(alpha);
		
		int k = 9;
		int res = 0;
		for (int i = alpha.length - 1; i >= 0; i--) {
			
			if(alpha[i] == 0) break;
			res += alpha[i] * (k--);
			
			
		}
		System.out.println(res);
	}

}
