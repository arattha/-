package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class rgb거리_정해 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int arr[][] = new int[N][3];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		int D[][] = new int[N+1][3];

		for (int i = 1; i <= N; i++) {
			D[i][0]= Math.min(D[i-1][1], D[i-1][2]) + arr[i-1][0];  //i번째 집을 0으로 칠하는 경우
			D[i][1]= Math.min(D[i-1][0], D[i-1][2]) + arr[i-1][1];  //i번째 집을 1으로 칠하는 경우
			D[i][2]= Math.min(D[i-1][0], D[i-1][1]) + arr[i-1][2];  //i번째 집을 2으로 칠하는 경우
		}
		
		for (int i = 0; i <= N; i++) {
			System.out.println(Arrays.toString(D[i]));
		}
		
		System.out.println(Math.min(Math.min(D[N][0],D[N][1] ), D[N][2]));
	}

}
