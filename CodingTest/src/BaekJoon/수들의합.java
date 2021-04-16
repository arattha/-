package BaekJoon;

import java.util.Scanner;

public class 수들의합 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		long N = sc.nextLong();
		long sum=0;
		long i=1;
		while(true) {
			sum+=i;
			if(sum>N)
				break;
			i++;
		}
		
		System.out.println(i-1);
	}

}
