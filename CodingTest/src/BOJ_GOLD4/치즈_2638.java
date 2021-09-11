package BOJ_GOLD4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 치즈_2638 {
	public static int N, M, cheese, time;
	public static int[][] map;
	public static boolean[][] v;
	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					cheese++;
			}
		}
		while (cheese != 0) {
			time++;
			
			airCheck();//외부 공기 만들기
			melt();
			
			for (int i = 0; i < N; i++) {
				
			}
			
		}
		System.out.println(time);
	}

	

	public static void airCheck() {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { 0, 0 });
		v = new boolean[N][M];
		v[0][0] = true;
		map[0][0] = -1;
		
		while (!q.isEmpty()) {
			
			int[] cur = q.poll();
			
			for (int i = 0; i < 4; i++) {
				
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= M || v[nx][ny]) continue;
				
//				if (map[nx][ny] == 1 && check(nx,ny)) {//치즈면서 녹는 대상이면
//					cheese--;
//					map[nx][ny] = 0;
//				} else 
				
				if (map[nx][ny] == 0 || map[nx][ny] == -1) {
					map[nx][ny] = -1;
					q.offer(new int[] { nx, ny });
				}
				
				v[nx][ny] = true;
				
			}
		}
	}
	
	private static void melt() {
		// TODO Auto-generated method stub
		
		v = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 1 && check(i,j)) {
					cheese--;
					v[i][j] = true;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(v[i][j]) {
					map[i][j] = -1;
				}
			}
		}
		
	}
	
	public static boolean check(int x,int y) {
		
		int tmp = 0;
		
		for (int i = 0; i < dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || nx >= N || ny < 0 || ny >= M ) continue;
			
			if(map[nx][ny] == -1) {
				tmp++;
			}
			if(tmp >= 2) {
				return true;
			}
		}
		
		return false;
	}
	
}