package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이붙이기v2 {

	static int N=10;
	static int arr[][]= new int[N][N];
	static boolean attached[][]=new boolean[N][N];
	static int paper[]= {0,5,5,5,5,5};
	static int res=Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int i = 0; i < N; i++) {
			st=new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		backTrack(0,0);
		
		if(Integer.MAX_VALUE==res)
			System.out.println("-1");
		else
			System.out.println(res);
	}

	private static void backTrack(int idx, int cnt) {
		// TODO Auto-generated method stub
		
		if(idx==100) {
			res=Math.min(cnt,res);
			return;
		}
		if(res <= cnt) return;
		
		int i=idx/10;
		int j=idx%10;
		
		if(arr[i][j]==1) {
			for (int t = 5; t > 0; t--) {
				if(paper[t] > 0) {
					if(check(i,j,t)) {
						attach(i,j,t,0);
						paper[t]--;
						backTrack(idx+1,cnt+1);
						attach(i,j,t,1);
						paper[t]++;
					}
				}
			}	
		}	
		else {
			backTrack(++idx,cnt);
		}
	}
	
	private static boolean check(int i,int j,int t) {
		if(i+t > N || j+t > N ) {//영역넘거나 색종이가 없으면
			return false;
		}
		for (int p = 0; p < t; p++) {//붙일수 있는지 체크
			for (int q = 0; q < t; q++) {
				if(arr[i+p][j+q]==0) {
					return false;
				}
			}
		}		
		return true;
	}
	private static void attach(int i, int j,int t,int val) {
		// TODO Auto-generated method stub
		for (int p = 0; p < t; p++) {
			for (int q = 0; q < t; q++) {
				arr[i+p][j+q]=val;//붙이고
			}
		}
		
	}
}
