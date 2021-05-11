package BOJ_GOLD5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로봇청소기_14503 {
	
	static int N,M;
	static int r,c,d;
	static int map[][];
	static boolean cleaned[][];
	static int res;
	static int dr[] = {-1,0,1,0};//상좌하우
	static int dc[] = {0,-1,0,1};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		cleaned = new boolean[N][M];
		res = 0;
		
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		if(d == 1 || d == 3) {
			d = (d+2)%4;
		}
		go(r,c,d);
		System.out.println(res);
	}

	private static void go(int row, int col, int dir) {
		// TODO Auto-generated method stub
		if(map[row][col] == 0) {
			// 1. 해당 장소 청소
			map[row][col] = 2;
			res++;
		}
		boolean t = false;
		for (int i = 0; i < dr.length; i++) {
			int nd = (dir+i+1) % 4;
			int nr = row + dr[nd]; //현재 바라보는 방향부터 왼쪽
			int nc = col + dc[nd];
			
			if(nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc]==1 || map[nr][nc]==2 ) continue; //벽이거나 이미 청소 
			
			go(nr,nc,nd);//그방향으로 회전하고 한칸 전진.
			t = true;
			break;//한번이라도 갔으면 멈춘다.
		}
		//2-c 네방향 모두 벽이거나 청소 
		if(!t) {
			int nd =(dir+2)%4;
			int nr = row + dr[nd]; //현재 바라보는 방향의 반대.
			int nc = col + dc[nd];
			if(nr >= 0 && nc >= 0 && nr < N && nc < M &&  map[nr][nc] != 1) go(nr,nc,dir); 
		} 
		
	}

}
