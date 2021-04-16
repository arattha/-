package BaekJoon;

import java.util.Arrays;
import java.util.Scanner;

public class 햄버거분배 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		char arr[] = sc.next().toCharArray();
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if(arr[i]!='P')
				continue;
			for (int j = i - K; j <= i + K; j++) {
				if(j >= 0 && j < N && arr[j]=='H') {
					arr[j]='O';
					cnt++;
					break;
				}
			}
		}
		System.out.println(cnt);
	}
}
