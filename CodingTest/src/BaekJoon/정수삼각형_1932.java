package BaekJoon;

import java.util.Arrays;
import java.util.Scanner;

public class 정수삼각형_1932 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int arr[][] = new int[N][N];
		int sum[][] = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= i; j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		
		sum[0][0]=arr[0][0];
		
		int max=-1;
		
		for (int i = 1; i < N; i++) {
			for (int j = 0; j <= i; j++) {
				if(j==0) {
					sum[i][j]=sum[i-1][j]+arr[i][j];
				}
				else {
					sum[i][j]=Math.max(sum[i-1][j-1], sum[i-1][j])+arr[i][j];
				}
				
				if(i==N-1) {
					if(max <sum[i][j])
						max=sum[i][j];
				}
				
			}
			
		}
//		
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}
//		System.out.println();
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(sum[i]));
//		}
		
		System.out.println(max);
		
		
	}
}
