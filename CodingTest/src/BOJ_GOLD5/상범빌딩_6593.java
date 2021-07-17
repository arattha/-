package BOJ_GOLD5;

import java.util.*;

public class 상범빌딩_6593 {
	
	static char map[][][];
	static int df[]= {0,0,0,0,-1,1};
	static int dr[]= {-1,1,0,0,0,0};
	static int dc[]= {0,0,-1,1,0,0};	
	static int res;
	
	static int L,R,C;
	
	static Node start,end;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			L = sc.nextInt();
			R = sc.nextInt();
			C = sc.nextInt();
			if(L == 0  && R == 0 && C ==0) break;
			res = Integer.MAX_VALUE;
			map = new char[L][R][C];
			for (int i = 0; i < L; i++) {
				for (int j = 0; j < R; j++) {
					char[] temp = sc.next().toCharArray();
					for (int k = 0; k < C; k++) {
						map[i][j][k]=temp[k];
						if(map[i][j][k]=='S') start = new Node(i,j,k,0);
						if(map[i][j][k]=='E') end = new Node(i,j,k,0);
					}
				}
			}
			
			bfs();
			System.out.println(res == Integer.MAX_VALUE ? "Trapped!" : "Escaped in " + res + " minute(s).");
		}
		
		
		
		
	}
	

	private static void bfs() {
		// 완성된 맵에서 bfs
		boolean visited[][][]= new boolean[L][R][C];
		Queue<Node> q = new LinkedList<>();
		
		q.offer(new Node(start.z,start.y,start.x,0));
		visited[start.z][start.y][start.x]=true;
		
		while (!q.isEmpty()) {
			Node n = q.poll();
			
			if(n.z == end.z && n.y == end.y && n.x == end.x) {
				res = Math.min(res,n.cnt);
			}
			
			for (int i = 0; i < dr.length; i++) {
				
				int nf=n.z + df[i];
				int nr=n.y + dr[i];
				int nc=n.x + dc[i];
				
				if(nf < 0 || nr < 0 || nc < 0 || nf >=L || nr >= R || nc >= C || map[nf][nr][nc]== '#' ) continue;
				if(visited[nf][nr][nc]) continue;
				
				q.offer(new Node(nf,nr,nc,n.cnt+1));
				visited[nf][nr][nc]=true;
			}
		}
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

