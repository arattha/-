package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 사칙연산유효성검사 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 1; tc <= 10; tc++) {
			
			int N=Integer.parseInt(br.readLine());
			char tree[]=new char[N+1];
			boolean leaf[]=new boolean[N+1];
			int result=1;
			
			for (int i = 1; i <= N; i++) {
				StringTokenizer st= new StringTokenizer(br.readLine());
				st.nextToken();
				tree[i]=st.nextToken().charAt(0);
				if(!st.hasMoreTokens())leaf[i]=true;
			}
			
			for (int i = 1; i <= N; i++) {
				if(leaf[i]) {
					if( !(tree[i] >= '0' && tree[i] <= '9') )
						result=0;
				}
				else {
					if(tree[i] >= '0' && tree[i] <= '9')
						result=0;
				}	
			}
			
			System.out.println("#"+tc+" "+result);
		}
	}

}
