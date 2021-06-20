package BOJ_GOLD5;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 인구이동 {
	
	static int N,L,R,res;
	static int map[][];
	static boolean visited[][];
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	
	static class Node{
		int x,y;

		public Node(int y, int x) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();
		
		map = new int[N][N];
		res = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		go();
		
		System.out.println(res-1);
	}

	private static void go() {
		
		boolean next = true;
		
		while(next) {
			res++;
			next = false;
			visited = new boolean[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!visited[i][j]) {
						if(bfs(i,j) > 1) {
							next = true;
						}
					}
				}
			}
		}
		
	}

	private static int bfs(int y, int x) {
		
		Queue<Node> q = new LinkedList<>();
		visited[y][x] = true;
		q.offer(new Node(y,x));
		
		Queue<Node> union = new LinkedList<>();
		union.offer(new Node(y,x));
		int total = 0;
		
		while(!q.isEmpty()) {
			
			Node n = q.poll();
			total += map[n.y][n.x];
			
			for (int i = 0; i < dc.length; i++) {
				
				int nr = n.y + dr[i];
				int nc = n.x + dc[i];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= N ) continue; //범위 넘는거
				if(visited[nr][nc]) continue; // 이미 간곳 
				
				int nt = Math.abs(map[n.y][n.x] - map[nr][nc]);
				if(nt < L || nt > R) continue; //인구 범위 안
				
				visited[nr][nc] = true;
				q.offer(new Node(nr,nc));
				union.offer(new Node(nr,nc));
			}
		}
		int size = union.size();
		for (Node n : union) {
			map[n.y][n.x] = total/size;
		}
		return size;
	}

}
