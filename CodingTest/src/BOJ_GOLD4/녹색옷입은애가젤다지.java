package BOJ_GOLD4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 녹색옷입은애가젤다지 {
	
	static int N;
	static int map[][];
	static int dist[][];
	
	static class Node implements Comparable<Node>{
		int y,x;
		int val;
		public Node(int y, int x, int val) {
			super();
			this.y = y;
			this.x = x;
			this.val = val;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.val, o.val);
		}
		
		
		
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = 1;
		while(true) {
			
			N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			
			map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			bfs();
			
			sb.append("Problem ").append(t).append(":").append(" ").append(dist[N-1][N-1]).append("\n");
			t++;
		}
		System.out.print(sb);
	}
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	private static void bfs() {
		// TODO Auto-generated method stub
		dist = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(0,0,map[0][0]));
		dist[0][0] = map[0][0];
		
		while(!pq.isEmpty()) {
			
			Node n = pq.poll();
			
			for (int i = 0; i < 4; i++) {
				
				int ny = n.y + dr[i];
				int nx = n.x + dc[i];
				
				if(ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
				
				if(dist[ny][nx] > n.val + map[ny][nx]) { //원래 여기까지 오던 최소값보다 지금 온 방식이 더 짧으면
					dist[ny][nx] = n.val + map[ny][nx];
					pq.add(new Node(ny,nx,n.val + map[ny][nx]));
				}
				
			}
			
		}
		
	}

}
