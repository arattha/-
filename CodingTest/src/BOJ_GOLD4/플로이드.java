package BOJ_GOLD4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 플로이드 {
	
	static int N,M,adjMatrix[][];
	static int INF = 9999999;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		//경출도
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		adjMatrix = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(i != j && adjMatrix[i][j] == 0)
					adjMatrix[i][j] = INF;
			}
		}
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			adjMatrix[start][end] = Math.min(adjMatrix[start][end], Integer.parseInt(st.nextToken()));
		}
		
		for (int k = 0; k < N; k++) {//경
			for (int i = 0; i < N; i++) {//출
				if(i==k) continue;
				for (int j = 0; j < N; j++) {//도
					if(i == j || k == j) continue;
					if(adjMatrix[i][j] > adjMatrix[i][k] + adjMatrix[k][j]) {
						adjMatrix[i][j] = adjMatrix[i][k] + adjMatrix[k][j];
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(adjMatrix[i][j] == INF) sb.append("0 ");
				else sb.append(adjMatrix[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
