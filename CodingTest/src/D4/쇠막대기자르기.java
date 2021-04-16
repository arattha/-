package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 쇠막대기자르기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			
			Stack<Character> stack = new Stack<>();
			
			String str = br.readLine();
			int res=0;
			char prev='s';
			int len=0;
			for (int i = 0; i < str.length(); i++) {
				
				if(prev=='(' && str.charAt(i)=='(') {//철판이면,
					len++;
				}
				
				if(prev =='(' && str.charAt(i)==')') { // 바로 닫히는건 레이저
					res+=len;
				}
				
				if(prev ==')' && str.charAt(i)==')') { // 닫히고 나오는건 철판이 끝난 것.
					res+=1;
					len--;
				}
				
				prev = str.charAt(i);
				
			}
			System.out.println("#"+tc+" "+res);
		}
		
	}

}
