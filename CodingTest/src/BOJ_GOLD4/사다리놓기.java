package BOJ_GOLD4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 사다리놓기 {
	
	static int N,M,H,max;
	static int map[][];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken()) - 1;
			int r = Integer.parseInt(st.nextToken()) - 1;
			
			map[l][r] = 1; //오른쪽 1;
			map[l][r+1] = 2; //왼쪽 2;
		}
		
		for (int i = 0; i <= 3; i++) {
			max = i;
			makeLadder(0,0,0);
		}
		System.out.println(-1);
	}
	
	private static void makeLadder(int y,int x,int cnt) {
		
		if(max == cnt) {//현재 사다리 설치 가능 갯수
			if(check()) {
				System.out.println(max);
				System.exit(0);
			}
			return;
		}
		//System.out.println(y+" "+x+" "+cnt);
		for (int i = y; i < H; i++) {
			for (int j = 0; j < N - 1; j++) {
				if(map[i][j] == 0 && map[i][j + 1] == 0) {
					map[i][j] = 1; map[i][j + 1] = 2;
					makeLadder(i,j,cnt+1);
					map[i][j] = map[i][j + 1] = 0;
				}
			}
		}
		
	}

	public static boolean check() {
		
		for (int i = 0; i < N; i++) {
			
			int dy = 0;
			int dx = i;
			
			while(dy != H) {
				if(map[dy][dx] == 0) {
					dy++;
				} else if(map[dy][dx] == 1) {
					dx++;
					dy++;
				} else {
					dx--;
					dy++;
				}
			}
			if(dx != i) {
				return false;
			}
		}
		return true;
	}
}
