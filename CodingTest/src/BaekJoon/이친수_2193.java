package BaekJoon;

import java.util.Scanner;

public class 이친수_2193 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		
		int N = sc.nextInt();
		
		long[] arr=new long[91];
		
		arr[1]=1;
		arr[2]=1;
		
		for (int i = 3; i <= 90; i++) {
			arr[i]=arr[i-2]+arr[i-1];
		}
		
		System.out.println(arr[N]);
	}

}
