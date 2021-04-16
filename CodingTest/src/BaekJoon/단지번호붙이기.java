package BaekJoon;

import java.io.*;
import java.util.*;

public class 단지번호붙이기 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int L;
	
	static int[] dy= {-1,1,0,0}; //상하좌우
	static int[] dx= {0,0,-1,1};
	static int map[][];
	static int cnt;
	static int total;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
			L=Integer.parseInt(br.readLine());
			
			map=new int[L+2][L+2];
			
			for (int i = 1; i <= L; i++) {
				char temp[]=br.readLine().toCharArray();
				for (int j = 1; j <= L; j++) {
					map[i][j]=temp[j-1]-'0';
				}
			}
			
//			for (int i = 0; i < L+2; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
			
			ArrayList<Integer> result=new ArrayList<Integer>();
			total=0;
			for (int i = 1; i <= L; i++) {
				for (int j = 1; j <= L; j++) {
					if(map[i][j]==1) {
						cnt=0;
						go(i,j);
						result.add(cnt);
						total++;
					}
				}
			}
			Collections.sort(result);
			System.out.println(total);
			for (int i = 0; i < result.size(); i++) {
				System.out.println(result.get(i));
			}
	}
	
	public static void go(int y,int x) {
		cnt++;
		map[y][x]=0;
		for (int i = 0; i < dy.length; i++) {
			int tempY=y+dy[i];
			int tempX=x+dx[i];
			if(map[tempY][tempX]==1)
				go(tempY,tempX);
		}
	}
}
