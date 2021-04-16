package BaekJoon;

import java.util.Arrays;
import java.util.Scanner;

public class _1로만들기1463 {
	
	//DP는 반대로 가는 느낌
	
	// 1 2    3       4      5      6     7       8       9     10
	// 0 1 (2,x,1) (2,2,x)(3,x,x)(4,2,2)(3,x,x)(4,3,x )(4,x,2)(3,4,x)
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[]= new int[N+1];
		
		arr[1]=0;
		
		for (int i = 2; i <= N; i++) {
			
			int one=Integer.MAX_VALUE;
			int two=Integer.MAX_VALUE;
			int three=Integer.MAX_VALUE;
			
			one = arr[i-1] + 1;
			
			if( i%2 == 0 ) {
				two = arr[i/2] + 1;
			}
			
			if( i%3 == 0 ) {
				three = arr[i/3] + 1;
			}
			
			arr[i]=Math.min(one, Math.min(two, three));
			
		}
		System.out.println(arr[N]);
		
	}

}
