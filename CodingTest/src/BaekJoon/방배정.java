package BaekJoon;

import java.util.Scanner;

public class 방배정 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int room[][]=new int[6][2];
		
		for (int i = 0; i < N; i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			room[b-1][a]++;
		}
		int cnt=0;
		
		for (int i = 0; i < room.length; i++) {
			for (int j = 0; j < room[i].length; j++) {
				if(room[i][j]!=0) {
					if(room[i][j]%K!=0)
						cnt+=(room[i][j]/K)+1;
					else
						cnt+=room[i][j]/K;
				}
			}
		}
		System.out.println(cnt);
	}
	
}
