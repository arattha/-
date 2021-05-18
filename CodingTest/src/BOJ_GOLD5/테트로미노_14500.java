package BOJ_GOLD5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 테트로미노_14500 {
	
	static int N,M;
	static int map[][];
	
	static int blocks[][][] = {
			{
				{1,1,1,1}, //1자
				{0,0,0,0},
				{0,0,0,0},
				{0,0,0,0}
			},{
				{1,0,0,0},
				{1,0,0,0},
				{1,0,0,0},
				{1,0,0,0}
			},{
				{1,1,0,0}, //4각형
				{1,1,0,0},
				{0,0,0,0},
				{0,0,0,0}
			},{
				{0,1,0,0}, //ㄱ자
				{0,1,0,0},
				{1,1,0,0},
				{0,0,0,0}
			},{
				{1,0,0,0},
				{1,0,0,0},
				{1,1,0,0},
				{0,0,0,0}
			},{
				{1,1,1,0},
				{1,0,0,0},
				{0,0,0,0},
				{0,0,0,0}
			},{
				{1,0,0,0},
				{1,1,1,0},
				{0,0,0,0},
				{0,0,0,0}
			},{
				{1,1,0,0},
				{0,1,0,0},
				{0,1,0,0},
				{0,0,0,0}
			},{
				{1,1,0,0},
				{1,0,0,0},
				{1,0,0,0},
				{0,0,0,0}
			},{
				{0,0,1,0},
				{1,1,1,0},
				{0,0,0,0},
				{0,0,0,0}
			},{
				{1,1,1,0}, //ㄱ 자
				{0,0,1,0},
				{0,0,0,0},
				{0,0,0,0}
			},{
				{1,0,0,0},
				{1,1,0,0},
				{0,1,0,0},
				{0,0,0,0}
			},{
				{0,1,0,0},
				{1,1,0,0},
				{1,0,0,0},
				{0,0,0,0}
			},{
				{1,1,0,0},
				{0,1,1,0},
				{0,0,0,0},
				{0,0,0,0}
			},{
				{0,1,1,0},
				{1,1,0,0},
				{0,0,0,0},
				{0,0,0,0}
			},{
				{0,1,0,0},
				{1,1,1,0},
				{0,0,0,0},
				{0,0,0,0}
			},{
				{1,0,0,0},
				{1,1,0,0},
				{1,0,0,0},
				{0,0,0,0}
			},{
				{1,1,1,0},
				{0,1,0,0},
				{0,0,0,0},
				{0,0,0,0}
			},{
				{0,1,0,0},
				{1,1,0,0},
				{0,1,0,0},
				{0,0,0,0}
			}
	};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N+6][M+6];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i+3][j+3] = Integer.parseInt(st.nextToken());
			}
		}
		int res = 0;
		for (int i = 0; i < N+6; i++) {
			for (int j = 0; j < M+6; j++) {
				
				loop :for (int k = 0; k < blocks.length; k++) {
					int sum = 0;
					 for (int p = 0; p < 4; p++) {
						for (int q = 0; q < 4; q++) {
							if(i+p >= N+6 || j+q >= M+6) continue loop;
							if(blocks[k][p][q] == 1 ) {
								sum += map[i+p][j+q];
							}
						}
					}
					res = Math.max(res, sum);
				}
				
			}
		}
		System.out.println(res);
	}

}
