package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 말이되고픈원숭이_1600 {
	
	static int K,W,H;
	
	static int dr[]= {-1,1,0,0,-2,-2,-1,-1,1,1,2,2};
	static int dc[]= {0,0,-1,1,-1,1,-2,2,-2,2,-1,1};
	
	static int map[][];
	static boolean visited[][][];
	
	static class Node{
		
		int y,x,len;
		int k;
		
		public Node(int y, int x, int len, int k) {
			super();
			this.y = y;
			this.x = x;
			this.len = len;
			this.k = k;
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		K=Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		W=Integer.parseInt(st.nextToken());
		H=Integer.parseInt(st.nextToken());
		
		map= new int[H][W];
		visited= new boolean[H][W][K+1];
		
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<Node> q = new LinkedList<>();
		
		q.offer(new Node(0,0,0,K));
		for (int i = 0; i <= K; i++) {
			visited[0][0][i]=true;
		}
		visited[0][0][0]=true;
		int res=Integer.MAX_VALUE;
		
		while (!q.isEmpty()) {
			
			Node n = q.poll();
			
			if(n.y == H-1 && n.x == W-1) {
				res=Math.min(res,n.len);
			}
			
			if(n.len > res) continue;
			
			for (int i = 0; i < dr.length; i++) {
				int tmpY=n.y+dr[i];
				int tmpX=n.x+dc[i];
				
				if(n.k == 0 && i>3) continue;
				if(tmpY < 0 || tmpX < 0 || tmpY >= H || tmpX >= W) continue;
				
				if(i<=3) {//일반 이동
					if(!visited[tmpY][tmpX][n.k] && map[tmpY][tmpX] != 1) {
						q.offer(new Node(tmpY,tmpX,n.len+1,n.k));
						visited[tmpY][tmpX][n.k]=true;
					}
				}
				else {//말이동
					if(!visited[tmpY][tmpX][n.k-1] && map[tmpY][tmpX]!=1) {
						q.offer(new Node(tmpY,tmpX,n.len+1,n.k-1));
						visited[tmpY][tmpX][n.k-1]=true;	
					}
				}
			}
		}
		System.out.println(res == Integer.MAX_VALUE ? -1 : res );
	}
}
