package D4;

import java.util.Scanner;

public class 벌꿀채취 {
	
	static int map[][];
	static int profit[][];
	static int N,M,C;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			C = sc.nextInt();
			
			map = new int[N][N];
			profit = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			calProfit();
			
			int res = 0;
			int A=0,B=0;
			
//			for (int f = 0; f < N; f++) {
//				System.out.println(Arrays.toString(profit[f]));
//				
//			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N-1; j++) {
					A=profit[i][j];
					int idx = i*N+j+M;
					while(idx < N*N) {
						int row = idx/N;
						int col = idx%N;
						B = profit[row][col];
						res = Math.max(A+B,res);
						idx++;
					}
				}
			}
			System.out.println("#"+tc+" "+res);
		}
	}




	private static void calProfit() {
		// TODO Auto-generated method stub
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= N-M; j++) {
				powerSet(i,j,0,0,0);
			}
		}
	}



	private static void powerSet(int y,int x,int idx,int sum,int sumPr) {
		// TODO Auto-generated method stub
		if(sum > C) return;
		if(idx == M) {
			profit[y][x-M] = Math.max(profit[y][x-M], sumPr);
			return;
		}
		powerSet(y, x+1, idx+1,sum+map[y][x],sumPr+map[y][x]*map[y][x]);
		powerSet(y, x+1, idx+1,sum,sumPr);
	}

}
