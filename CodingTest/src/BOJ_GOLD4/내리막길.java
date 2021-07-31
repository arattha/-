package BOJ_GOLD4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 내리막길 {
	static int n, m;
	static int[][] map;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[][] dp;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		dp = new int[n][m];
		for (int i = 0; i < n; i++) {
		    st = new StringTokenizer(br.readLine());
		    for (int j = 0; j < m; j++) {
		        map[i][j] = Integer.parseInt(st.nextToken());
		        dp[i][j] = -1;
		    }
		}
		int ans = dfs(0, 0);
		
		System.out.println(ans);
		
	}
	
	private static int dfs(int x, int y) {
		if (x == n - 1 && y == m - 1) return 1;
		if (dp[x][y] == -1) {
		    dp[x][y] = 0;
		
	    for (int i = 0; i < 4; i++) {
	        int nr = x + dx[i];
	        int nc = y + dy[i];
	        if (nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
		        if (map[x][y] > map[nr][nc]) {
		            dp[x][y] += dfs(nr, nc);
		        }
	    }
		}
		return dp[x][y];
	}
}
