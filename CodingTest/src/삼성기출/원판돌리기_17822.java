package 삼성기출;

import java.util.Arrays;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class 원판돌리기_17822 {
	
	static int map[][];
	static int N,M;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		int T = sc.nextInt();
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < T; i++) {
			int x = sc.nextInt();
			int d = sc.nextInt();
			int k = sc.nextInt();
			for (int j = x; j <= N; j+=x) {
				spin(j-1,d,k);
			}
			check();
			
		}
		
		int result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				result += map[i][j];
			}
		}
		System.out.println(result);
	}
	
	private static void spin(int x, int d, int k) {
		// TODO Auto-generated method stub
		if(d==0) k = M - k;
		int temp[] = new int[M];
		for (int i = 0; i < M; i++) {
			temp[i] = map[x][(i+k) % M];
		}
		for (int i = 0; i < M; i++) {
			map[x][i] = temp[i];
		}
	}	

	private static void check() {
		// TODO Auto-generated method stub
		
		boolean check[][] = new boolean[N][M];
		boolean flag = true;
		int cnt = 0;
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] != 0) {
					cnt++;
					sum += map[i][j];
				}
				if( map[i][j] == map[i][(j+1)%M] ) {
					if(map[i][j]!=0) flag = false;
					check[i][j] = true;
					check[i][(j+1)%M] = true;
				}
			}
		}
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N - 1; j++) {
				if( map[j][i] == map[j+1][i] ) {
					if(map[j][i]!=0) flag = false;
					check[j][i] = true;
					check[j+1][i] = true;
				}
			}
		}
		if(flag) {
			double avg = (double) sum/cnt;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] == 0) continue;
					if(avg < map[i][j]) map[i][j]--;
					else if(avg > map[i][j]) map[i][j]++;
				}
			}
			
			
		} else {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if( check[i][j] ) map[i][j] = 0;
				}
			}
		}
		
		
	}
}
