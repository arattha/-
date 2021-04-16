package BaekJoon;

import java.util.Scanner;

public class 캐슬디펜스 {
	
	static int N,M,range;
	static int map[][];
	static int map2[][];
	
	static int archer[];
	static int enemy,totalEnemy;
	static int res;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		range = sc.nextInt();
		
		map = new int[N][M];
		map2 = new int[N][M];
		archer=new int[3];
		
		totalEnemy=0;
		res=0;
		
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j]=sc.nextInt();
				if(map[i][j]==1)
					totalEnemy++;
			}
		}
		
		comb(0,0);
		
		System.out.println(res);
		
	}
	
	public static void comb(int cnt,int start) {
		if(cnt==3) {
			enemy=totalEnemy;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map2[i][j]=map[i][j];
				}
			}
			defence();
			return;
		}
		
		for (int i = start; i < M; i++) {
			archer[cnt]=i;
			comb(cnt+1,i+1);
		}
		
	}

	private static void defence() {
		
		int kill=0;
		while(enemy!=0) {
			
			boolean killed[][]=new boolean[N][M];
			
			for (int i = 0; i < archer.length; i++) {
				int archerY=N;
				int archerX=archer[i];
				loop: for (int j = 1; j <= range; j++) {
					
					for (int q = 1; q <= j; q++) {//삼각탐색 왼쪽부분
						
						if(archerY-q < 0 || archerX-(j-q) < 0 || archerX-(j-q) >= M || archerY-q >= N ) {
							continue;
						}
						if(killed[archerY-q][archerX-(j-q)]) {//만약 true인걸 찾으면? 같은걸 쏜것.
							break loop;
						}
						if(map2[archerY-q][archerX-(j-q)]==1) {//적이있고
							killed[archerY-q][archerX-(j-q)]=true;
							map2[archerY-q][archerX-(j-q)]=0;
							enemy--;
							kill++;
							break loop;
						}
						
					}
					for (int q = j-1; q >0 ; q--) {
						if(archerY-q < 0 || archerX+(j-q) < 0 || archerX+(j-q) >= M || archerY-q >= N ) {
							continue;
						}
						if(killed[archerY-q][archerX+(j-q)]) {//만약 true인걸 찾으면? 같은걸 쏜것.
							break loop;
						}
						if(map2[archerY-q][archerX+(j-q)]==1) {//적이있고
							killed[archerY-q][archerX+(j-q)]=true;
							map2[archerY-q][archerX+(j-q)]=0;
							enemy--;
							kill++;
							break loop;
						}
					}
				}
			}
			
			//공격이 끝나면.
			for (int i = N-1; i >= 0; i--) {
				for (int j = 0; j < M; j++) {
					if(map2[i][j]==1) {
						map2[i][j]=0;
						if(i+1 != N) {//끝줄이 아니라면
							map2[i+1][j]=1;
						}
						else
							enemy--;
					}
				}
			}
		}
		res=Math.max(res, kill);
	}
	
}
