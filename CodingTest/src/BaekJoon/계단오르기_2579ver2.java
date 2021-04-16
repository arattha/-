package BaekJoon;

import java.util.Arrays;
import java.util.Scanner;

public class 계단오르기_2579ver2 {
	
	public static void main(String[] args) {
		
		Scanner  sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int stair[] = new int[N+1];
		int D[]=new int[N+1];
		for (int i = 1; i <= N; i++) {
			stair[i]=sc.nextInt();
		}
		D[1]=stair[1];
		if(N>=2){
			D[2]=Math.max(stair[2], stair[1]+stair[2]);
		}
		if(N>=3) {
			D[3]=Math.max(stair[0]+stair[2], stair[0]+stair[2]);
			for (int i = 3; i <= N; i++) {
				D[i]=Math.max(D[i-3]+stair[i-1]+stair[i], D[i-2]+stair[i]);
			}
		}
		System.out.println(D[N]);
	}
}

