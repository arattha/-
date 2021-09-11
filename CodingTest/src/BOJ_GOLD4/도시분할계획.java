package BOJ_GOLD4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 도시분할계획 {
	
	static class Edge implements Comparable<Edge>{
		int from,to,weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}
		
	}
	
	static int V,E;
	static int parents[];
	static Edge[] edgeList;
	
	static void make() {//크기가 1인 단위집합을 만든다.
		
		for (int i = 0; i < V; i++) {
			parents[i] = i;
		}
		
	}
	
	static int findSet(int a) {
		if(parents[a]==a) return a;
		//return findSet(parents[a]); //path compression 전
		return parents[a]=findSet(parents[a]); //path compression 후
		
	}
	
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return false; // 이미 같은 집합 == 서큘러 발생.
		
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		V= Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		parents = new int[V];//집의 갯수
		edgeList = new Edge[E];//길의 갯수
		
		for (int i = 0; i < E; i++) {
			
			st = new StringTokenizer(in.readLine()," ");
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());
			edgeList[i] = new Edge(from,to,weight);//간선을 작은 것부터 저장.
		}
		
		Arrays.sort(edgeList);
		
		make();
		
		int result=0;
		int count=0;
		int max_edge = 0;
		
		for (Edge edge : edgeList) {//작은 간선 부터 꺼내면서
			
			if(union(edge.from,edge.to)) { // 싸이클이 발생하지 않았다면,
				result += edge.weight;
				max_edge = edge.weight;
				if(++count == V-1) break;
			}
			
		}
		System.out.println(result - max_edge);
	}
	
}

