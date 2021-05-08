package BaekJoon;

import java.util.Scanner;

public class 가장긴바이토닉부분수열 {
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int input[] = new int[N+1];
		int dp[][] = new int[N+1][2];
		
		for (int i = 1; i <= N; i++) {
			input[i] = sc.nextInt();
		}
		for (int i = 1; i <= N; i++) {
			dp[i][0] = 1;
			dp[N+1-i][1] = 1;
		}
		
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j < i; j++) {
				if(input[i]>input[j] && dp[j][0] + 1 > dp[i][0] ) dp[i][0] = dp[j][0]+1;
				if(input[N+1-i]>input[N+1-j] && dp[N+1-j][1] + 1 > dp[N-i+1][1] ) dp[N-i+1][1] = dp[N+1-j][1]+1;
			}
		}
		
		int max = 0;
		for (int i = 1; i <= N; i++) {
			max = Math.max(dp[i][0]+dp[i][1], max);
		}
		System.out.println(max-1);
	}
	
}
