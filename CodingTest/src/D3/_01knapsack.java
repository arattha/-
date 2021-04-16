package D3;

import java.util.Scanner;

public class _01knapsack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			

			int N = sc.nextInt();
			int W = sc.nextInt();
			
			int[] weights = new int[N+1]; //물건의 무게 정보
			int[] profits = new int[N+1]; //물건의 가치 정보
			
			int[][] D = new int[N+1][W+1]; //해당 물건까지 고려하여 해당 무게를 만들떄의 최대가치
			
			for (int i = 1; i <= N; i++) {
				weights[i]=sc.nextInt();
				profits[i]=sc.nextInt();
			}
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= W; j++) {//가방의 무게
					if(weights[i] <= j) {//가방에 넣을 수 있는 상황
												//넣을까                                           말까
						D[i][j]= Math.max(D[i-1][j-weights[i]]+profits[i], D[i-1][j]);
					}
					else {//못넣을때
						D[i][j]=D[i-1][j];
					}
				}
			}
			System.out.println(D[N][W]);
			
		}
		
	}

}

