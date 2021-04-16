package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class 최단경로1753 {
	
	static class Node{
		int idx;
		int range;
		
		public Node(int idx, int range) {
			super();
			this.idx = idx;
			this.range = range;
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int E = sc.nextInt();
		int startV = sc.nextInt();
		
		int D[]= new int[N];
		
		List<Node> adjList[] = new ArrayList[N];
		
		boolean visited[] = new boolean[N];
		
		int adjMatrix[][] = new int[N][N];
		
		for (int i = 0; i < E; i++) {
			int start= sc.nextInt()-1;
			int end = sc.nextInt()-1;
			adjMatrix[start][end]=sc.nextInt();
		}
		
		//Arrays.fill(D, Integer.MAX_VALUE);
		//D[startV-1]=0;
		
		for (int i = 0; i < N; i++) {
			D[i]=adjMatrix[startV-1][i];
			if(i != startV-1 && D[i]==0) D[i]=Integer.MAX_VALUE;
		}
		
		System.out.println(Arrays.toString(D));
		
		//Queue<Integer>
		
		for (int i = 0; i < N; i++) {
			
			int minIdx=0;
			int minVal=Integer.MAX_VALUE;
			for (int j = 0; j < N; j++) { // 가장 작은 간선 선택
				if(!visited[j] &&  minVal>D[j]) {
					minIdx=j;
					minVal=D[j];
				}
			}
			
			visited[minIdx]=true; // 선택한건 했다고 표시

			for (int j = 0; j < N; j++) {
				
				if(!visited[j] && adjMatrix[minIdx][j]!=0 && (adjMatrix[minIdx][j] + D[minIdx] < D[j]) )
					D[j]=adjMatrix[minIdx][j] + D[minIdx];
				
				
			}
			
			
			
		}
		
		for (int i = 0; i < N; i++) {
			System.out.println( D[i]==Integer.MAX_VALUE ?"INF" : D[i]);
		}
		
	}

}
