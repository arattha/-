package BOJ_GOLD4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 트리의지름 {
	
	static class Edge {
		
		int to;
		int weight;
		
		public Edge(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}
		
	}
	static ArrayList<Edge>[] adjList;
	static int dist[];
	static int res,max;
	static int big;
	static boolean visit[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList[N];
		dist = new int[N];
		visit = new boolean[N];
		for (int i = 0; i < N; i++) {
			adjList[i] = new ArrayList<Edge>();
		}
		
		res = 0;
		for (int i = 0; i < N - 1; i++) {
			
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());
			
			adjList[from].add(new Edge(to,weight));
			adjList[to].add(new Edge(from,weight));
			
		}
		
		dfs(0,0);

		res = 0;
		dist = new int[N];
		visit = new boolean[N];
		dfs(big,0);
		
		System.out.println(res);
		
	}

	private static void dfs(int edge, int weight) {
		dist[edge] = weight;
		visit[edge] = true;
		
		if(dist[edge] > res) {
			res = weight;
			big = edge;
		}
		
		for (Edge e : adjList[edge]) {
			if(!visit[e.to]) {
				dfs(e.to , weight + e.weight);
			}
			
		}
		
	}

}
