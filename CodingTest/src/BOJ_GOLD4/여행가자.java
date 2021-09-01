package BOJ_GOLD4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 여행가자 {
	
	static int arr[];
	
	public static void init() {
		for (int i = 0; i < arr.length; i++) {
			arr[i]=i;
		}
	}
	
	public static int findSet(int a) {
		if(arr[a]==a) return a;
		return arr[a]=findSet(arr[a]);
	}
	
	public static boolean union(int a,int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return false;
		
		arr[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		init();
		
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int t = Integer.parseInt(st.nextToken());
				if(t==1) union(i,j);
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int a = findSet(Integer.parseInt(st.nextToken()) - 1);
		boolean flag =true;
		
		for (int i = 0; i < M - 1; i++) {
			int t = Integer.parseInt(st.nextToken());
			if(a != findSet(t - 1)) flag = false;
		}
		if(flag) System.out.println("YES");
		else System.out.println("NO");
	}

}
