package BaekJoon;

import java.util.Arrays;
import java.util.Scanner;

public class 쉬운계단수_10844 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		long t = 1000000000;
		long dp[][] = new long[101][10];
		
		for (int i = 1; i < 10; i++) {
			dp[1][i]=1;
		}
		long res=0;
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < 10; j++) {
				if(j==0) dp[i][0]= dp[i-1][1] % t;
				else if(j==9) dp[i][9]= dp[i-1][8] % t;
				else dp[i][j]=dp[i-1][j-1]+dp[i-1][j+1] % t;
			}
		}
		for (int j = 0; j < 10; j++) {
			res+=dp[N][j]%t;
		}
		System.out.println(res%t);
	}
}
