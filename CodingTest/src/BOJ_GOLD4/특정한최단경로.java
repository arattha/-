package BOJ_GOLD4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 특정한최단경로 {
	
	static class Edge implements Comparable<Edge>{
		
		int to;
		int weight;
		
		public Edge(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}

		@Override
		public String toString() {
			return "Edge [to=" + to + ", weight=" + weight + "]";
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		ArrayList<Edge>[] adjList = new ArrayList[N];
		
		for (int i = 0; i < N; i++) {
			adjList[i] = new ArrayList<Edge>();
		}
		
		for (int i = 0; i < E; i++) {
			
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());
			
			adjList[from].add(new Edge(to,weight));
			adjList[to].add(new Edge(from,weight));
			
		}
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken()) - 1;
		int b = Integer.parseInt(st.nextToken()) - 1;
		
		Edge[][] D = new Edge[4][N];
		
		for (int i = 0; i < D.length; i++) {
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			boolean visit[] = new boolean[N];
			
			for (int j = 0; j < D[0].length; j++) {
				if(i == 0 && j==0)
					D[i][j] = new Edge(j,0);
				else if(i == 1 && j == N-1)
					D[i][j] = new Edge(j,0);
				else if(i == 2 && j == a)
					D[i][j] = new Edge(j,0);
				else if(i == 3 && j == b)
					D[i][j] = new Edge(j,0);
				else 
					D[i][j] = new Edge(j,Integer.MAX_VALUE);
				
				pq.add(D[i][j]);
			}
			while(!pq.isEmpty()){
				
				Edge e = pq.poll();
				if(e.weight == Integer.MAX_VALUE) break;
				
				for(Edge n : adjList[e.to]) {
					if(visit[n.to]) continue;
					if(D[i][n.to].weight > D[i][e.to].weight + n.weight ) {
						D[i][n.to].weight = D[i][e.to].weight + n.weight;
						
						pq.remove(D[i][n.to]);
						pq.add(D[i][n.to]);
					}
				}
				visit[e.to] = true;
			}
		}
		
		long resA = (long)D[0][a].weight + D[2][b].weight + D[1][b].weight;
		long resB = (long)D[0][b].weight + D[3][a].weight + D[1][a].weight;
		long res = Math.min(resA, resB);
		System.out.println(res >= Integer.MAX_VALUE ? -1 : res);
	}

}

