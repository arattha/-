package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 
325 187 512 85 136 3 359 601 776 74

325 187 512 85 136 3 132 775 462 671


10
711 572 325 
209 187 673 
512 930 898 
759 85 260 
136 226 532 
201 3 959 
132 607 359 
601 775 848 
462 776 920 
74 807 671

10
74 807 671
462 776 920
601 775 848
132 607 359 
201 3 959
136 226 532 
759 85 260 
512 930 898 
209 187 673 
711 572 325 
 * */

public class rgb거리_그리디접근 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int arr[][] = new int[N][3];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		int res[] = new int[3];
		int prevIdx=0;
		int resSum=Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			int sum=arr[0][i];
			prevIdx=i;
			for (int j = 1; j < N; j++) {
				int minIdx=0;
				int minVal=Integer.MAX_VALUE;
				for (int k = 0; k < 3; k++) {
					if(prevIdx==k) continue;
					if(minVal > arr[j][k]) {//이전 칠한 색 제외 제일 작은 값 찾기
						minIdx=k;
						minVal=arr[j][k];
					}
				}
				sum+=arr[j][minIdx];//가장 작은 값을 더함
				prevIdx=minIdx;//칠한색 갱신
			}
			
			resSum=Math.min(resSum, sum);
		}
		System.out.println(resSum);
	}

}

