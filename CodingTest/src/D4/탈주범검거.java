package D4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 탈주범검거 {
	
	public static int dr[][] = {{},{-1,1,0,0},{-1,1,50,50},{50,50,0,0},{-1,50,50,0},{50,1,50,0},{50,1,0,50},{-1,50,0,50}};
	public static int dc[][] = {{},{0,0,-1,1},{0,0,50,50},{50,50,-1,1},{0,50,50,1},{50,0,50,1},{50,0,-1,50},{0,50,-1,50}};
	
	static int N,M,R,C,L;
	static int visited[][];
	static int map[][];
	
	static class Node{
		
		int y;
		int x;
		int cnt;
		
		public Node(int y, int x,int cnt) {
			super();
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			N = sc.nextInt();
			M = sc.nextInt();
			R = sc.nextInt();
			C = sc.nextInt();
			L = sc.nextInt();
			
			map = new int[N][M];
			visited = new int[N][M];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j]=sc.nextInt();
				}
			}
			
			Queue<Node> q = new LinkedList<>();
			
			visited[R][C]=1;
			q.offer(new Node(R,C,1));
			
			while (!q.isEmpty()) {
				Node n = q.poll();
				
				int pipe = map[n.y][n.x];//파이프 종류 저장
				if(n.cnt >= L) continue;
				
				for (int i = 0; i < dr[pipe].length; i++) {
					int nr = n.y + dr[pipe][i];
					int nc = n.x + dc[pipe][i];
					if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == 0) continue;
					if(isConntected(i,map[nr][nc])) continue;
					if(visited[nr][nc] == 0 || visited[nr][nc] > n.cnt+1 ) {
						visited[nr][nc]=n.cnt+1;
						q.offer(new Node(nr,nc,n.cnt+1));
					}
					
				}
			}
			int res=0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(visited[i][j]!=0) {
						res++;
					}
				}
			}
			System.out.println("#"+tc+" "+res);
		}
		
	}

	private static boolean isConntected(int current,int next) {
		boolean check=true;
		//0 상 1 하 2 좌 3 우 
		switch (current) {
		case 0:
			if(dr[next][1] != 50) check=false;
			break;
		case 1:
			if(dr[next][0] != 50) check=false;
			break;
		case 2:
			if(dr[next][3] != 50) check=false;
			break;
		case 3:
			if(dr[next][2] != 50) check=false;
			break;
		
		}
		return check;
	}

}
