package BOJ_GOLD5;

import java.util.Scanner;

public class 합분해_2225 {
	
	static int big = 1000000000;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt(); 
		int k = s.nextInt(); 
		
		long[][] dp = new long[201][201];
		
		for(int i=1;i<=k;i++) {
			dp[i][0]=1;
		}
		for(int i=1;i<=k;i++) {
			for(int j=1;j<=n;j++) {
				dp[i][j] = (dp[i][j-1] + dp[i-1][j])%big; // 1000000000으로 나누는 걸 출력할 때 주면 틀렸다고 뜸.
			}
		}
		System.out.println(dp[k][n]);
		
	}

}
