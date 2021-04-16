package BaekJoon;

import java.util.Scanner;

public class 퇴사 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int t[] = new int[N];
		int p[] = new int[N];
		int dp[] = new int[N+1];
		int max=0;
		
		for (int i = 0; i < N; i++) {
			t[i]=sc.nextInt();
			p[i]=sc.nextInt();
		}
		
		for (int i = 0; i < N; i++) {
			
			if(i+t[i] < N+1) {//
				dp[i+t[i]] = Math.max(dp[i+t[i]], dp[i]+p[i]); //일했으면 상담끝나는 날 돈이온다고침
			}
			
			dp[i+1]=Math.max(dp[i+1],dp[i]);//일안했으면 다음날이득이 그대로.
			
			max = Math.max(max, dp[i+1]);
		}
		System.out.println(max);
	}

}
