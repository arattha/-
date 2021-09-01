package D5;

import java.util.Arrays;
import java.util.Scanner;

public class 최장증가부분수열Hard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			
			int[] arr = new int[N + 1]; 
			int[] LIS = new int[N + 1]; //각 위치가 LIS의 길이
			// 접근 1 현재 원소에서 이전  최장 길이 원소들을 전부 검색하며 최대 크기를 찾아 저장.
			
			for (int i = 1; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			
			int offset=0;
			
			
			for (int i = 1; i <= N; i++) {
				int tmp = Arrays.binarySearch(LIS, 0, offset, arr[i]);//어짜피 실패하면 끝의 offset을 뱉을것
				tmp = Math.abs(tmp)-1; // 중복값이 없으므로 탐색에 실패하고, 음수값이 리턴 
				LIS[tmp]= arr[i];
				if(tmp==offset)++offset;
			}
			System.out.println("#"+tc+" "+offset);
		}
		
	}

}
