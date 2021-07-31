package BOJ_GOLD4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 알파벳 {
	
	static int R,C;
	static int map[][];
	static boolean visited[];
	static int res;
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	
	static class Node{
		int y,x;
		int cnt;
		boolean alpha[];
		public Node(int y, int x, int cnt, boolean[] alpha) {
			super();
			this.y = y;
			this.x = x;
			this.cnt = cnt;
			this.alpha = alpha;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		R = sc.nextInt();
		C = sc.nextInt();
		map = new int[R][C];
		
		
		for (int i = 0; i < R; i++) {
			String temp = sc.next();
			for (int j = 0; j < C; j++) {
				map[i][j]=temp.charAt(j) - 'A';
			}
		}
		
		
		visited = new boolean[26];
		
		
		res = 0;
		dfs (0,0,1);
		
		System.out.println(res);
	}
	
	static void dfs(int y,int x, int cnt) {
		
		res = Math.max(res, cnt);
		visited[map[y][x]] = true;
		
		for (int i = 0; i < dc.length; i++) {
			int nr = y + dr[i];
			int nc = x + dc[i];
			
			if(nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
			if(visited[map[nr][nc]]) continue;
			
			dfs(nr,nc,cnt + 1);
			
		}
		
		visited[map[y][x]] = false;
	}
	
}
