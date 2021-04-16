package Studies;

import java.util.Scanner;

public class 색종이붙이기 {

	static int map[][] = new int[10][10];
	static int N=10;
	static int paper[]= {0,5,5,5,5,5};
	static int res;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		res=Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		dfs(0,0);
		
		if(res==Integer.MAX_VALUE)
			res=-1;
		
		System.out.println(res);
		
		
		
	}

	public static void dfs(int idx,int cnt) {
		// TODO Auto-generated method stub
		
		if(idx==100) {
			res=Math.min(res, cnt);
			return;
		}
		
		if(res <= cnt) {
			return;
		}
		
		int col=idx%10;
		int row=idx/10;
		
		if(map[row][col]==1) {
			for (int i = 5; i >0; i--) {
				if(paper[i]>0) {
					if(check(row,col,i)) {
						attach(row,col,i,0);
						paper[i]--;
						dfs(idx+1,cnt+1);
						attach(row,col,i,1);
						paper[i]++;
					}
				}
			}
		}
		else
			dfs(idx+1,cnt);
	}
	
	private static boolean check(int row, int col, int len) {

		if(row+len>N || col+len>N)
			return false;
		
		for (int i = row; i < row+len; i++) {
			for (int j = col; j < col+len; j++) {
				if(map[i][j]==0)
					return false;
			}
		}
		
		return true;
	}

	
	public static void attach(int y, int x , int len, int val) {
		
		for (int i = y; i < y+len; i++) {
			for (int j = x; j < x+len; j++) {
				map[i][j]=val;
			}
		}
		
	}
}
