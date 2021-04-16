package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 하나로 {
	
	//선택된 정점들중 제일 짧은 간선을 선택
	
	
	//선택된 정점과 선택되지않은 정점들로 나뉨
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			long[] xList=new long[N];
			long[] yList=new long[N];
			
			StringTokenizer stx = new StringTokenizer(br.readLine());
			StringTokenizer sty = new StringTokenizer(br.readLine());
			
			double E = Double.parseDouble(br.readLine());
			
			for (int i = 0; i < N; i++) {
				xList[i]=Integer.parseInt(stx.nextToken());
				yList[i]=Integer.parseInt(sty.nextToken());
			}
			
			long[][] adjMatrix = new long[N][N];
			boolean[] visited = new boolean[N];
			long[] minEdge = new long[N];
			
			StringTokenizer st = null;
			
			for (int i = 0; i < N; i++) {
				long fx=xList[i];
				long fy=yList[i];
				for (int j = 0; j < N; j++) {
					long bx=xList[j];
					long by=yList[j];
					adjMatrix[i][j] = (long) Math.pow(fx-bx, 2) + (long) Math.pow(fy-by, 2);
				}
				minEdge[i] =Long.MAX_VALUE;
			}
			
			long result = 0;
			minEdge[0] = 0;
			
			for (int c = 0; c < N; c++) {
				
				// 신장트리에 연결되지 않은 정점중 minEdge 비용이 최소인 정점
				long min = Long.MAX_VALUE;
				int minVertex = 0;
				for (int i = 0; i < N; i++) {
					if(!visited[i] && min > minEdge[i] ) {
						min = minEdge[i];
						minVertex = i;
					}
						
				}
				
				result += min;
				visited[minVertex] = true;
				
				for (int i = 0; i < N; i++) {//선택된 애 기준으로 최솟값 업데이트
					if(!visited[i] && adjMatrix[minVertex][i] != 0 && minEdge[i]> adjMatrix[minVertex][i]) {
						minEdge[i] = adjMatrix[minVertex][i];
					}
				}
				
			}
			System.out.println("#"+tc+" "+Math.round(result*E));
		}
		
	}

}
