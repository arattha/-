package BaekJoon;

import java.io.*;
import java.util.*;

import BaekJoon.나무재테크.Tree;

public class 직사각형탈출 {
	
	static int N,M;
	static int H,W;
	static int Sr,Sc,Fr,Fc;
	static int map[][];
	static boolean visited[][];
	
	static class Node{
		int y,x,cnt;
		
		public Node(int y, int x, int cnt) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}
	}
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		int res=-1;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		Sr = Integer.parseInt(st.nextToken())-1;
		Sc = Integer.parseInt(st.nextToken())-1;
		Fr = Integer.parseInt(st.nextToken())-1;
		Fc = Integer.parseInt(st.nextToken())-1;
		
		Queue<Node> q = new LinkedList<>();
		
		visited[Sr][Sc]=true;
		q.offer(new Node(Sr,Sc,0));
		
		while (!q.isEmpty()) {
			Node n = q.poll();
			
			if(n.y == Fr && n.x == Fc) {//도착시 탈출
				res = n.cnt;
				break;
			}
			
			for (int i = 0; i < dr.length; i++) {
				int nr = n.y + dr[i];
				int nc = n.x + dc[i];
				if(nr < 0 || nc < 0 || nr > N-H || nc > M-W || visited[nr][nc]) continue;
				if(check(i,n.y,n.x)) continue;
				
				visited[nr][nc]=true;
				q.offer(new Node(nr,nc,n.cnt+1));
				
			}
			
		}
		System.out.println(res);
	}

	private static boolean check(int dir,int y, int x) {
		// TODO Auto-generated method stub
		
		if(dir == 0 ) {//위로갈때
			for (int i = 0; i < W; i++) {//내 한칸 위 길이만큼 보는데 1이 있으면
				if(map[y-1][x+i]==1) return true;
			}
		}
		else if(dir == 1 ) {//하로갈때
			for (int i = 0; i < W; i++) {//내 한칸 왼쪽 길이만큼 보는데 1이 있으면
				if(map[y+H][x+i]==1) return true;
			}
		}
		else if(dir == 2 ) {//좌로갈때
			for (int i = 0; i < H; i++) {//내 한칸 왼쪽 길이만큼 보는데 1이 있으면
				if(map[y+i][x-1]==1) return true;
			}
		}
		else if(dir == 3 ) {//우로갈때
			for (int i = 0; i < H; i++) {//내 한칸 왼쪽 길이만큼 보는데 1이 있으면
				if(map[y+i][x+W]==1) return true;
			}
		}
		return false;
	}

}
