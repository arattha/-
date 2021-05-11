package D4;

import java.util.Scanner;

public class 극한의청소작업 {
	
	public static void main(String[] args) {
		
		long dp[][] = new long[12][10];
		
		for (int i = 0; i < 10; i++) {
			dp[0][i] = i;
			if(i < 4) dp[0][i]++; 
		}
		
		for (int i = 1; i < 12; i++) {
			for (int j = 0; j <10; j++) {
				dp[i][j] = dp[0][j] * dp[i-1][9];
			}
		}
				
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			long A = sc.nextLong();
			long B = sc.nextLong();
			long a = Math.abs(A);
			long b = Math.abs(B);
			
			int cnt = 0;
			
			long aRes= 0;
			long bRes= 0;
			
			while (a != 0) {
				
				int temp = (int) (a%10);
				if(cnt == 0) {
					aRes += dp[cnt][temp];
				}
				else if(temp == 0) {
					//aRes += 1;
				}
				else {
					aRes += dp[cnt][temp-1];
				}
				
				cnt++;
				a /= 10;
			}
			
			cnt = 0;
			
			while (b != 0) {
				int temp = (int) (b%10);
				if(cnt == 0) {
					bRes += dp[cnt][temp];
				}
				else if(temp == 0) {
					//bRes += 1;
				}
				else {
					bRes += dp[cnt][temp-1];
				}
				
				cnt++;
				b /= 10;
			}
			
			
			if(A < 0 && B > 0)
				System.out.println("#"+tc+" "+(aRes+bRes-3));
			else if(A > 0)
				System.out.println("#"+tc+" "+(bRes-aRes));
			else if(B < 0)
				System.out.println("#"+tc+" "+(aRes-bRes));
		}
	}
	
}
