package 삼성기출;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class 스타트택시_19238 {
	
	static int N,M;
	static int F;
	static int result;
	
	static int tx,ty;
	static int map[][];
	static int r;
	static ArrayList<Client> dest;
	
	static class Taxi implements Comparable<Taxi>{
		int y,x;
		int fuel;
		int client;
		int cnt;
		
		public Taxi(int y, int x, int fuel, int cnt) {
			super();
			this.y = y;
			this.x = x;
			this.fuel = fuel;
			this.cnt = cnt;
		}
		
		@Override
		public String toString() {
			return "Taxi [y=" + y + ", x=" + x + ", fuel=" + fuel + ", client=" + client + ", cnt=" + cnt + "]";
		}

		@Override
		public int compareTo(Taxi o) {
			// TODO Auto-generated method stub
			if(this.cnt == o.cnt) {
				if(this.y == o.y) 
					return Integer.compare(this.x, o.x);
				else 
					return Integer.compare(this.y, o.y);
			} else 
				return Integer.compare(this.cnt, o.cnt);
				
		}
	}
	
	static class Client {
		int y,x;
		int destY,destX;
		
		public Client(int y, int x, int destY, int destX) {
			super();
			this.y = y;
			this.x = x;
			this.destY = destY;
			this.destX = destX;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		F = sc.nextInt();
		
		map = new int[N][N];
		dest = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		ty = sc.nextInt() - 1;
		tx = sc.nextInt() - 1;
		
		
		r = 0;
		result = -1;
		
		for (int i = 0; i < M; i++) {
			int y = sc.nextInt() - 1;
			int x = sc.nextInt() - 1;
			int dy = sc.nextInt() - 1;
			int dx = sc.nextInt() - 1;
			
			dest.add(new Client(y, x, dy, dx));
			
		}
		
		
		while(true) {
			
			if(find()) {
				r++;
				result = F;
			} else {
				result = -1;//실패
				break;
			}
			
			if(r==M) break; //승객을 다 날랐으면 끝.
		}
		
		System.out.println(result);
		
	}

	
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};

	
	private static boolean find() {
		// TODO Auto-generated method stub
		
		Queue<Taxi> q = new LinkedList();
		boolean visited[][] = new boolean[N][N];
		
		for (int i = 0; i < dest.size(); i++) {
			Client c = dest.get(i);
			map[c.y][c.x] = i+2;
		}
		
		q.add(new Taxi(ty,tx,F,0));//택시부터 찾기
		visited[ty][tx] = true;
		
		PriorityQueue<Taxi> pq = new PriorityQueue<>();
		
		while(!q.isEmpty()) {
			
			Taxi t = q.poll();
			
			if(t.fuel == 0) {//연료가 다달면 망함; 승객도 못태움 ㄹㅇ ㅋㅋ
				result = -1;
				continue;
			}
			
			if(!pq.isEmpty() && pq.peek().cnt < t.cnt) continue;
			
			if(map[t.y][t.x] >= 2) {//승객있으면
				t.client = map[t.y][t.x];
				pq.add(t);
			}
			
			for (int i = 0; i < 4; i++) {
				
				int nr = t.y + dr[i];
				int nc = t.x + dc[i];
				int nf = t.fuel - 1;
				int nt = t.cnt + 1;
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
				if(map[nr][nc] == 1) continue;
				if(visited[nr][nc]) continue;
				
				q.add(new Taxi(nr,nc,nf,nt));
				visited[nr][nc] = true;
				
			}
			
		}
		
		if(pq.isEmpty()) return false;
		return go(pq.poll());
		
	}

	private static boolean go(Taxi t) {
		// TODO Auto-generated method stub
		
		//System.out.println(t);
		
		Client c = dest.get(t.client - 2);
		dest.remove(t.client - 2);
		
		Queue<Taxi> q = new LinkedList();
		boolean visited[][] = new boolean[N][N];
		q.add(t);
		visited[t.y][t.x] = true;
		int dest = -1 * t.client;
		t.cnt = 0;
		
		map[c.destY][c.destX] = dest;
		map[t.y][t.x] = 0;
		
		while(!q.isEmpty()) {
			
			t = q.poll();
			
			if(map[t.y][t.x] == dest) {//성공
				t.fuel += t.cnt * 2;
				map[c.destY][c.destX] = 0;
				
				F = t.fuel;//현재 택시 위치와 기름저장
				ty = t.y;
				tx = t.x;
				
				return true;
			}
			
			if(t.fuel == 0) {//실패 연료가 다달면 망함;
				continue;
			}
			
			for (int i = 0; i < 4; i++) {
				
				int nr = t.y + dr[i];
				int nc = t.x + dc[i];
				int nf = t.fuel - 1;
				int nt = t.cnt + 1;
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
				if(map[nr][nc] == 1) continue;
				if(visited[nr][nc]) continue;
				
				q.add(new Taxi(nr,nc,nf,nt));
				visited[nr][nc] = true;
				
			}
			
		}
		return false;
		
	}

}
