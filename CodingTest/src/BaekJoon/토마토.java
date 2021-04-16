package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토 {
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	static class Node{
		int y,x;
		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken()); 
		int N = Integer.parseInt(st.nextToken()); 
		int cnt=0;
		int map[][] = new int[N][M];
		Queue<Node> q = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) cnt++;
				if(map[i][j] == 1) q.offer(new Node(i,j));
			}
		}
		
		int res = -1;
		while (!q.isEmpty()) {
			res++;
			int size = q.size();
			while (size-->0) {
				Node n = q.poll();
				
				for (int i = 0; i < 4; i++) {
					int nr = n.y + dr[i];
					int nc = n.x + dc[i];
					
					if(nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc]!=0) continue;
					
					map[nr][nc] = 1;
					cnt--;
					q.offer(new Node(nr,nc));
				}
				
			}
			
		}
		
		System.out.println(cnt != 0 ? -1 : res);
		
	}

}
