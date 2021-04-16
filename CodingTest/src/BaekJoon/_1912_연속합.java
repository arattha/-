package BaekJoon;

import java.util.Arrays;
import java.util.Scanner;

public class _1912_연속합 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int arr[] = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int dp[] =new int[N];
		
		dp[0]=arr[0];
		int max=dp[0];
		
		for (int i = 1; i < dp.length; i++) {
			dp[i]=Math.max(dp[i-1] +arr[i], arr[i]);
			if(dp[i]>max)
				max=dp[i];
		}
		
		System.out.println(max);
	}
}
