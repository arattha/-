package D2;

import java.util.Arrays;
import java.util.Scanner;

public class 민석이의과제체크하기 {
	
	static int N;
	static int K;
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			System.out.print("#"+tc+" ");
			
			N=sc.nextInt();
			K=sc.nextInt();
			
			int[] arrK=new int[K];
			
			for (int i = 0; i < K; i++) {
				arrK[i]=sc.nextInt();
			}
			Arrays.sort(arrK);
			int j=0;
			for (int i = 1; i <= N; i++) {
				if(j<K &&arrK[j]==i) {
					j++;
					continue;
				}
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
}
