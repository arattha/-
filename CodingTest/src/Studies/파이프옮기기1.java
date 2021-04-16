package Studies;

import java.util.Scanner;

public class 파이프옮기기1 {
	
	static int N;
	static int map[][];
	
	static int dr[]= {0,1,1};
	static int dc[]= {1,1,0};
	
	static int X,Y,res;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		res=0;
		X=0;
		Y=0;//뒷부분
		
		dfs(0,1);
		
		System.out.println(res);
	}
	
	public static void dfs(int y,int x) {
		
		if(y==N-1 && x==N-1) {
			res++;
			return;
		}
		
		int end=3;
		int i=0;
		
		if(y-Y == 0 && x-X==1) {//가로
			end--;
		}
		if(y-Y == 1 && x-X==0) {
			i++;
		}
		
		for (; i < end; i++) {
			
			if(isVaild(x,y,i)) {
				X=x;
				Y=y;
				dfs(y+dr[i],x+dc[i]);
			}
			
		}
		
	}

	private static boolean isVaild(int x, int y,int dir) {
		// TODO Auto-generated method stub
		int tmpX=x+dc[dir];
		int tmpY=y+dr[dir];
		
		if(tmpX==N || tmpY==N) {
			return false;
		}
		
		if(dir == 0 || dir ==2) {//가로,세로로 갈 예정
			if(map[y+dr[dir]][x+dc[dir]]==0)
				return true;
		}
		if(dir == 1) {//대각선 판정
			if(map[y+dr[0]][x+dc[0]]==0 && map[y+dr[1]][x+dc[1]]==0 && map[y+dr[2]][x+dc[2]]==0)
				return true;
		}
		return false;
	}
	
}
