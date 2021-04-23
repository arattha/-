package BaekJoon;

import java.io.*;
import java.util.*;

public class 동전1 {
	
    static int N,K;
    static int coin[];
    static int dp[];
    
    public static void main(String[] args) throws IOException{
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] t = br.readLine().split(" ");
        
        N = Integer.parseInt(t[0]);
        K = Integer.parseInt(t[1]);
        coin = new int[N];
        dp = new int[K+1];
        
        for(int i=0; i<N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }
        
        dp[0]=1;
        
        for(int i=0; i<N; i++) {
            for(int j=coin[i]; j<=K; j++) {
                dp[j] += dp[j-coin[i]];
            }
        }
        
        System.out.println(dp[K]);
    }
}