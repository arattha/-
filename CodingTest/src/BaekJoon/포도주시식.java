package BaekJoon;

import java.util.Arrays;
import java.util.Scanner;

public class 포도주시식 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int wine[] = new int[N+1];
		int dp[][]= new int[N+1][2];//이전 포도주 마심, 안마심
		
		for (int i = 1; i <= N; i++) {
			wine[i] = sc.nextInt();
		}
		//dp[n][0] = dp[n-1][0]+wine[n]
		//dp[n][1] = Math.max(dp[n-2][0], dp[n-2][1]) + wine[n] 
		
		dp[1][0] = wine[1];//0 마심
		dp[1][1] = 0;//1 안마심
		
		for (int i = 2; i <= N; i++) {
			dp[i][0] = wine[i] + Math.max(dp[i-2][0], dp[i-2][1]); // 이번에 마실건, 2단계전 마신 최대 or 2단계전 안마신 최대
			dp[i][1] = Math.max( dp[i-1][1] , dp[i-1][0]+wine[i]);
			//이전 안마심 or 이전에 마심+
		}
		System.out.println(dp[N][0] > dp[N][1] ? dp[N][0] : dp[N][1]  );
		
	}

}

/*
public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(input.readLine());
        int[] arr = new int[N+1];
        int[][] max_arr = new int[N+1][2];

        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(input.readLine());
        }

        max_arr[1][0] = arr[1];
        for(int i = 2; i <= N; i++){
            max_arr[i][0] = arr[i] + Math.max(max_arr[i-2][0], max_arr[i-2][1]);
            max_arr[i][1] = max_arr[i-1][0] + arr[i];
        }
        System.out.println(Math.max(max_arr[N][0], max_arr[N][1]));
    }
}*/