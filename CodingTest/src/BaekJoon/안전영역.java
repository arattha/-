package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 안전영역 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int L;
	
	static int[] dy= {-1,1,0,0}; //상하좌우 좌상 우상 좌하 우하
	static int[] dx= {0,0,-1,1};
	static int map[][];
	static int result;
	static int tempMap[][];
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
			StringTokenizer st = new StringTokenizer(br.readLine());
			L=Integer.parseInt(st.nextToken());
			map=new int[L+2][L+2];
			
			for (int i = 1; i <= L; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= L; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			result=Integer.MIN_VALUE;
			int max=-1;
			for (int i = 1; i <= L; i++) {
				for (int j = 1; j <= L; j++) {
					if(max<map[i][j]) max=map[i][j];
				}
			}
			tempMap=new int[L+2][L+2];
			for (int k = max; k >= 0; k--) {
				int cnt=0;
				deepCopy();
				
				for (int i = 1; i <= L; i++) {
					for (int j = 1; j <= L; j++) {
						if(tempMap[i][j]>k) {
							cnt++;
							go(i,j,k);
						}
					}
				}
				if(result<cnt)
					result=cnt;
			}
			System.out.println(result);
	}
	
	public static void go(int y,int x,int k) {
		tempMap[y][x]=0;
		for (int i = 0; i < dy.length; i++) {
			int tempY=y+dy[i];
			int tempX=x+dx[i];
			if( tempMap[tempY][tempX] > k )
				go(tempY,tempX,k);
		}
	}	
	
	public static void deepCopy() {
		for (int i = 1; i <= L; i++) {
			for (int j = 1; j <= L; j++) {
				tempMap[i][j]=map[i][j];
			}
		}
	}
}
