package D4;

import java.util.Scanner;

public class 장훈이의높은선반 {
	
	static int T,N,B;
	static int arr[];
	static int res;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			N = sc.nextInt();
			B = sc.nextInt();
			
			arr=new int[N];
			res=Integer.MAX_VALUE;
			
			for (int i = 0; i < N; i++) {
				arr[i]=sc.nextInt();
			}
			
			for (int i = 1; i <= N; i++) {
				combination(0,0,0,i);
			}
			
			System.out.println("#"+tc+" "+(res-B));
			
		}
	}

	public static void combination(int cnt, int start,int sum,int max) {
		
		if(cnt==max) {
			if(sum >= B) {
				res=Math.min(res, sum);
			}
			
			return;
		}
		if(res<sum) {
			return;
		}
		
		for (int i = start; i < N; i++) {
			combination(cnt+1,i+1,sum+arr[i],max);
		}
		
	}
	
}
