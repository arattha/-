package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 나는개구리로소이다 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			
			char frog[] = br.readLine().toCharArray();
			int N = frog.length;
			char croak[]= {'c','r','o','a','k'};
			boolean visited[]=new boolean[N];
			
			int offset=0;
			int i=0;
			int res=0;
			int prevCheck = -1;
			while(true) {
				if(!visited[i] && frog[i]==croak[offset]) {
					offset = (offset + 1)%5;
					visited[i]=true;
				}
				
				i++;
				if(i==N) {
					if(offset==0) {//croak을 성공적으로 다찾으면서 끝난 경우
						
						int check=0;
						
						for (int j = 0; j < N; j++) {
							if(!visited[j]) check++;
						}
						if(check==0) {//다찾은것
							res++;
							break;
						}
						
						if(check%5==0) {//check가 5의 배수면, 한번 더 가도됨
							if(prevCheck==check) {//이전 찾은거랑 변화가 없다면? 무의미한 글자들이 5개씩 있는것.
								res=-1;
								break;
							}
							
							prevCheck=check;
							res++;
						}
						else {
							res=-1;
							break;
						}
					}
					else {//애초에 이상하게 끝남
						res=-1;
						break;
					}
					i=0;
				}
				
			}
			System.out.println("#"+tc+" "+res);
		}
		
	}

}
