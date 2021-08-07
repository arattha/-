package BOJ_GOLD4;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class 네트워크연결 {
	
	static int V,E;
	
	
	static class Node{
		int to,weight;

		public Node(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		V = sc.nextInt();
		E = sc.nextInt();
		
		List<Node> arr[] = new ArrayList[V];
		
		for (int i = 0; i < V;i++) {
			arr[i]=new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			int from = sc.nextInt()-1;
			int to = sc.nextInt()-1;
			int weight = sc.nextInt();
			
			arr[from].add(new Node(to,weight));
			arr[to].add(new Node(from,weight));
		}
		
		long result=0;
		boolean[] visited = new boolean[V]; 
		int[] minEdge = new int[V];
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		minEdge[0]=0;
		
		for (int c = 0; c < V; c++) {
			
			int min = Integer.MAX_VALUE;
			int minV = 0;
			
			for (int i = 0; i < V; i++) {
				
				if(!visited[i] && min > minEdge[i]) {
					min = minEdge[i];
					minV = i;
				}
				
			}
			
			result +=min;
			visited[minV]=true;
			
			for (Node n : arr[minV]) {
				if(!visited[n.to] && minEdge[n.to] > n.weight )
					minEdge[n.to] = n.weight;
			}
			
		}
		
		System.out.println(result);
		
	}

}

