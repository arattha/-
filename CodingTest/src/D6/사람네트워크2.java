package D6;

import java.util.Arrays;
import java.util.Scanner;

public class 사람네트워크2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt();
			int map[][] = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j]=sc.nextInt();
					if(i != j && map[i][j]==0) {//자기자신으로의 인접 정보가 아니고 인접해있지 않다면 INF로 채우기
						map[i][j]=9999999;
					}
				}
			}
			System.out.println();
			for(int k=0; k<N; ++k) {
				for(int i=0; i<N; ++i) {
					if(i==k) continue; // 출발지와 경유지가 같다면 다음 출발지
					for(int j=0; j<N; ++j) {
						if(i==j || k==j) continue; 
						// 경유지와 목적지가 같거나 출발지가 곧 목적지라면 패스
						if(map[i][j] > map[i][k]+map[k][j]) {
							map[i][j] = map[i][k]+map[k][j];
						}
					}
					
				}
			}
			int min=Integer.MAX_VALUE;
			
			for (int i = 0; i < N; i++) {
				int sum=0;
				for (int j = 0; j < N; j++) {
					sum+=map[i][j];
				}
				if(min>sum)
					min=sum;
			}
			System.out.println("#"+tc+" "+min);
		}
		
		
	}

}
