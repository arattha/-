package BOJ_GOLD4;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 알고스팟 {
	
	static int N,M;
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	
	static class Node implements Comparable<Node>{
		int y,x;
		int cnt;
		
		public Node(int y, int x, int cnt) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.cnt, o.cnt);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		
		
		int map[][] = new int[N][M];
		boolean visited[][] = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			char[] temp = sc.next().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = temp[j]-'0';
			}
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(0,0,0));
		visited[0][0] = true;
		
		while (!pq.isEmpty()) {
			
			Node n = pq.poll();
			
			if(n.y == N - 1 && n.x == M - 1) {
				System.out.println(n.cnt);
				break;
			}
			for (int i = 0; i < 4; i++) {
				int nr = n.y + dr[i];
				int nc = n.x + dc[i];
				if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
				if(visited[nr][nc]) continue;
				
				if(map[nr][nc] == 0) {
					pq.offer(new Node(nr,nc,n.cnt));
					visited[nr][nc] = true;
				}else {
					pq.offer(new Node(nr,nc,n.cnt + 1));
					visited[nr][nc] = true;
				}
			}
			
		}
		
	}

}
