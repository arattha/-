package BOJ_GOLD4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 집합의표현 {
	
	static int N,M;
	static int set[];
	
	static void init() {
		for (int i = 1; i <= N; i++) {
			set[i]=i;
		}
	}
	static int findSet(int a) {
		if(set[a] == a) return a;
		return set[a] = findSet(set[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot == bRoot) return false;
		set[bRoot] = aRoot;
		
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		set = new int[N+1];
		
		init();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int d = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(d == 0) {
				union(a,b);
			}else {
				if(findSet(a) == findSet(b)) sb.append("YES").append("\n");
				else sb.append("NO").append("\n");
			}
		}
		System.out.println(sb);
	}

}
