package D4;

import java.util.Scanner;

public class 서로소집합 {
	
	
	static int N,M;
	static int[] set;
	
	public static void makeSet() {
		
		for (int i = 0; i <= N; i++) {
			set[i]=i;
		}
	}
	
	public static int findSet(int a) {
		
		if(set[a]==a) return a;
		
		return set[a]=findSet(set[a]);
		
	}
	
	public static boolean unionSet(int a, int b) {
		int aRoot=findSet(a);
		int bRoot=findSet(b);
		if(aRoot==bRoot) return false;
		set[bRoot]=aRoot;
		return true;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();	
		for (int tc = 1; tc <= T; tc++) {
			
			sb.append("#"+tc+" ");
			N=sc.nextInt();
			M=sc.nextInt();
			set=new int[N+1];

			makeSet();
			
			for (int i = 0; i < M; i++) {
				int sel=sc.nextInt();
				int a=0;
				int b=0;
				
				switch (sel) {
				case 0:
					a=sc.nextInt();
					b=sc.nextInt();
					unionSet(a, b);
					break;
				case 1:
					int aRoot = findSet(sc.nextInt());
					int bRoot = findSet(sc.nextInt());
					if(aRoot==bRoot)
						sb.append(1);
					else
						sb.append(0);
					break;
				}
			}
			sb.append('\n');
		
		}
		System.out.print(sb);
	}

}
