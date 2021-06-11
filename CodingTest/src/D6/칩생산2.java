package D6;

import java.util.Scanner;

public class 칩생산2 {
	
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
			dp = new int[1 << N][M];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			for (int i = 0; i < (1 << N); i++) {
				for (int j = 0; j < M; j++) {
					dp[i][j] = -1;
				}
			}
			
			go(0,0,0);
			System.out.println("#"+tc+" "+res);
		}
	}

	private static void go(int y, int x, int cnt) {
		
		if(y >= N - 1) {
			y = 0;
			x++;
		}
		if(x == M) {
			if(res < cnt) res = cnt;
			return;
		}
		
		if (y == 0) {
	        int bit = 0;
	        for (int i = 0; i < N; i++) {
	            bit |= (map[i][x] << i);//이전 줄의 상태를 보관해서 다음줄에 반영하는거.
	        }
	        if (dp[bit][x] >= cnt) return;
	        dp[bit][x] = cnt;
	    }
		
		if(check(y,x)) {
			map[y][x] = map[y + 1][x] = map[y][x + 1] = map[y + 1][x + 1] = 1;
			go(y+2 , x ,cnt+1);
			map[y][x] = map[y + 1][x] = map[y][x + 1] = map[y + 1][x + 1] = 0;
		}
		go(y+1 , x ,cnt);
		
	}

	private static boolean check(int y, int x) {
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
