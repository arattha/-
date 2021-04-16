package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 미로2 {
	
	
	static char map[][] = new char[100][100];
	static int res;
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for (int tc = 1; tc <= 10; tc++) {
			br.readLine();
			for (int i = 0; i < 100; i++) {
				map[i]=br.readLine().toCharArray();
				
			}
			res=0;
			
			int startX=0;
			int startY=0;
			
			loop:for (startX=0;startX < 100; startX++) {
				for (startY=0;startY < 100; startY++) {
					if(map[startX][startY]=='2')
						break loop;
				}
			}
			go(startX,startY);
			
			System.out.println("#"+tc+" "+res);
		}
		
	}
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	private static void go(int y, int x) {
		// TODO Auto-generated method stub		
		if(map[y][x]=='3') {
			res=1;
			return;
		}
			
		map[y][x]='1';
		
		for (int i = 0; i < 4; i++) {
			if(isAvailable(y, x, i)) {
				go(y+dr[i],x+dc[i]);
			}
		}
		
	}
	
	private static boolean isAvailable(int y,int x, int dir) {
		int dy=y+dr[dir];
		int dx=x+dc[dir];
		if(dy<100 && dx<100 && dy>=0 && dx>=0 && (map[dy][dx]=='0' || map[dy][dx]=='3'))
			return true;
		
		return false;
	}
	
}
