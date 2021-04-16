package BaekJoonIM대비;

import java.util.Scanner;

public class 수열2559 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		int res=Integer.MIN_VALUE;
		
		int arr[] = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i]=sc.nextInt();
		}
		
		for (int i = 0; i <= N-K; i++) {
			
			int sum=0;
			
			for (int j = i; j <i+K; j++) {
				sum+=arr[j];
			}
			
			res=Math.max(sum, res);
			
		}
		System.out.println(res);
	}

}
