package BOJ_GOLD5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 적록색약_10026 {
	
	static int N;
	static char map[][];
	static boolean visited[][];
	static boolean visited2[][];
	static class Node {
		int y,x;
		char c;
		public Node(int y, int x,char c) {
			super();
			this.y = y;
			this.x = x;
			this.c = c;
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visited = new boolean[N][N];
		visited2 = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		int res=0;
		int res2=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					bfs(i,j,map[i][j] , true);
					res++;
				}
				if(!visited2[i][j]) {
					bfs(i,j,map[i][j] , false);
					res2++;
				}
			}
		}
		
		System.out.println(res+" "+res2);
	}
	
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	
	private static void bfs(int y, int x, char c, boolean t) {
		// TODO Auto-generated method stub
		
		Queue<Node> q = new LinkedList<>();
		
		if(t) visited[y][x] = true;
		else visited2[y][x] = true;
		
		q.offer(new Node(y,x,c));
		
		while(!q.isEmpty()) {
			
			Node n = q.poll();
			
			for (int i = 0; i < dr.length; i++) {
				
				int nr = n.y + dr[i]; //현재 바라보는 방향부터 왼쪽
				int nc = n.x + dc[i];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
				
				if(t) {
					if(map[nr][nc] != n.c) continue;
				}
				else {//색맹
					if(map[nr][nc] == 'R' || map[nr][nc] == 'G') {
						if(n.c == 'B') continue;
					}
					else { 
						if(map[nr][nc] != n.c) continue;
					}
				}
				
				if(t) {
					if(visited[nr][nc]) continue;
				}
				else {//색맹
					if(visited2[nr][nc]) continue;
				}
				
				q.offer(new Node(nr,nc,map[nr][nc]));
				if(t) visited[nr][nc] = true;
				else visited2[nr][nc] = true;
				
			}
			
		}
		
	}

}
