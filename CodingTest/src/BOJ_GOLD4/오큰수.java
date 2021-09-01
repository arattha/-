package BOJ_GOLD4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 오큰수 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int nge[] = new int[N];
		
		for (int i = 0; i < N; i++) {
			nge[i] = Integer.parseInt(st.nextToken());
		}
		
		Stack<Integer> res = new Stack<Integer>();
		Stack<Integer> temp = new Stack<Integer>();
		
		for (int i = N-1; i >= 0; i--) {
			
			int right = nge[i];
			
			while(!temp.isEmpty() && right >= temp.peek()) {
				temp.pop();
			}
			
			if(temp.isEmpty()) {
				res.add(-1);
			} else {
				res.add(temp.peek());//맨 왼쪽 가장큰수
			}
			
			temp.add(right);
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(!res.isEmpty()) {
			sb.append(res.pop()+" ");
		}
		
		System.out.println(sb);
		
	}

}
