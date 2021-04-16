package BaekJoon;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 달이차오른다가자_1194 {
	
	static int N,M;
	static char[][] map;
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,-1,1};
	static boolean visited[][][];
	static int KEY=6;
	static class Node{
		int y;
		int x;
		int cnt;
		int key;
		public Node(int y, int x,int cnt,int key) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
			this.key = key;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		int res= Integer.MAX_VALUE;
		map = new char[N][M];
		
		visited = new boolean[N][M][1 << KEY]; //KEY의 종류만큼 visited배열을 생성
		
		for (int i = 0; i < N; i++) {
			map[i]=sc.next().toCharArray();
		}
		
		Queue<Node> q = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if('0'== map[i][j]) {
					q.offer(new Node(i,j,0,0));
					map[i][j]='.';
					visited[i][j][0]=true;
				}
			}
		}
		
		while(!q.isEmpty()) {
			
			Node n = q.poll();
			
			if(map[n.y][n.x]=='1') {
				res = Math.min(res, n.cnt);
				break;
			}
			
			if(n.cnt > res) continue;
			
			for (int i = 0; i < dr.length; i++) {
				
				int nr = n.y+dr[i];
				int nc = n.x+dc[i];
				
				if(nr< 0 || nc < 0 || nr >= N || nc >= M) continue;
				if(visited[nr][nc][n.key] || map[nr][nc]=='#') continue;
				
				if(map[nr][nc]=='.' || map[nr][nc]=='1') {
					visited[nr][nc][n.key]=true;
					q.offer(new Node(nr,nc,n.cnt+1,n.key));
				}
				else {//열쇠나 문이면?
					if(map[nr][nc] >= 'a') {//열쇠
						int key = n.key | (1 << (map[nr][nc]-'a'));
						
						visited[nr][nc][n.key]=true;
						visited[nr][nc][key]=true;
						q.offer(new Node(nr,nc,n.cnt+1,key));
							
					} else { //문
						if(((n.key >> map[nr][nc]-'A') & 1) == 1) {//문 열수 있으면
							visited[nr][nc][n.key]=true;
							q.offer(new Node(nr,nc,n.cnt+1,n.key));
						}
					}
				}
			}
		}
		
		System.out.println(res == Integer.MAX_VALUE ? -1 : res);
	}

}
