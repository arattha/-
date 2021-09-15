package BOJ_GOLD4;

import java.util.Scanner;

public class 좋은수열 {
	
	static int N;
	static boolean t[] = new boolean[4];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		dfs(0,"");
		
	}

	private static void dfs(int cnt ,String num) {
		// TODO Auto-generated method stub
		
		if(cnt == N) {
			System.out.println(num);
			System.exit(0);
		}
		
		for (int i = 1; i < 4; i++) {
			if(check(num+i))
				dfs(cnt+1,num+Integer.toString(i));
		}
		
	}
	
	private static boolean check(String num) {
		int len = num.length()/2;
		for (int i = 1; i <= len; i++) {//gap
			if(num.substring(num.length() - i).equals(num.substring(num.length() - i*2,num.length() - i )))
				return false;
		}
		return true;
	}
		
//	private static int cutting(int start, int end, int num) {
//		int temp = num / (int)(Math.pow(10, start));
//		//System.out.println(num / (int)(Math.pow(10, start)) - temp - temp %(int)(Math.pow(10, end - start)));
//		
//		return  (temp %(int)(Math.pow(10, end - start))) - (num / (int)(Math.pow(10, start)) - temp);
//	}
}
