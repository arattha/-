package BOJ_GOLD4;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class 가장긴증가하는부분수열4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] arr = new int[N]; 
		int[] LIS = new int[N];
		int[] res = new int[N];
		// 접근 1 현재 원소에서 이전  최장 길이 원소들을 전부 검색하며 최대 크기를 찾아 저장.
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		int max= 0;
		int idx = 0;
		for (int i = 0; i < N; i++) {
			LIS[i]=1;
			for (int j = 0; j < i; j++) {//맨앞부터 자신의 직전의 원소들과 비교
				if(arr[j]<arr[i] && LIS[i] < LIS[j]+1 ) {//이전 원소들 비교하면서 나보다 작은 애들 있으면, LIS 배열보고 내가 제일크면 저장.
					//N^2 걸림,
					LIS[i]= LIS[j]+1;
					res[i] = j;
				}
			}
			if(max < LIS[i]) {
				max=LIS[i];
				idx = i;
			}
		}
		
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < max; i++) {
			stack.push(arr[idx]);
			idx = res[idx];
		}
		
		StringBuilder sb = new StringBuilder();
        
        sb.append(max).append("\n");
        while(!stack.isEmpty()) {
        	sb.append(stack.pop()).append(" ");
        }
		System.out.print(sb);
//		System.out.println(idx);
//		System.out.println(Arrays.toString(res));
//		System.out.println(max);
	}

}
