package BaekJoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 감시 {
	
	static int N,M;
	static int res;
	static int map[][];
	static int camera[][] = {{},{1},{1,3},{0,1},{0,1,3},{0,1,2,3}};
	static ArrayList<Node> cctv = new ArrayList<>();
	
	static int dr[] = {0,1,0,-1};//시계방향
	static int dc[] = {-1,0,1,0};
	
	static class Node{
		int y,x,cctv;

		public Node(int y, int x, int cctv) {
			this.y = y;
			this.x = x;
			this.cctv = cctv;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		
		res = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j]>0 && map[i][j]<6) {
					cctv.add(new Node(i,j,map[i][j]));
				}
			}
		}
		
		cal(0,copy(map));
		
		System.out.println(res);
	}
	
	public static int[][] copy(int[][] map){
		int temp[][] = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[i][j]=map[i][j];
			}
		}
		
		return temp;
	}
	
	private static void cal(int idx,int[][] tmp) {
		// TODO Auto-generated method stub
		if(idx == cctv.size()) {//모든 카메라에 대해서
			int cnt=0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(tmp[i][j]==0) cnt++;
				}
			}
			
			res = Math.min(res, cnt);
			return;
		}
		
		
		for (int i = 0; i < 4; i++) {//0 90 180 270
			int map[][]= copy(tmp);
			
			for (int j = 0; j < camera[cctv.get(idx).cctv].length; j++) {
				//현재 카메라가 볼 수 있는 방향의 갯수
				int dir =( camera[cctv.get(idx).cctv][j]+i ) % 4;
				int nr = cctv.get(idx).y;
				int nc = cctv.get(idx).x;
				
				
				while (true) {
					nr += dr[dir];
					nc += dc[dir];
					if(nr<0 || nc<0 || nr >= N || nc >=M || map[nr][nc]==6) break;
					map[nr][nc] = 7;
				}
				
			}
			
			cal(idx+1,map);
		}
		
	}

}
