package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 러시아국기같은깃발 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			char flag[][]=new char[N][M];
			int flagCnt[][]=new int[N][3];
			
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < M; j++) {
					flag[i][j]=str.charAt(j);
					if(flag[i][j]=='W')
						flagCnt[i][0]++;
					else if(flag[i][j]=='B')
						flagCnt[i][1]++;
					else if(flag[i][j]=='R')
						flagCnt[i][2]++;
				}
			}
			
			int res=Integer.MAX_VALUE;
			
			for (int i = 0; i < N-2; i++) {//i는 최소 1중부터 n-2줄까지.
				
				for (int j = i+1; j < N-1; j++) {//j는 최소 1줄부터 n-1줄까지
					
					int whiteL=i+1;
					int wc=0;
					for (int k = 0; k < whiteL; k++) {
						wc+=flagCnt[k][0];
					}

					int blueL=j-i;
					int bc=0;
					for (int k = 0; k < j-i; k++) {
						bc+=flagCnt[whiteL+k][1];
					}
					
					int redL=N-(whiteL+blueL);
					int rc=0;
					for (int k = j+1; k < N; k++) {
						rc+=flagCnt[k][2];
					}
					res=Math.min(res, (M*whiteL-wc)+(M*blueL-bc)+(M*redL-rc));
					
				}
				
			}
			System.out.println("#"+tc+" "+res);
		}
	}

}
