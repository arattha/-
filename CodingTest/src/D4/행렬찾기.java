package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 행렬찾기 {
	
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<box> boxArr;
	static class box implements Comparable<box>{
		
		int row;
		int col;
		
		public box(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
		
		@Override
		public int compareTo(box o) {
			// TODO Auto-generated method stub
			if((this.row*this.col) - (o.row * o.col)==0) {
				return this.row-o.row;
			}
			
			return (this.row*this.col) - (o.row * o.col);
		}
		
		
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = null;
			
			map = new int[N][N];
			visited = new boolean[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			boxArr = new ArrayList<>();
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!visited[i][j] && map[i][j]!=0) {
						find(i,j);
					}
				}
			}
			
			Collections.sort(boxArr);
			
			System.out.print("#"+tc+" "+boxArr.size()+" ");
			
			for (int i = 0; i < boxArr.size(); i++) {
				System.out.print(boxArr.get(i).row+" "+boxArr.get(i).col+" ");
			}
			System.out.println();
			
		}
	}

	private static void find(int y, int x) {
		// TODO Auto-generated method stub
		int xl=0;
		int yl=0;
		
		int xLen=0;
		int yLen=0;
		while(true) {
			if((x+xLen) == N || map[y][x+xLen]==0) {
				xl=xLen;
				break;
			}
			xLen++;
		}
		while(true) {
			if( (y+yLen) == N || map[y+yLen][x]==0) {
				yl=yLen;
				break;
			}
			yLen++;
		}
		
		for (int i = y; i < y+yl; i++) {
			for (int j = x ; j < x+xl; j++) {
				visited[i][j]=true;
			}
		}
		
		boxArr.add(new box(yl,xl));
		
	}
	
	

}
