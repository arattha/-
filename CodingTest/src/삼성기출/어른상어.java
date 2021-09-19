package 삼성기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 어른상어 {
	
	static int N,M,K;
	static int map[][];
	
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static Point[][] move;
	static int sharkPriority[][][];
	static int left;
	static class Shark{
		int y,x;
		int dir;
		Queue<Point> smell = new LinkedList();
		boolean die;
		public Shark(int y, int x) {
			super();
			this.y = y;
			this.x = x;;
		}
		
	}
	
	static class Point {
		int y,x;

		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

		@Override
		public boolean equals(Object o) {
			
			if(this.y == ((Point) o).y && this.x == ((Point) o).x) return true;
			return false;
		}
		
	}
	
	static Shark sharkList[];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		move = new Point[M + 1][2];
		
		for (int i = 1; i <= M; i++) {
			move[i][0] = new Point(0,0);
			move[i][1] = new Point(0,0);
		}
		
		map = new int[N + 1][N + 1];
		sharkPriority = new int[M + 1][4][4];
		sharkList = new Shark[M + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] >= 1) 
					sharkList[map[i][j]] = new Shark(i, j);
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= M; i++) {
			sharkList[i].dir = Integer.parseInt(st.nextToken()) - 1;
		}
		
		for (int i = 1; i <= M; i++) {
			for (int j = 0; j < 4; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < 4; k++) {
					sharkPriority[i][j][k] = Integer.parseInt(st.nextToken()) - 1;
				}
			}
		}
		
		int i; 
		for (i = 0; i < 1000; i++) {
			left = M;
			go();
			check();
			if(left == 1) break;
		}
		
		
		
		System.out.println(left == 1 ? i + 1: -1);
	}

	private static void check() {
		// TODO Auto-generated method stub
		for (int i = 1; i <= M; i++) {
			if(sharkList[i].die) left--;
		}
	}

	private static void go() {
		// TODO Auto-generated method stub
		
		loop : for (int i = 1; i <= M; i++) {//상어 수만큼
			
			Shark s = sharkList[i];
			boolean flag = true;
			
			if(s.die) {//죽은 상어면 냄새만 제거
				s.smell.add(new Point(0,0));//안쓰는 영역 집어넣기
				continue loop;
			}
			
			for (int j = 0; j < 4; j++) {//4방향 체크
				int n = sharkPriority[i][s.dir][j];//현재 우선순위
				
				int nr = s.y + dr[n];
				int nc = s.x + dc[n];
				
				if(nr <=0 || nc <= 0 || nr > N || nc > N) continue;
				
				if(map[nr][nc] == 0) {//우선순위 가도됨
					flag = false;
					
					s.smell.add(new Point(s.y,s.x));//냄새 저장
					
					move[i][0] = new Point(nr,nc);
					move[i][1] = new Point(s.y,s.x);
					s.dir = n;
					 // 냄새를 남기고 지나감
					
					break;
				}
				
			}
			
			if(flag) {//0 못찾았을때 나로 돌아오기용
				for (int j = 0; j < 4; j++) {//4방향 체크
					int n = sharkPriority[i][s.dir][j];//현재 우선순위
					
					int nr = s.y + dr[n];
					int nc = s.x + dc[n];
					
					if(nr <=0 || nc <= 0 || nr > N || nc > N) continue;
					
					if(map[nr][nc] == -1*i) {//우선순위 가도됨
						s.smell.add(new Point(s.y,s.x));//냄새 저장
						
						move[i][0] = new Point(nr,nc);
						move[i][1] = new Point(s.y,s.x);
						s.dir = n;
						 // 냄새를 남기고 지나감
						
						break;
					}
				}
			}
			
		}
		move();
		removeSmell();
	}
	
	private static void move() {
		// TODO Auto-generated method stub
		for (int i = 1; i <= M; i++) {
			Shark s = sharkList[i];
			if(s.die) continue;
			Point now = move[i][0];
			Point prev = move[i][1];
			
			if(map[now.y][now.x] > 0 && map[now.y][now.x] < i) {//나보다 쌘상어가 와계셨네..아이고..
				s.die = true;
			} else {
				map[now.y][now.x] = i;
			}
			map[prev.y][prev.x] =  -1 * i;
			s.y = now.y;
			s.x = now.x;
			
		}
	}

	public static void removeSmell() {
		
		for (int i = 1; i <= M; i++) {
			Shark s = sharkList[i];
			if(s.smell.size() == K) {//가장 나중 냄새 지우기
				Point p = s.smell.poll();
				if(!s.smell.contains(p))//같은 좌표가 또들어갔으면 나중에 지워야함;
					map[p.y][p.x] = 0;//냄새 지우기
			}
		}
	}
}
