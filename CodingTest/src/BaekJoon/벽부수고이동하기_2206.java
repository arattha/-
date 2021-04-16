package BaekJoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 벽부수고이동하기_2206 {
	
	static class Node {
		int y;
		int x;
		int br;
		int len;
		public Node(int y, int x,int br,int len) {
			super();
			this.y = y;
			this.x = x;
			this.br=br;
			this.len=len;
		}
	}
	static int N,M;
	static int[][] map;
	static boolean[][][] visited;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		N=sc.nextInt();
		M=sc.nextInt();
		map = new int[N][M];
		visited = new boolean[N][M][2];
		
		for (int i = 0; i < N; i++) {
			char str[]=sc.next().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j]=(int)str[j]-'0';
				map[i][j]=(int)str[j]-'0';
			}
		}
		
		bfs(0,0,1,1);
		System.out.println(res == Integer.MAX_VALUE ? -1 : res );
	}
	
	static int dr[]= {-1,1,0,0};
	static int dc[]= {0,0,-1,1};
	static int res=Integer.MAX_VALUE;
	public static void bfs( int y,int x , int br ,int len) {
		
		Queue<Node> q = new LinkedList<Node>();
		q.offer(new Node(y,x,br,len));
		visited[y][x][0]=true;
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			//System.out.println("y "+n.y +" x "+n.x+" len "+n.len);
			if(n.y == N-1 && n.x == M-1) {
				res = Math.min(res, n.len);
			}
			
			for (int i = 0; i < dc.length; i++) {//1이면 한칸 내리고 출발해봐야함.
				int tmpY=n.y+dr[i];
				int tmpX=n.x+dc[i];
				if(tmpY < 0 || tmpX < 0 || tmpY == N || tmpX == M) continue;
				//내가 이동할 곳이 이미 가본 길이면,
				
				//안부수고 이동하는 놈의 세상
				if(n.br==1) {
					//안 부순놈의 세상에서,
					if(!visited[tmpY][tmpX][0] && map[tmpY][tmpX]==1) {//벽이 있고, 부숴 본 적 없고, 부술수 있으면
						//visited[tmpY][tmpX][1]=2;
						//부숴본 벽 체크 부숴본 벽은 다시 부수지 않는다.
						visited[tmpY][tmpX][1]=true;
						q.offer(new Node(tmpY,tmpX,n.br-1,n.len+1));
					}
					if(!visited[tmpY][tmpX][0] && map[tmpY][tmpX]==0) {
						visited[tmpY][tmpX][0]=true;
						q.offer(new Node(tmpY,tmpX,n.br,n.len+1));
					}
				}
				if(n.br==0) {
					// 부수지 않은 상태에서의 접근 은 가능
					if(!visited[tmpY][tmpX][1] && map[tmpY][tmpX]==0) {
						visited[tmpY][tmpX][1]=true;
						q.offer(new Node(tmpY,tmpX,n.br,n.len+1));
					}
				}
			}
		
		}
		
	}
	
}
