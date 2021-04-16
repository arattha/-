package BaekJoon;

import java.util.*;

public class 아기상어 {
	
	static class Node implements Comparable<Node>{
		int y,x;
		int cnt;
		public Node(int y, int x, int cnt) {
			super();
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			if(this.cnt==o.cnt) {
				if(this.y == o.y)
					return this.x - o.x;
				else
					return this.y - o.y;
			}
			else
				return this.cnt - o.cnt;
		}
	}
	
	static boolean check;
	static int N;
	static int[][] map;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int shark_size; //상어크기
	static int INF = -1;
	static Node shark;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		map = new int[N][N];
		shark_size = 2;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j]==9) {
					shark = new Node(i,j,0);
					map[i][j] = INF; //상어 있던곳 무한대로
				}
			}
		}
		
		int res = 0;
		int killCount=0;
		while (true) {
			
			shark = bfs(); //가장 가까이 있는 생선 반환
			
			if(shark == null) break; //가까이 있는 생선이 없다면
			else {
				//그 생선으로 이동
				killCount++;
				if(killCount == shark_size) {
					killCount = 0;
					shark_size++;
				}
				map[shark.y][shark.x]=INF;
				res += shark.cnt;
				
			}
		}
		
		System.out.println(res);
		
	}

	private static Node bfs() {
		
		boolean visited[][] = new boolean[N][N];
		Queue<Node> q = new LinkedList<>();;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		shark.cnt = 0;
		q.offer(shark);
		
		while(!q.isEmpty()) {
			
			Node n = q.poll();
			
			for (int i = 0; i < dr.length; i++) {
				
				int nr = n.y + dr[i];
				int nc = n.x + dc[i];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
				if(shark_size < map[nr][nc] || visited[nr][nc]) continue;//나보다 큰 거나 이미 갔던 곳
				
				if(shark_size > map[nr][nc] && map[nr][nc] > 0 )//먹을 수 있는애면?
					pq.offer(new Node(nr,nc,n.cnt+1));
				else
					q.offer(new Node(nr,nc,n.cnt+1));//못먹는 애면? 0이거나 -1이거나 나랑 같거나.
				visited[nr][nc] = true;
			}
		}
		
		return pq.poll();//pq반환
	}

}
