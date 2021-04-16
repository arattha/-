package BaekJoon;

import java.util.Scanner;

public class _2xN타일링2_11727 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		long arr[]=new long[N+1];
		arr[1]=1;
		if(N>=2)
			arr[2]=3;
		if(N>=3)
			for (int i = 3; i <= N; i++) {
				arr[i]=arr[i-1]+arr[i-2]+arr[i-2];
				arr[i]=arr[i]%10007;
			}
		
		long res = arr[N];
		System.out.println(res);
	}

}
