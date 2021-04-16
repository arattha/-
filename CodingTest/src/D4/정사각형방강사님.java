package D4;

import java.util.Scanner;

public class 정사각형방강사님{
	static int N;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			map = new int[N+2][N+2];
			for(int i = 1; i <= N; i++) {
				for(int j = 1;  j <= N; j++)
					map[i][j] = sc.nextInt();
			}
			ans_cnt = 0;
			ans_start = 987654321;
			ans = new Ans(987654321, 0);
			for(int i = 1; i <= N; i++) {
				for(int j = 1;  j <= N; j++)
					go(i, j, new Ans(map[i][j], 1));
			}
			System.out.println("#" + tc + " " + ans_start + " " + ans_cnt);
		}
	}
	static int ans_start;
	static int ans_cnt;
	static class Ans implements Comparable<Ans>{
		int start;
		int cnt;
		Ans(int start, int cnt){
			this.start = start;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(Ans o) {
			// TODO Auto-generated method stub
			if( this.cnt != o.cnt )
				return Integer.compare(o.cnt, this.cnt);
			else
				return Integer.compare(this.start, o.start);
		}
	}
	static Ans ans;
	static void go(int r, int c, Ans a) {
		if(ans.compareTo(a) > 0)
			ans = a;
		for(int d = 0; d< 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(map[nr][nc] == map[r][c] + 1)
				go(nr, nc, new Ans(a.start, a.cnt+1));
		}
	}
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
}
