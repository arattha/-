package BaekJoon;

import java.util.Scanner;

public class 오르막_11057 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		long dp[][] = new long[1001][10];
		
		for (int i = 0; i < 10; i++) {
			dp[1][i] = 1;
		}
		
		for (int i = 2; i < 1001; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = j; k < 10; k++) {
					dp[i][j] +=dp[i-1][k] % 10007;
				}
			}
		}
		
		Scanner sc= new Scanner(System.in);
		
		int N = sc.nextInt();
		
		long res = 0;
		
		for (int i = 0; i < 10; i++) {
			res = (res + dp[N][i]) % 10007 ;
		}
		System.out.println(res %10007);
	}

}
