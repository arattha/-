package BaekJoon;

import java.util.Scanner;

public class _01타일_1904 {
	
	static int N;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		long DP[] = new long[N+1];
		DP[1] = 1;
		if(N>=2)
			DP[2] = 2;
		
		for (int i = 3; i <= N; i++) {
			DP[i]=(DP[i-2]+DP[i-1])%15746;
		}
		
		
		System.out.println(DP[N]%15746);
	}

}
