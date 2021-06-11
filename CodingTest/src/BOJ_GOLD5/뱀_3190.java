package BOJ_GOLD5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 뱀_3190 {

	static int dr[] = {-1,0,1,0};//상우하좌
	static int dc[] = {0,1,0,-1};
	
	public static class Position{
		int y,x;

		public Position(int y, int x) {
			this.y = y;
			this.x = x;
		}
		
		@Override
		public boolean equals(Object o) {
			Position p = (Position) o;
			if(p.x == this.x && p.y == this.y) return true;
			return false;
		}
		
	}
	public static class Dir{
		int t;
		char c;
		public Dir(int t, char c) {
			this.t = t;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][N];
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken()) - 1;
			map[y][x] = 2;
		}
		
		int L = Integer.parseInt(br.readLine());
		ArrayList<Dir> timeArr = new ArrayList<>();
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);
			timeArr.add(new Dir(t,c));
		}
		
		Queue<Position> snake = new LinkedList<>();
		snake.offer(new Position(0,0));
		int dir = 1;
		int time = 0;
		int idx = 0;
		while(true) {
			Position p = snake.peek();
			
			//방향전환할 차례인지 확인
			if(idx < L && timeArr.get(idx).t == time) {
				if(timeArr.get(idx).c == 'L') {
					dir = (dir+3)%4;
				}else if(timeArr.get(idx).c == 'D') {
					dir = (dir+1)%4;
				}
				idx++;
			}
			
			int nr = p.y + dr[dir];
			int nc = p.x + dc[dir];
			//System.out.println(nr+" "+nc + " " + time +" " +snake.size());
			if(nr < 0 || nc < 0 || nr >= N || nc >= N) break;//벽충돌
			if(snake.contains(new Position(nr,nc))) break;//뱀충돌
			if(map[nr][nc]==2) {//사과가 있으면
				//System.out.println("사과있음 "+map[nr][nc]);
				map[nr][nc] = 0;
				Queue<Position> temp = new LinkedList<>();
				temp.offer(new Position(nr,nc));
				int size = snake.size();
				for (int i = 0; i < size; i++) {
					temp.offer(snake.poll());
				}
				snake = temp;
			} else {//사과가 없으면
				//System.out.println("사과없음 "+map[nr][nc]);
				Queue<Position> temp = new LinkedList<>();
				temp.offer(new Position(nr,nc));
				int size = snake.size() -1 ;
				for (int i = 0; i < size; i++) {
					temp.offer(snake.poll());
				}
				snake = temp;
			}
			
			
			time++;
		}
		System.out.println(time + 1);
	}

}
