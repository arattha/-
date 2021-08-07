package BOJ_GOLD4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class 빙산 {

	static int N,M;
	
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	
	static int ans;
	static int map[][];
	static boolean visited[][];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int year = 0;
		while(true) {
			int t = iceberg();
			if(t == 0) {//없으면 다녹은거
				ans = 0;
				break;
			} else if(t >= 2) {
				ans = year;
				break;
			}
			visited = new boolean[N][M];
			
			melt();
			
			year++;
		}
		System.out.println(ans);
	}

	private static void melt() {
		
		int temp[][] = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] > 0) {//빙산
					int cnt = 0;
					for (int k = 0; k < dc.length; k++) {
						int nr = i + dr[k];
						int nc = j + dc[k];
						
						if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
						
						if(map[nr][nc] <= 0) cnt++;
						
					}
					temp[i][j] = cnt; // 녹일 값 더함
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] -= temp[i][j];
			}
		}
		
	}
	
	
	
	private static int iceberg() {
		// TODO Auto-generated method stub
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(!visited[i][j] && map[i][j] > 0) {//안갔고 빙산이면
					cnt++;
					dfs(i,j);
				}
			}
		}
		
		
		return cnt;
	}

	private static void dfs(int y, int x) {
		// TODO Auto-generated method stub
		visited[y][x] = true;
		
		for (int i = 0; i < dc.length; i++) {
			int nr = y + dr[i];
			int nc = x + dc[i];
			
			if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
			if(visited[nr][nc] || map[nr][nc] <= 0) continue;//범위안 갔던곳
			
			dfs(nr,nc);
			
		}
		
	}

}
