package BaekJoon;

import java.util.*;

public class Maaaaaaaaaze {
	
	static int input[][][];
	static int map[][][];
	static int N = 5;
	static boolean used[];
	static int shuffle[];
	static int df[]= {0,0,0,0,-1,1};
	static int dr[]= {-1,1,0,0,0,0};
	static int dc[]= {0,0,-1,1,0,0};	
	static int res;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		res = Integer.MAX_VALUE;
		input = new int[N][N][N];
		map = new int[N][N][N];
		used = new boolean[5];
		shuffle = new int[5];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					input[i][j][k]=sc.nextInt();
				}
			}
		}
		
		permutation(0);
		
		System.out.println(res == Integer.MAX_VALUE ? -1 : res);
	}
	
	//5개 뽑고
	//회전한것도 확정하고
	//그때부터 bfs
	
	public static void permutation(int cnt) {
		if(cnt==5) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					for (int k = 0; k < N; k++) {
						map[i][j][k]=input[shuffle[i]][j][k];
					}
				}
			}
			dfs(0);
			return;
		}
		for (int i = 0; i < 5; i++) {
			if(used[i]) continue;
			used[i]=true;
			shuffle[cnt]=i;
			permutation(cnt+1);
			used[i]=false;
		}
	}
	
	private static void dfs(int cnt) {
		if(cnt==5) {
			bfs();
			return;
		}
		for (int i = 0; i < 4; i++) {//총 3번회전
			dfs(cnt+1);
			rotate(cnt);//cnt번째 층 90도 회전
		}
	}

	private static void bfs() {
		// 완성된 맵에서 bfs
		boolean visited[][][]= new boolean[5][5][5];
		Queue<Node> q = new LinkedList<>();
		
		if(map[0][0][0]==0 || map[N-1][N-1][N-1]==0) return;
		
		q.offer(new Node(0,0,0,0));
		visited[0][0][0]=true;
		
		while (!q.isEmpty()) {
			Node n = q.poll();
			
			if(n.z == N-1 && n.y == N-1 && n.x == N-1) {
				res = Math.min(res,n.cnt);
			}
			if(res < n.cnt) continue;
			
			for (int i = 0; i < dr.length; i++) {
				
				int nf=n.z + df[i];
				int nr=n.y + dr[i];
				int nc=n.x + dc[i];
				
				if(nf < 0 || nr < 0 || nc < 0 || nf >=N || nr >= N || nc >= N || map[nf][nr][nc]==0 ) continue;
				if(visited[nf][nr][nc]) continue;
				
				q.offer(new Node(nf,nr,nc,n.cnt+1));
				visited[nf][nr][nc]=true;
			}
		}
	}

	public static void rotate(int floor) {//90도 회전
		int[][] temp = new int[5][5];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				temp[i][j] = map[floor][N-1-j][i];//floor층을 90도 회전 
			}
		}
		
		map[floor] = temp;
	}
	
	static class Node{
		int z,y,x,cnt;
		public Node(int z, int y, int x, int cnt) {
			this.z = z;
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}
	}
	
}
