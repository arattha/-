package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 내려가기_2096 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		int maxWindow[]= new int[3];
		int minWindow[]= new int[3];
		int resMax[] = new int[3];
		int resMin[] = new int[3];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int first=Integer.parseInt(st.nextToken());
			int second=Integer.parseInt(st.nextToken());
			int third=Integer.parseInt(st.nextToken());
			
			if(i==0) {//처음 초기화
				
				maxWindow[0]=resMax[0]=first;
				minWindow[0]=resMin[0]=first;
				maxWindow[1]=resMax[1]=second;
				minWindow[1]=resMin[1]=second;
				maxWindow[2]=resMax[2]=third;
				minWindow[2]=resMin[2]=third;
			}
			else {
				resMax[0]=first+Math.max(maxWindow[0], maxWindow[1]);
				resMax[1]=second+Math.max(maxWindow[0], Math.max(maxWindow[1], maxWindow[2]));
				resMax[2]=third+Math.max(maxWindow[1], maxWindow[2]);
				resMin[0]=first+Math.min(minWindow[0], minWindow[1]);
				resMin[1]=second+Math.min(minWindow[0], Math.min(minWindow[1], minWindow[2]));
				resMin[2]=third+Math.min(minWindow[1], minWindow[2]);
				maxWindow[0]=resMax[0];
				maxWindow[1]=resMax[1];
				maxWindow[2]=resMax[2];
				minWindow[0]=resMin[0];
				minWindow[1]=resMin[1];
				minWindow[2]=resMin[2];
			}
			
		}
		System.out.println(Math.max(resMax[0], Math.max(resMax[1], resMax[2]))+" "+Math.min(resMin[0], Math.min(resMin[1], resMin[2])));
		
	}

}
