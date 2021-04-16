package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


public class 최단경로1753ver2 {
	
	static class Node{
		int idx;
		int range;
		
		public Node(int idx, int range) {
			super();
			this.idx = idx;
			this.range = range;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int startV = Integer.parseInt(br.readLine());
		
		int D[]= new int[N+1];
		
		List<Node> adjList[] = new ArrayList[N+1];
		
		boolean visited[] = new boolean[N+1];
		
		for (int i = 0; i <= N; i++) {
			adjList[i]=new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start= Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());
			
			adjList[start].add(new Node(end,val));
		}
		
		Arrays.fill(D, Integer.MAX_VALUE);
		visited[0]=true;
		D[startV]=0;
		
		
		for (int i = 0; i < N; i++) {
			
			int minIdx=0;
			int minVal=Integer.MAX_VALUE;
			
			for (int j = 1; j <= N; j++) { // 가장 작은 간선 선택
				if(!visited[j] &&  minVal>D[j]) {
					minIdx=j;
					minVal=D[j];
				}
			}
			
			visited[minIdx]=true; // 선택한건 했다고 표시
			
			for (Node n : adjList[minIdx]) {
				if(!visited[n.idx] && n.range + D[minIdx] < D[n.idx] )
					D[n.idx]=n.range + D[minIdx];
			}
			
			
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			sb.append(D[i]==Integer.MAX_VALUE ?"INF":D[i]);
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
