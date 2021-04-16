package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class 계산기3 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static char[] backward,forward;
	static int bwdIdx;//backward용 인덱스
	static int L;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		for (int tc = 1; tc <= 1; tc++) {
			L=Integer.parseInt(br.readLine());
			
			forward=br.readLine().toCharArray();		
			backward=new char[L];
			bwdIdx=0;
			int longL=L;
			Stack<Character> stack=new Stack<Character>();
			int idx=0;
			int popCnt=0;
			char temp='=';//null용
			while(idx!=L) {
				if(forward[idx]=='(' && temp !='=') {//괄호일때
					stack.add(temp);
					temp='=';
					idx++;
					longL -= 2;
				}
				else if((forward[idx]=='+' || forward[idx]=='*') && temp == '=') {//연산자일때
					temp=forward[idx++];
				}
				else if(forward[idx]==')') {
					backward[bwdIdx++]=stack.pop();
					//popCnt++;
					idx++;
				}
				else {//숫자일 때 
					
					if(temp =='=')
						backward[bwdIdx++]=forward[idx++];//temp에 연산자가 없다면, 그냥 넣어도 됨
					else {
						
						backward[bwdIdx++]=forward[idx++];
						backward[bwdIdx++]=temp;//temp에 연산자가 존재하면, 뒤에 넣어줌
						temp='='; //temp는 비워주고
						
						int tempPopCnt=popCnt;
//						for (int i = 0; i < tempPopCnt; i++) {//괄호의 수만큼 연산자를 다시 넣어줌
//							backward[bwdIdx++]=stack.pop();
//							popCnt--;
//						}
					}
				}
			}
			
			System.out.println(Arrays.toString(backward));
			
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