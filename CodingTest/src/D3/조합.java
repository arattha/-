package D3;

import java.util.Scanner;

public class 조합 {
	
	static int p = 1234567891;
	static long factorial[];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt();
			int R = sc.nextInt();
			
			factorial= new long[N+1];
			factorial[0]=1;
			
			//nCr 은 -> n!/n-r!*r!
			//구하길 원하는 건  (n!/n-r!*r!) % p
			//이중  1/n-r! * r! % p 을 페르마의 소정리로 
			// n! * (r! * n-r! ) power p-2;
			
			for (int i = 1; i <= N; i++) {
				factorial[i]= ( factorial[i-1]*i );
			}
			

			
			long denomi = (factorial[R] * factorial[N-R]); //분모 부분 완성
			long powerD =  power(denomi,p-2)%p; //분모 부분을 거듭제곱 한다
			//분할정복
			
			
			System.out.println("#"+tc+" "+ (factorial[N] * powerD)%p);
			
		}
	}
	
	private static long power(long denomi , int quotient) {
		// 거듭 제곱을 분할정복
		if(quotient == 0) return 1; //지수 0은 1
		long res = power(denomi,quotient/2) % p; // 절반씩
		res = (res * res) %p;
		if(quotient % 2==0) return res;
		else return res*denomi;
	}

}
