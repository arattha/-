package D4;

import java.util.Scanner;

public class 올림픽종목투표 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int arrA[]=new int[N];
			int arrB[]=new int[M];
			
			int vote[]=new int[N];
			
			for (int i = 0; i < N; i++) {
				arrA[i]=sc.nextInt();
			}
			for (int i = 0; i < M; i++) {
				arrB[i]=sc.nextInt();
			}
			
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if(arrB[i]>=arrA[j]) {
						vote[j]++;
						break;
					}
				}
			}
			int max=Integer.MIN_VALUE;
			int index=0;
			for (int i = 0; i < N; i++) {
				if(vote[i]>max) {
					max=vote[i];
					index=i+1;
				}
			}
			System.out.println("#"+tc+" "+index);
			
		}
		
	}

}
