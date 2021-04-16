package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 프로세서연결하기 {
	
	static int N;
	static int arr[][];
	static int res;
	
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,-1,1};
	static boolean[] check= new boolean[4];
	
	static int maxCore;
	static int leftCore;
	
	static int resCore;
	static int resLine;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			resCore=0;
			resLine=9999999;
			N = Integer.parseInt(br.readLine());
			
			arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int val=Integer.parseInt(st.nextToken());
					if(val==1) maxCore++;
					arr[i][j] =val; 
				}
			}
			leftCore=maxCore;
			recur(0,0,0);
			sb.append(resLine);
			System.out.println(sb);
		}
		
	}
	
	public static void recur(int idx , int core, int line) {
		if(idx==N*N) {//끝에 도착하면 out;
			if( resCore < core) {
				resCore=core;
				resLine=line;
				
			}
			else if(resCore ==core && resLine > line){
				resLine=line;
			}
			return;
		}
		
		int row = idx / N;
		int col = idx % N;
		if(arr[row][col] == 1 && (row == 0 || row == N-1 || col == 0 || col == N-1)) {//코어인데 가장자리이면
			recur(idx+1,core+1,line);//다음으로
		}
		else if(arr[row][col]==1) {//코어이고 가장자리가 아니면
			for (int i = 0; i < 5; i++) {
				available(row, col);//코어 이동가능 지점 표시
				if(i==4) {
					recur(idx+1,core,line); //코어를 연결안하는 경우의 수
					break;
				}
				if(check[i]==false) continue;//깔면 안되면 다음
				else {
					int l=setLine(row, col, i, 2);//깔고
					recur(idx+1,core+1,line+l);
					setLine(row, col, i, 0);//돌려놓기
				}
					
			}
		}
		else recur(idx+1,core,line);//아무곳도 아니면
		
		
	}
	
	public static int setLine(int y,int x, int dir,int val) {//전선을 깔아주거나 없애줄 친구.
		int dy=y;
		int dx=x;
		int line=0;
		
		while(true) {
			dy += dr[dir];
			dx += dc[dir];
			if(dy<0 || dx<0 || dx==N || dy==N)
				break;
			arr[dy][dx]=val;
			line++;
		}
		return line;
	}
	
	public static void available(int y, int x) {
		for (int i = 0; i < 4; i++) {
			int dy=y;
			int dx=x;
			while(true) {
				dy+=dr[i];
				dx+=dc[i];
				if(dy<0 || dx<0 || dx==N || dy==N) {//끝까지 도달
					check[i]=true;
					break;
				}
				if(arr[dy][dx]!=0) {//전선이나 코어 만나면
					check[i]=false;
					break;
				}
			}
			
		}
	}
}
