package sam;

import java.util.*;

public class 구슬탈출2 {
	
	static char[][] map;
	static int N,M;
	
	static int rx,ry,bx,by,gy,gx;
	
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new char[N][M];
		
		
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'R') {
					map[i][j] = '.';
					ry = i;
					rx = j;
				} else if(map[i][j] == 'B') {
					map[i][j] = '.';
					by = i;
					bx = j;
				} else if(map[i][j] == 'O') {
					gy = i;
					gx = j;
				}
			}
		}
		
		bfs();
		System.out.println(res == Integer.MAX_VALUE ? -1 : res);
	}
	
	static class Node{
		int y,x;
		int cnt;
		
		public Node(int y, int x , int cnt) {
			super();
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}
		
	}
	
	static int res;
	static boolean visited[][][][];
	
	private static void bfs() {
		// TODO Auto-generated method stub
		visited = new boolean[N][M][N][M];
		res = Integer.MAX_VALUE;
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(ry,rx,0));
		q.add(new Node(by,bx,0));
		
		visited[ry][rx][by][bx] = true;
		
		while(!q.isEmpty()) {
			
			Node red = q.poll();
			Node blue = q.poll();
			
			if(red.cnt > 10 || red.cnt >= res) {
				continue;
			}
			
			if(red.y == gy && red.x == gx) {
				res = Math.min(res, red.cnt);
				return;
			}
			
			for (int i = 0; i < 4; i++) {
				
//				System.out.println(red.cnt);
//				System.out.println(red.x+" "+red.y);
//				System.out.println(blue.x+" "+blue.y);
				int nr[] = move(red.x,red.y, i);
				int nb[] = move(blue.x,blue.y, i);
				
				if(map[nb[0]][nb[1]] == 'O') continue;
				
				if(nr[0] == nb[0] && nr[1] == nb[1]) {
					
					switch (i) {
					case 0:
						if(red.y < blue.y) {//red가 더 위에있으면
							nb[0] -= dr[i];
							nb[1] -= dc[i];
						} else {
							nr[0] -= dr[i];
							nr[1] -= dc[i];
						}
						break;
					case 1:
						if(red.y > blue.y) {//red가 더 밑에있으면
							nb[0] -= dr[i];
							nb[1] -= dc[i];
						} else {
							nr[0] -= dr[i];
							nr[1] -= dc[i];
						}
						break;
					case 2:
						if(red.x < blue.x) {//red가 더 왼쪽에있으면
							nb[0] -= dr[i];
							nb[1] -= dc[i];
						} else {
							nr[0] -= dr[i];
							nr[1] -= dc[i];
						}
						break;
					case 3:
						if(red.x > blue.x) {//red가 더 오른쪽에있으면
							nb[0] -= dr[i];
							nb[1] -= dc[i];
						} else {
							nr[0] -= dr[i];
							nr[1] -= dc[i];
						}
						break;
					}
					
				}
//				System.out.println("red :" + nr[1] + " " + nr[0]);
//				System.out.println("blue :" + nb[1] + " " + nb[0]);
				
				if(visited[nr[0]][nr[1]][nb[0]][nb[1]]) continue;
				
				q.add(new Node(nr[0],nr[1],red.cnt+1));
				q.add(new Node(nb[0],nb[1],blue.cnt+1));
				visited[nr[0]][nr[1]][nb[0]][nb[1]] = true;
				
				
				
			}
			
		}
		
	}
	
	private static int[] move(int x, int y, int dir) {
		int[] res = new int[2];
		
		while(true) {
			
			y += dr[dir];
			x += dc[dir];
			
			if(map[y][x] == '#') {
				y -= dr[dir];
				x -= dc[dir];
				break;
			}
			if(map[y][x] == 'O') break;
		}
		
		res[0] = y;
		res[1] = x;
		
		return res;
	}

}
