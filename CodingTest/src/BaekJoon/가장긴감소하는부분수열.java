package BaekJoon;

import java.util.Arrays;
import java.util.Scanner;

public class 가장긴감소하는부분수열 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int input[] = new int[N+1];
		int dp[] = new int[N+1];
	
		for (int i = 1; i <= N; i++) {
			input[i] = sc.nextInt();
		}
		for (int i = 1; i <= N; i++) {
			dp[i] = 1;
		}
		
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j < i; j++) {
				if(input[i]<input[j] && dp[j] + 1 > dp[i] ) dp[i] = dp[j]+1;
			}
		}
		
		int max = 0;
		for (int i = 1; i <= N; i++) {
			max = Math.max(dp[i], max);
		}
		System.out.println(max);
	}

}
