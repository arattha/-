
package BOJ_GOLD5;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 탈출_3055 {
	
	static int R,C;
	static char map[][];
	static Queue<Position> s;
	static Queue<Position> w;
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	
	
	static class Position{
		int y,x;

		public Position(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		R = sc.nextInt();
		C = sc.nextInt();
		s = new LinkedList<Position>();
		w = new LinkedList<Position>();
		
		map = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			String str = sc.next();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'S') {
					s.offer(new Position(i,j));
				}
				if(map[i][j] == '*') {
					w.offer(new Position(i,j));
				}
			}
		}
		
		int res = 0;
		res = go();
		System.out.println(res == 0 ? "KAKTUS" : res);
	}

	private static int go() {
		// TODO Auto-generated method stub
		Queue<Position> realS = s;
		Queue<Position> realW = w;
		
		int cnt = 0;
		while(!realS.isEmpty()) {
			
//			for (int i = 0; i < R; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
			int wSize = w.size();//1회에 처음 사이즈 만큼만
			for (int i = 0; i < wSize; i++) {
				
				Position nodeW = realW.poll(); 
				
				for (int j = 0; j < dc.length; j++) {
					
					int nwr = nodeW.y + dr[j];
					int nwc = nodeW.x + dc[j];
					
					if(nwr >= R || nwc >= C || nwr < 0 || nwc < 0) continue;
					//if(map[nwr][nwc] != '.'  && map[nwr][nwc] != 'S' && map[nwr][nwc] =='D') continue;
					if(map[nwr][nwc] == '.' || map[nwr][nwc] =='S') {
					map[nwr][nwc] = '*';
					realW.offer(new Position(nwr,nwc));
					}
					
				}
				
			}
			cnt++;
			//System.out.println(cnt);
			int sSize = s.size();
			for (int i = 0; i < sSize; i++) {
				
				Position nodeS = realS.poll(); 
				//System.out.println(nodeS.y + " " + nodeS.x);
				for (int j = 0; j < dc.length; j++) {
					
					int nsr = nodeS.y + dr[j];
					int nsc = nodeS.x + dc[j];
					
					if(nsr >= R || nsc >= C || nsr < 0 || nsc < 0) continue;
					if(map[nsr][nsc] == 'D') return cnt;
					if(map[nsr][nsc] == '.' ) {
						map[nsr][nsc] = 'S';
						realS.offer(new Position(nsr,nsc));
					}
				}
				
			}
			
			
		}
		return 0;
	}
}
