package BaekJoon;

import java.util.Arrays;
import java.util.Scanner;

public class 계단오르기_2579 {
	
	public static void main(String[] args) {
		
		Scanner  sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int stair[] = new int[N+1];
		int D[][]=new int[N+1][2];
		for (int i = 1; i <= N; i++) {
			stair[i]=sc.nextInt();
		}
		D[1][0]=stair[1];
		D[1][1]=1;//1칸 올라감
		for (int i = 2; i <= N; i++) {
			
			if(D[i-1][1]!=2) {//이전 계층이 2번 오른 상태가 아니라면
				if(D[i-2][0]>D[i-1][0]) {
					D[i][0]=D[i-2][0]+stair[i];
					D[i][1]=1;
				}
				else {
					D[i][0]=D[i-1][0]+stair[i];
					D[i][1]=D[i-1][1]+1;
				}
			}
			else {//이전 계층이 2번 연속 오른상태면, 무조건 2칸이동
				D[i][0]=D[i-2][0]+stair[i];
				D[i][1]=1;
			}
			
		}
		for (int i = 0; i <=N; i++) {
			System.out.println(D[i][0]+" "+D[i][1]);
		}
	}
}
