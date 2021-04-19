package BaekJoon;

import java.util.Arrays;
import java.util.Scanner;

public class 다리놓기 {
 
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int[][] dp = new int[31][31];
 
		for (int i = 1; i <= 30; i++) {
			dp[1][i] = i;
			dp[i][i] = 1;
		}
			
 
		for (int i = 2; i <= 30; i++) {
			for (int j = i+1; j <= 30; j++) {
				dp[i][j] = dp[i - 1][j - 1] + dp[i][j-1];
			}
		}
//        
//        for (int i = 1; i < dp.length; i++) {
//			System.out.println(Arrays.toString(dp[i]));
//		}
		
		int T = in.nextInt();
	
		StringBuilder sb = new StringBuilder();
        
		for(int i = 0; i < T; i++) {
 
			int N = in.nextInt();
			int M = in.nextInt();
			
			sb.append(dp[N][M]).append('\n');
		}
		
		System.out.println(sb);
 
	}
}
