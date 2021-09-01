package BaekJoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 연구소_14502 {
	
	static int N,M;
	static int[][] map;
	static int[][] map2;
	static int res;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		res= 0;
		map = new int[N][M];
		map2 = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		wall(0);
		
		System.out.println(res);
	}
	
	public static void deepCopy(){
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map2[i][j]=map[i][j];
			}
		}
	}
	public static void checkResult() {
		// TODO Auto-generated method stub
		int check=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map2[i][j]==0)
					check++;
			}
		}
		
		if(res<check)
			res=check;
			
	}
	
	public static void wall(int cnt) {
		if(cnt==3) {
			deepCopy();//복사해주고
			biohazard();	
			checkResult();
			return;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]==0) {
					map[i][j]=1;//벽세워보고
					wall(cnt+1);
					map[i][j]=0;//허물고
				}
			}
		} 
	}

	

	static int dr[]= {-1,1,0,0};
	static int dc[]= {0,0,-1,1};
	
	static class Virus{
		int y;
		int x;
		public Virus(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
	
	private static void biohazard() {
		// TODO Auto-generated method stub
		Queue<Virus> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map2[i][j]==2) {
					q.offer(new Virus(i,j));
				}
					
			}
		}
		
		while(!q.isEmpty()){
			
			Virus v = q.poll();
			
			for (int d = 0; d < dc.length; d++) {
				
				int nr=v.y+dr[d];
				int nc=v.x+dc[d];
				
				if(nr<0 || nc <0 || nr >=N || nc >=M) continue;
				
				if(map2[nr][nc]==0) {
					map2[nr][nc]=2;
					q.offer(new Virus(nr,nc));
				}
			}
			
		}
		
	}
	

}
