package D4;

import java.util.Scanner;

public class 성수의비밀번호공격 {
	
	static int MOD = 1000000007;
	static int N,M;
	static long factorial[];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		factorial = new long[101];
		factorial[1]=1;
		for (int i = 2; i <= 100; i++) {
			factorial[i]=(factorial[i-1]*i)%MOD;
		}
		
		for (int tc = 1; tc <= T; tc++) {
			
			N = sc.nextInt();
			M = sc.nextInt();
			
			long ans = power(N,M);
			
			// 전체 경우의 수
			
			for (int i = 1; i <= N; i++) {
				ans += ((((i % 2 ==0) ? 1L : -1L) * ( nCk(N,i) * power(N-i,M) ) %MOD )) %MOD;
				ans %= MOD;
			}
			System.out.println("#"+tc+" "+ (ans >= 0? ans: (ans+MOD)));
		}
	}
	private static long nCk(int n, int k) {
		// TODO Auto-generated method stub
		
		long base = (factorial[k] * factorial[n-k]) % MOD; 
		long powerD =  power(base,MOD-2)%MOD;
		
		// N! / K! N-k! mod 1000000007 -> N! * (K! N-K!)^ mod 1000000007-2
		
		return (factorial[n] * powerD) % MOD;
		
	}
	private static long power(long base , int quotient) {
		// 거듭 제곱을 분할정복
		if(quotient == 0) return 1L; //지수 0은 1
		long res = power(base,quotient/2) % MOD; // 절반씩
		res = (res * res) % MOD;
		if(quotient % 2==0) return res;
		else return res*base%MOD;
	}
}
