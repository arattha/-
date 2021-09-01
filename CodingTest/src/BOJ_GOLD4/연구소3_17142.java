package BOJ_GOLD4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연구소3_17142 {
	
	static int N,M;
	static int map[][];
	static int map2[][];
	static ArrayList<Point> virus;
	static Point[] selectedV;
	static int zeroCnt;
	static int res;
	static int max;
	
	static class Point{
		
		int y,x;
		int time;
		
		public Point(int y, int x, int time) {
			super();
			this.y = y;
			this.x = x;
			this.time = time;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		zeroCnt = 0;
		
		map = new int[N][N];
		virus = new ArrayList<>();
		selectedV = new Point[M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) {
					zeroCnt++;
				}
				if(map[i][j] == 1) {
					map[i][j] *= -1;//벽은 그냥 음수로 둠
				}
				if(map[i][j] == 2) {
					virus.add(new Point(i,j,0));
					map[i][j] *= -1;//비활성으로 디폴트
				}
			}
		}
		res = Integer.MAX_VALUE;
		dfs(0,0);
		
		if(zeroCnt == 0) {
			res = 0;
		}
		
		System.out.println(res == Integer.MAX_VALUE ? -1 : res);
	}

	private static void dfs(int cnt, int start) {
		// TODO Auto-generated method stub
		if(cnt == M) {
			deepCopy();
			biohazard();
			
			return;
		}
		
		for (int i = start; i < virus.size(); i++) {
			Point p = virus.get(i);
			selectedV[cnt] = p;
			dfs(cnt+1,i+1);
		}
	}
	
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static boolean visited[][];
	
	private static void biohazard() {
		// TODO Auto-generated method stub
		
		int vCnt = 0;
		
		Queue<Point> q = new LinkedList<>();
		visited = new boolean[N][N];
		
		for (int i = 0; i < M; i++) {
			Point p = selectedV[i];
			q.add(p);
			visited[p.y][p.x] = true;
		}
		
		while(!q.isEmpty()){
			Point v = q.poll();
			
			if(v.time > res) break;
			
			for (int d = 0; d < dc.length; d++) {
				
				int nr=v.y+dr[d];
				int nc=v.x+dc[d];
				int nt=v.time + 1;
				
				if(nr<0 || nc <0 || nr >=N || nc >=N) continue;
				if(map2[nr][nc] == -1) continue;
				if(visited[nr][nc]) continue;
				
				if(map2[nr][nc] == 0) {
					vCnt++;
					map2[nr][nc]=2;
					q.offer(new Point(nr,nc,nt));
					visited[nr][nc] = true;
					
					if(vCnt == zeroCnt) {
						res = Math.min(res, nt);
						return;
					}
				} else {//-2인 경우
					map2[nr][nc]=2;
					q.offer(new Point(nr,nc,nt));
					visited[nr][nc] = true;
				}
			}
		}
	}
	
	public static void deepCopy(){
		map2 = new int[N][N];
		for (int i = 0; i < N; i++) {
			map2[i] = map[i].clone();
		}
	}
}
