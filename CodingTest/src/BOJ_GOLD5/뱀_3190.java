package BOJ_GOLD5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 뱀_3190 {

	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			map[y][x] = 2;
		}
		
		int snakeL=1;
		int tailY=1;
		int tailX=1;
		int headY=1;
		int headX=1;
		
		int dir = 1;
		
		int time = 0;
		while(true) {
			int nr = headY+dr[dir];
			int nc = headX+dc[dir];
			
			if(nr > 0 || nc > 0 || nr >= N || nc >= N) break;
			
			if(map[nr][nc] == 2) {//사과있으면
				snakeL++;
				headY=nr;
				headX=nc;
			} else {
				headY=nr;
				headX=nc;
				
			}
			
			map[nr][nc] = 1;
			
			time++;
		}
		
	}

}
