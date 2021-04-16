package D2;

import java.util.Scanner;

public class 스도쿠검증 {
	
	final static int N=9;
	static int result = 1;
	static int test[]=new int[9];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		int[][] arr=new int[N][N];
		for (int tc = 1; tc <= T; tc++) {
			result=1;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j]=sc.nextInt();
				}
			}
			
			for (int i = 0; i < N; i++) {//세로순회
				for (int j = 0; j < N; j++) {
					test[arr[i][j]-1]++;
				}
				checkSudoku();
			}
			
			for (int i = 0; i < N; i++) {//가로순회
				for (int j = 0; j < N; j++) {
					test[arr[j][i]-1]++;
				}
				checkSudoku();
			}
			
			for (int i = 0; i < N; i+=3) {
				for (int j = 0; j < N; j+=3) {
					for (int k = i; k < i+3; k++) {
						for (int q = j; q < j+3; q++) {
							test[arr[k][q]-1]++;
						}
					}
					checkSudoku();
				}
			}
			System.out.println("#"+tc+" "+result);
		}
	}

	private static void checkSudoku() {
		// TODO Auto-generated method stub
		//System.out.println(Arrays.toString(test));
		for (int i = 0; i < test.length; i++) {
			if(test[i]!=1)//1개도 안나왔거나 여러개나왔다면
				result=0;
			test[i]=0;//다시쓰게 초기화
		}
		
	}
}
