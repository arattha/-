package Studies;

import java.util.Scanner;

public class 박세영 {
    static int N, M, cnt;
    static int[][] map;
    static boolean[] visited;

	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    N = sc.nextInt();
	    M = sc.nextInt();
	    map = new int[N + 1][N + 1];
	    visited = new boolean[N + 1];
	
	    // 인접행렬만들기
	    for (int i = 0; i < M; i++) {
	        int a = sc.nextInt();
	        int b = sc.nextInt();
	        map[a][b] = 1;
	        map[b][a] = 1;
	    }
	    
	    cnt = 0;
	    for (int i = 1; i < N + 1; i++) {
	        if (!visited[i]) {
	            dfs(i);
	            cnt++;
	        }
	
	    }
	    System.out.println(cnt);
}

static void dfs(int v) {
	    visited[v] = true;
	    for (int i = 1; i < N + 1; i++) {
	        if (map[v][i] == 1 && !visited[i]) {    	
	            dfs(i);
	        }
	    }
	}
}