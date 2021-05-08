package BaekJoon;

import java.util.Arrays;
import java.util.Scanner;

public class 가장큰증가부분수열 {
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int input[] = new int[N+1];
		int dp[] = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			input[i] = sc.nextInt();
		}
		for (int i = 1; i <= N; i++) {
			dp[i] = input[i];
		}
		
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j < i; j++) {
				if(input[i]>input[j] && dp[j] + input[i] > dp[i] ) dp[i] = dp[j]+ input[i];
			}
		}
		
		int max = 0;
		for (int i = 1; i <= N; i++) {
			max = Math.max(dp[i], max);
		}
		System.out.println(max);
	}
	
}
