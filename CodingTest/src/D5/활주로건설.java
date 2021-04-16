package D5;

import java.util.Scanner;

public class 활주로건설 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int L = sc.nextInt();//내리막길이
			
			int[][] arr=new int[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j]=sc.nextInt();
				}
			}
			
			boolean[][] check = new boolean[N][N];
			int res=0;
			for (int i = 0; i < N; i++) {
				boolean able = true;
				for (int j = 0; j < N-1; j++) {
					
					if(arr[i][j]-arr[i][j+1]==0)
						continue;
					
					else if( arr[i][j]-arr[i][j+1] == 1) {
						for (int p = 0; p < L; p++) {//내리막
							int temp=arr[i][j+1];
							if(j+1+p>=N) {
								able=false;
								break;
							}
							if(check[i][j+1+p]==false && arr[i][j+1+p]==temp)//같은땅
								check[i][j+1+p]=true;//경사로 설치했다고 체크
							else
								able=false;
						}
					}
					else if( arr[i][j]-arr[i][j+1] == -1) {//오르막
						for (int p = 0; p < L; p++) {
							if(j-p<0) {
								able=false;
								break;
							}
							int temp=arr[i][j];
							if(check[i][j-p]==false && arr[i][j-p]==temp)//같은땅
								check[i][j-p]=true;
							else
								able=false;
						}
					}	
					else {//애초에 설치못함.
						able=false;
						break;
					}
				}
				if(able)
					res++;
			}
			
			boolean[][] check2 = new boolean[N][N];
			
			for (int i = 0; i < N; i++) {
				boolean able = true;
				for (int j = 0; j < N-1; j++) {
					
					if(arr[j][i]-arr[j+1][i]==0)
						continue;
					
					else if( arr[j][i]-arr[j+1][i] == 1) {
						for (int p = 0; p < L; p++) {//내리막
							int temp=arr[j+1][i];
							if(j+1+p>=N) {
								able=false;
								break;
							}
							if(check2[j+1+p][i]==false && arr[j+1+p][i]==temp)//같은땅
								check2[j+1+p][i]=true;
							else
								able=false;
						}
					}
					else if( arr[j][i]-arr[j+1][i] == -1) {//오르막
						for (int p = 0; p < L; p++) {
							if(j-p<0) {
								able=false;
								break;
							}
							int temp=arr[j][i];
							if(check2[j-p][i]==false && arr[j-p][i]==temp)//같은땅
								check2[j-p][i]=true;
							else
								able=false;
						}
					}	
					else {//애초에 설치못함.
						able=false;
						break;
					}
				}
				if(able)
					res++;
			}
			System.out.println("#"+tc+" "+res);
		}
	}
}
