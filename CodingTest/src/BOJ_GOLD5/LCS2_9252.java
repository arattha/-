package BOJ_GOLD5;

import java.util.Scanner;
import java.util.Stack;

public class LCS2_9252 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		char[] str1 = sc.next().toCharArray();
		char[] str2 = sc.next().toCharArray();
		
		int dp[][] = new int[str1.length+1][str2.length+1];
		
		for (int i = 1; i <= str1.length; i++) {
			for (int j = 1; j <= str2.length; j++) {
				
				if(str1[i-1] == str2[j-1]) {
					dp[i][j] = dp[i-1][j-1] +1 ;
				}
				
				else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
				
			}
		}
		
		int ans = dp[str1.length][str2.length];
		System.out.println(ans);
		int i = str1.length;
		int j = str2.length;
		Stack<Character> stack = new Stack<>();
		while(i >=1 && j >= 1) {
			// 위와 같은 경우 위로 이동
			if(dp[i][j] == dp[i-1][j]) 
				i--;
			// 왼쪽과 같은 경우 왼쪽으로 이동
			else if(dp[i][j] == dp[i][j-1])
				j--;
			else {
				// 대각선으로 같다면
				stack.push(str1[i-1]);
				i--; j--;
			}		
		}
		
		while(!stack.isEmpty())
			System.out.print(stack.pop());
	}
	
}

