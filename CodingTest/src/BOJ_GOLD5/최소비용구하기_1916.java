package BOJ_GOLD5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소비용구하기_1916 {
	
	public static class Edge implements Comparable<Edge>{
		int e,l;

		public Edge(int e, int l) {
			this.e = e;
			this.l = l;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.l - o.l;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		ArrayList<Edge>[] adjList = new ArrayList[N+1];
		for (int i = 0; i <= N; i++) {
			adjList[i] = new ArrayList();
		}
		
		StringTokenizer st = null;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			adjList[s].add(new Edge(e,l));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		boolean visited[] = new boolean[N+1];
		int[] D = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			D[i]=Integer.MAX_VALUE;
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(start,0));
		D[start] = 0;
		
		while(!pq.isEmpty()) {
			Edge curS = pq.poll();
			int curE = curS.e;
			
			if(!visited[curE]) {
				visited[curE] = true;
				
				for (Edge edge : adjList[curE]) {
					if(!visited[edge.e] && D[edge.e] > D[curE] + edge.l) {
						D[edge.e] = D[curE] + edge.l;
						pq.add(new Edge(edge.e , D[curE] + edge.l));
					}
				}
				
			}
			
		}
		System.out.println(D[end]);
	}

}
