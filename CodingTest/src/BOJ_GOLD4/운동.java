package BOJ_GOLD4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 운동 {
	
	static int V,E,adjMatrix[][];
	static int INF = 10001;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
		//경출도
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		adjMatrix = new int[V][V];
		
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				adjMatrix[i][j] = INF;//돌아와야함
			}
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			adjMatrix[start][end] = Integer.parseInt(st.nextToken());
		}
		
		for (int k = 0; k < V; k++) {//경
			for (int i = 0; i < V; i++) {//출
				//if(i==k) continue; 나로 돌아와야함
				for (int j = 0; j < V; j++) {//도
					//if(i == j || k == j) continue;
					if(adjMatrix[i][j] > adjMatrix[i][k] + adjMatrix[k][j]) {
						adjMatrix[i][j] = adjMatrix[i][k] + adjMatrix[k][j];
					}
				}
			}
		}
		int result = INF;
		for (int i = 0; i < V; i++) {
			result = Math.min(result, adjMatrix[i][i]);
		}
		System.out.println(result);
		
	}

}
