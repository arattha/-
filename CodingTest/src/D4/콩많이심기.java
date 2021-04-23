package D4;

import java.util.Scanner;

public class 콩많이심기 {
	
	static int N,M;
	static int map[][];
	
	static int dr[] = {-2,2,0,0};
	static int dc[] = {0,0,-2,2};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			N = sc.nextInt();
			M = sc.nextInt();
			
			map = new int[N][M];
			
			홍진호();
			int res=0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j]==0)
						res++;
				}
			}
			System.out.println("#"+tc+" "+res);
		}
		
	}

	private static void 홍진호() {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]==1)continue; 
				for (int k = 0; k < dc.length; k++) {
					int nr = i+dr[k];
					int nc = j+dc[k];
					
					if( nr < 0 || nc < 0 || nr >=N || nc >= M) continue;
					map[nr][nc]=1;
				}
			}
		}
		
	}

}
