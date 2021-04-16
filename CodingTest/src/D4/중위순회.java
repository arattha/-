package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 중위순회 {
	
	static char arr[];
	
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			N = Integer.parseInt(br.readLine());
			
			arr= new char[N+1];
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				int index=Integer.parseInt(st.nextToken());
				char val = st.nextToken().charAt(0);
				
				arr[index]=val;
				
			}
			System.out.print("#"+tc+" ");
			inorder(1);
			System.out.println();
		}
		
	}

	private static void inorder(int index) {
		// TODO Auto-generated method stub
		
		if(index > N)
			return;
		
		inorder(index*2);
		System.out.print(arr[index]);
		inorder(index*2+1);
		
		
	}

}
