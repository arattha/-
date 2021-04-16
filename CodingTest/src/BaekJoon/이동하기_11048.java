package BaekJoon;

import java.util.Arrays;
import java.util.Scanner;

public class 이동하기_11048 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int arr[][]=new int[N][M];
		int dp[][]= new int[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		int sum=0;
		for (int i = 0; i < M; i++) {
			dp[0][i]=sum+arr[0][i];
			sum+=arr[0][i];
		}
		sum=0;
		for (int i = 0; i < N; i++) {
			dp[i][0]=sum+arr[i][0];
			sum+=arr[i][0];
		}
		
		for (int i = 1; i < N; i++) {
			for (int j = 1; j < M; j++) {
				dp[i][j]=Math.max(Math.max(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1])+arr[i][j];
			}
		}
		System.out.println(dp[N-1][M-1]);
	}
	
}
