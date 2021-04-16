package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수지의수지맞는여행 {
	
	public static boolean[] alphabet;
	public static char[][] map;
	
	public static int R,C,res;
	
	public static int dr[] = {-1,1,0,0};
	public static int dc[] = {0,0,-1,1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			alphabet = new boolean[26];
			StringTokenizer st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			map = new char[R][C];
			res = 0;
			for (int i = 0; i < R; i++) {
				String str = br.readLine();
				for (int j = 0; j < C; j++) {
					map[i][j]=str.charAt(j);
				}
			}
			
			int start=(int)map[0][0]-65;
			alphabet[start]=true;
			dfs(0,0,1);
			System.out.println("#"+tc+" "+res);
		}
	}
	private static void dfs(int y, int x, int len) {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < dr.length; i++) {
			int tempY = y+dr[i];
			int tempX = x+dc[i];
			if(tempY < 0 || tempY == R || tempX < 0 || tempX == C) continue;
			
			int check = (int) map[tempY][tempX]-65;
			
			if(!alphabet[check]) { //안본 명물이면
				alphabet[check]=true;
				dfs(tempY,tempX,len+1);
				alphabet[check]=false;
			}
		}
		
		res = Math.max(res, len);
		
	}

}
