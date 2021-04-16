package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 길찾기 {
	
	static int size = 100;
	static int arr1[];
	static int arr2[];
	static int res;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 1; tc <= 10; tc++) {
			
			arr1=new int[size];
			arr2=new int[size];
			res=0;
			
			StringTokenizer s= new StringTokenizer(br.readLine());
			s.nextToken();
			int N = Integer.parseInt(s.nextToken());
			StringTokenizer st= new StringTokenizer(br.readLine());
			
			while(st.hasMoreTokens()) {
				int index=Integer.parseInt(st.nextToken());
				int val=Integer.parseInt(st.nextToken());
				
				if(arr1[index]==0) {//arr1에 아직 안넣었으면
					arr1[index]=val;
				}
				else
					arr2[index]=val;
			}
			go(0);
			System.out.println("#"+tc+" "+res);
		}
	
	}
	
	public static void go(int index) {
		if(arr1[index] == 99 || arr2[index] == 99) {
			res=1;
			return;
		}
		
		if(arr1[index]!=0)
			go(arr1[index]);
		if(arr2[index]!=0)
			go(arr2[index]);
		
	}

}
