package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 재관이의대량할인 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			
			int arr[]=new int[N];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			
			int sale=0;
			int total=0;
			for (int i = 0; i < N; i++) {
				total+=arr[i];
			}
			
			for (int i = N-3; i >=0; i-=3) {
				
				sale+=arr[i];
				
			}
			System.out.println("#"+tc+" "+(total-sale));
		}
	}

}
