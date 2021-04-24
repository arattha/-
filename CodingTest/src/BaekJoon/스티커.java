package BaekJoon;

import java.util.*;
public class 스티커 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int T= sc.nextInt(); // 테스트 케이스
		
		for(int tc = 1; tc <= T; tc++) {
			
			int n= sc.nextInt();
			
			int cost[][] = new int[2][n+1];
			int dp[][] = new int[2][n+1];
			
			
			for(int j=0;j<2;j++) { // 비용을 입력
				for(int k=1;k<=n;k++) {
					cost[j][k] = sc.nextInt();
				}
			}
			
            // 0번째, 1번째 행의 첫 번째 열이 초기화로 초기값이 된다.
			dp[0][1] = cost[0][1];
			dp[1][1] = cost[1][1];
			
			
			for(int k=2;k<=n;k++) {
				
				dp[0][k] = Math.max(dp[1][k-1],dp[1][k-2]) + cost[0][k];
				dp[1][k] = Math.max(dp[0][k-1],dp[0][k-2]) + cost[1][k];
				
			}
				
			System.out.println(Math.max(dp[0][n], dp[1][n]));
			
		}
	}
}
