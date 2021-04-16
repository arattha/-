package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class 파이프옮기기1 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int N;
	static int res;
	static int X,Y;
	static int[][] map;
	static int dr[]= {0,1,1};//우, 우하, 하
	static int dc[]= {1,1,0};
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		N=Integer.parseInt(br.readLine());
		res=0;
		map=new int[N][N];
		StringTokenizer st;
		
		for (int i = 0; i < N; i++) {
			st= new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		X=0;
		Y=0;
		
		recur(0,1);
		System.out.println(res);
	}
	private static void recur(int y,int x) {
		// TODO Auto-generated method stub
		
		if(x == N-1 && y==N-1) {
			res++;
			return;
		}
		
		int i=0;
		int end=dr.length;
		
		//y가 1차이 세로 , x가 1차이 가로 , x,y 1차이 대각
		
		if(x-X==1 && y-Y==0) {//우
			end--;
		}
		else if(x-X==0 && y-Y==1) {//하
			i++;
		}
		
		for (; i < end; i++) {
			if(checked(i,x,y)) {
				X=x;//파이프 뒷부분
				Y=y;
				recur(y+dr[i],x+dc[i]);
			}
		}
	}
	
	private static boolean checked(int i, int x,int y) {
		// TODO Auto-generated method stub
		int tempX=x+dc[i];
		int tempY=y+dr[i];
		
		if(tempX >= N || tempY >=N)//경계밖
			return false;
		
		if(i==0 || i==2) {
			if(map[tempY][tempX]==1)
				return false;
		}
		else if(i==1) {
			if(map[y][tempX]==1 || map[tempY][x] == 1 || map[tempY][tempX] == 1)
				return false;
		}	
		
		return true;
	}

}
