package BOJ_GOLD5;


import java.util.Scanner;

public class 공통부분문자열 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		char[] str1 = sc.next().toCharArray();
		char[] str2 = sc.next().toCharArray();
		
		int dp[][] = new int[str1.length+1][str2.length+1];
		
		
		int max = 0;
		for (int i = 1; i <= str1.length; i++) {
			for (int j = 1; j <= str2.length; j++) {
				
				if(str1[i-1] == str2[j-1]) {
					dp[i][j] = dp[i-1][j-1] +1 ;
					max = Math.max(max, dp[i][j]);
				}
				
			}
		}
		
		System.out.println(max);
	}
	
}
