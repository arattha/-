package D4;

import java.util.Arrays;
import java.util.Scanner;

public class 성수의프로그래밍강좌시청 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt();
			int K = sc.nextInt();
			
			double res = 0;
			
			double arr[] = new double[N];
			
			for (int i = 0; i < N; i++) {
				arr[i]=sc.nextFloat();
			}
			
			Arrays.sort(arr);
			
			for (int i = N-K; i < N; i++) {
				res =  (res + arr[i])/2.0;
			}
			
			System.out.printf("#%d %.6f\n",tc,res);
		}
		
	}

}
