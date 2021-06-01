package BOJ_GOLD5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 평범한배낭 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] weights = new int[N+1]; //물건의 무게 정보
		int[] profits = new int[N+1]; //물건의 가치 정보
		
		int[][] D = new int[N+1][K+1]; //해당 물건까지 고려하여 해당 무게를 만들떄의 최대가치
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			weights[i]=Integer.parseInt(st.nextToken());
			profits[i]=Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {//가방의 무게
 				if(weights[i] <= j) {//가방에 넣을 수 있는 상황
											//넣을까                                           말까
					D[i][j]= Math.max(D[i-1][j-weights[i]]+profits[i], D[i-1][j]);
				}
				else {//못넣을때
					D[i][j]=D[i-1][j];
				}
			}
		}
		System.out.println(D[N][K]);
	}

}
