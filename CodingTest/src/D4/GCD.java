package D4;

import java.util.Scanner;

public class GCD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			int K = sc.nextInt();
			
			long A[]= new long[K+1];
			long B[]= new long[K+1];
			
			A[0]=1;
			B[0]=0;
			A[1]=2;
			B[1]=1;
			
			for (int i = 2; i <= K; i++) {
				A[i]=A[i-1]+B[i-1];
				B[i]=A[i-1];
			}
			
			System.out.println("#"+tc+" "+A[K]+" "+B[K]);
		}
	}

}
