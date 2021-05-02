package D4;

import java.util.Scanner;

public class 추억의2048게임 {
	
	static int N,D;
	static String dir[] = {"up","down","left","right"};
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static int map[][];
	static boolean visited[][];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			N = sc.nextInt();
			
			map = new int[N][N];
			visited = new boolean[N][N];
			
			String str = sc.next();
			for (int i = 0; i < 4; i++) {
				if(str.equals(dir[i]))
					D = i;
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			go();
			
			System.out.println("#"+tc);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(map[i][j] +" ");
				}
				System.out.println();
			}
		}
	}
	
	public static void go() {
		switch (D) {
		case 0:
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dfs(i,j);
				}
			}
			break;
		case 1:
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dfs(N-1-i,j);
				}
			}
			break;
		case 2:
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dfs(j,i);
				}
			}
			break;
		case 3:
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dfs(j,N-1-i);
				}
			}
			break;
		}
	}
	
	public static void dfs(int y, int x) {
		
		int dy = y + dr[D];
		int dx = x + dc[D];
		int val = map[y][x];
		while(val != 0) {
			if(dy < 0 || dx < 0 || dy >= N || dx >= N) {
				map[y][x]=0;
				map[dy-dr[D]][dx-dc[D]] = val;			
				break;
			}
			
			if(map[dy][dx] == map[y][x] && visited[dy][dx]==false) {//갈 곳에 나랑 같은 수가 있으면서 합쳐진적없으면
				map[y][x]=0;
				map[dy][dx]=val*2;
				visited[dy][dx]=true;
				break;
			} else if (map[dy][dx] == map[y][x] && visited[dy][dx]==true) {
				map[y][x]=0;
				map[dy-dr[D]][dx-dc[D]] = val;
				break;
			} else if (map[dy][dx] != map[y][x] && map[dy][dx] != 0){ // 나랑 다르면서 0아니면
				map[y][x]=0;
				map[dy-dr[D]][dx-dc[D]] = val;
				break;
			}
			dy += dr[D];
			dx += dc[D];
		}
		
	}
	
}
