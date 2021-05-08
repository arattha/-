package D4;

import java.util.Arrays;
import java.util.Scanner;

public class 지희의고장난계산기 {
	
	static int N;
	static int dp[];
	static int numpad[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
				
		for (int tc = 1; tc <= T; tc++) {
			dp = new int[1000001];
			numpad = new int[10];
			for (int i = 0; i < 10; i++) {
				numpad[i] = sc.nextInt();
			}
			N = sc.nextInt();
			factorization(N);
			
//			for (int i = 0; i <= 60; i++) {
//				System.out.print(dp[i]+" ");
//			}
//			System.out.println();
			System.out.print("#"+tc+" ");
			System.out.println(dp[N] == Integer.MAX_VALUE ? -1 : dp[N]+1);
		}
		
	}
	
	public static int factorization(int tempN) {
		if(dp[tempN] != 0) return dp[tempN];
		
		dp[tempN] = cal(tempN);//직접 누른거 안눌리면 최댓값
		
		for (int i = 1; i*i <= tempN; i++) {
			if(tempN%i == 0) {
				int a = factorization(i);//인수분해 시도
				int b = factorization(tempN/i);
				int temp = Integer.MAX_VALUE;
				if(a != Integer.MAX_VALUE && b != Integer.MAX_VALUE) {
					temp = a+b+1;
				}
				dp[tempN] = Math.min(dp[tempN], temp);
			}
		}
		
		return dp[tempN];
	}
	
	public static int cal(int tempN) {//무조건 직접 누르는게 이득
		int t = tempN;
		int cnt = 0;
		while(t != 0) {
			cnt++;
			if(numpad[t%10] == 0) {
				return Integer.MAX_VALUE;
			}
			t /= 10;
		}
		return cnt;
	}
	
}
