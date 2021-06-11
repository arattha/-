package D6;

import java.util.Scanner;

public class 칩생산 {
	
	static int N,M;
	static int res;
	static int map[][];
	static int dp[][];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			N = sc.nextInt();
			M = sc.nextInt();
			map = new int[N][M];
			res = 0;
			dp = new int[1 << 10][1 << 24];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < (1 << M); j++) {
					dp[i][j] = -1;
				}
			}
			go(0,0);
			System.out.println("#"+tc+" "+res);
		}
	}

	private static void go(int idx, int cnt) {
		// TODO Auto-generated method stub
		
		if(N*M == idx) {
			if(res < cnt) res = cnt;
			return;
		}
		
		int y = idx/M;//y
		int x = idx%M;//x
		
		if (x == 0) {
	        int bit = 0;
	        for (int i = 0; i < M; i++) {
	            bit |= (map[y][i] << i);//이전 줄의 상태를 보관해서 다음줄에 반영하는거.
	        }
	        if (dp[y][bit] >= cnt) return;
	        dp[y][bit] = cnt;
	    }
		
		if(check(y,x)) {
			attach(y,x,1);
			go(idx+1,cnt+1);
			attach(y,x,0);
		}
		go(idx+1,cnt);
		
	}

	private static void attach(int y, int x, int val) {
		
		// TODO Auto-generated method stub
		for (int i = y; i < y+2; i++) {
			for (int j = x; j < x+2; j++) {
				map[i][j] = val;
			}
		}
	}

	private static boolean check(int y, int x) {
		// TODO Auto-generated method stub
		if(y+2 > N || x+2 > M) return false;
		
		for (int i = y; i < y+2; i++) {
			for (int j = x; j < x+2; j++) {
				if(map[i][j]==1) {
					return false;
				}
			}
		}
		return true;
	}

}
