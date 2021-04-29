package D4;

import java.util.Scanner;

public class 창용마을무리의개수 {
	
	static int team[];
	static int N,M;
	
	public static void make() {
		for (int i = 0; i < N; i++) {
			team[i]=i;
		}
	}
	
	public static int findSet(int a) {
		if(team[a]==a) return a;
		return team[a]=findSet(team[a]);
	}
	
	public static boolean union(int a,int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return false;
		team[bRoot]=aRoot;
		return true;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			
			team = new int[N+1];
			make();
			int res = N;
			for (int i = 0; i < M; i++) {
				if(union(sc.nextInt(),sc.nextInt())) {
					res--;
				}
			}
			System.out.println("#"+tc+" "+res);
		}
		
	}
	
}
