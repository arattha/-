package D4;

import java.util.Arrays;
import java.util.Scanner;

public class 파핑파핑지뢰찾기 {

	static int N;
	static char map[][];
	static int dr[]= {-1,-1,-1,0,0,0,1,1,1};//왼쪽위부터
	static int dc[]= {-1,0,1,-1,0,1,-1,0,1};
	static int bomb;
	static boolean t;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			N=sc.nextInt();
			bomb=0;
			map = new char[N][N];
			for (int i = 0; i < N; i++) {
					map[i] = sc.next().toCharArray();
			}
			t=false;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j]=='.') {
						t=false;
						zeroMineSweeper(i,j);
					}
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j]=='.') bomb++;
				}
			}
			
			System.out.println("#"+tc+" "+ bomb);
		}
		
	}

	private static void zeroMineSweeper(int y, int x) {
		// TODO Auto-generated method stub
		
		int cnt=checkM(y,x);
		
		if(cnt==0) {
			if(t==false) {
				t=true;
				bomb++;
			}
			for (int i = 0; i < dc.length; i++) {
				if(y+dr[i] < 0 || x+dc[i] < 0 || y+dr[i] >= N  || x+dc[i] >= N) continue;
				if(map[y+dr[i]][x+dc[i]]=='.') {//연쇄 폭발
					map[y][x] = '0';
					test(y+dr[i],x+dc[i]);
				}
			}
		}
			
	}
	
	private static void test(int y, int x) {
		int cnt=checkM(y,x);
		if(cnt==0) zeroMineSweeper(y,x);
		else map[y][x]=(char)(cnt+'0');
	}
	
	
	private static int checkM(int y,int x) {
		int cnt=0;
		for (int i = 0; i < dc.length; i++) {
			if(y+dr[i] < 0 || x+dc[i] < 0 || y+dr[i] >= N  || x+dc[i] >= N) continue;
			if(map[y+dr[i]][x+dc[i]]=='*') {//지뢰 8방에 존재시
				cnt++;
			}
		}
		return cnt;
	}

}
