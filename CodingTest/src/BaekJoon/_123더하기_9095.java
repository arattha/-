package BaekJoon;

import java.util.Scanner;

public class _123더하기_9095 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T =sc.nextInt();
		for (int tc = 1; tc <=T ; tc++) {
			int N =sc.nextInt();
			
			int arr[]= new int[N+1];
			
			
			arr[1]=1;
			if(N>=2)
				arr[2]=2;
			if(N>=3) 
				arr[3]=4;
			if(N>=4)
				for (int i = 4; i <=N ; i++) {
					arr[i] = arr[i-3]+arr[i-2]+arr[i-1];
				}
			System.out.println(arr[N]);
		}
		
		
	}

}
