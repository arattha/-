package BOJ_GOLD4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 부분합 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int left = 0;
		int right = 0;
		int sum = 0;
		int res = Integer.MAX_VALUE;
		while(true) {
			
			if(sum >= S) {
				sum -= arr[left];
				res = Math.min(res, (right-left));
				left++;
			}else if(right == N){
				break;
			}
			else{
				sum += arr[right++];
			}
			
		}
		System.out.println(res == Integer.MAX_VALUE ? 0 : res);
	}
	
}
