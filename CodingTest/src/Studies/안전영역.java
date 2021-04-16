package Studies;

import java.util.Scanner;

public class 안전영역 {
	
	static int N;
	static int map[][];
	static boolean visited[][];
	static int max;
	
	static int dr[]= {-1,1,0,0};
	static int dc[]= {0,0,-1,1};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new int[N][N];
		
		max = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j]=sc.nextInt();
				if(map[i][j] > max)
					max = map[i][j];//최대높이 저장
			}
		}
		
		int res=0;
		for (int k = max; k >= 0; k--) {
			
			visited = new boolean[N][N];
			int cnt=0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!visited[i][j] && map[i][j]>k) {//안갔었으면
						cnt++;
						land(i,j,k);
					}
				}
			}
			
			if(res<cnt) {
				res=cnt;
			}
			
		}
		
		System.out.println(res);
		
	}
	private static void land(int y,int x,int water) {
		
		visited[y][x]=true;
		
		for (int i = 0; i < dc.length; i++) {
			int tmpY=y+dr[i];
			int tmpX=x+dc[i];
			
			if(tmpY>=0 && tmpX>=0 && tmpY<N && tmpX<N && !visited[tmpY][tmpX] && map[tmpY][tmpX] > water) {
				land(y+dr[i],x+dc[i],water);
			}
		}
		
	}

}
