package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 신도시전기연결하기 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int arr[] = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			int line[]= new int[N-1];
			for (int i = 0; i < N-1; i++) {
				line[i]=arr[i+1]-arr[i];
			}
			
			Arrays.sort(line);
			
			int sum=0;
			for (int i = 0; i < N-1 && i < N-K; i++) {
				sum += line[i];
			}
			
			System.out.println("#"+tc+" "+sum);
			
		}
	}

}
