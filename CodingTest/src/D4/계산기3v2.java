package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class 계산기3v2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static char[] backward,forward;
	static int bwdIdx;//backward용 인덱스
	static int L;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		for (int tc = 1; tc <= 10; tc++) {
			L=Integer.parseInt(br.readLine());
			
			forward=br.readLine().toCharArray();		
			backward=new char[L];
			bwdIdx=0;
			int longL=L;
			Stack<Character> stack=new Stack<Character>();
			int idx=0;
			
			while(idx!=L) {
				if(forward[idx]=='(' ) {//괄호일때
					stack.add(forward[idx]);//괄호 삽입
					idx++;
					longL -= 2;//backward 글자수 계산.
				}
				else if(forward[idx]=='+') {//더하기일때
					while(!stack.isEmpty() &&  stack.peek() != '(') {
	                    backward[bwdIdx++] = stack.pop();
					}
					stack.add(forward[idx++]);
				}
				else if(forward[idx]=='*') {
					while( !stack.isEmpty() && stack.peek() == '*' &&  stack.peek() != '(') {//곱하기는 나중에
                    	backward[bwdIdx++] = stack.pop();
                        }
                    stack.add(forward[idx++]);
                }
				else if(forward[idx]==')') {
					while(true) {
						char tempChar=stack.pop();
						if(tempChar=='(')
							break;
						else
							backward[bwdIdx++]=tempChar;
					}
					idx++;
				}
				else {//숫자일 때 
					backward[bwdIdx++]=forward[idx++];//그냥 넣어도 됨
				}
			}
			while(!stack.isEmpty()) {
				backward[bwdIdx++]=stack.pop();
			}
			//계산부
//			
//			System.out.println(Arrays.toString(backward));
//			System.out.println(longL);
			Stack<Integer> stack2=new Stack<Integer>();
			
			
			for (int i = 0; i < longL; i++) {
				if(backward[i] != '+' && backward[i] != '*') {
					stack2.add(backward[i]-'0');
				}
				else {
					int num=stack2.pop();
					int num2=stack2.pop();
					int result;
					if(backward[i]=='+')
						result=num+num2;
					else
						result=num*num2;
					stack2.add(result);
				}
			}
			
			System.out.println("#"+tc+" "+ stack2.pop());
		}

	}	
	
}
