package BaekJoonIM대비;

import java.util.Scanner;

public class 주사위쌓기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//AF CE BD
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[][] dice = new int[N][6];
		
		for (int i = 0; i < N; i++) {
			dice[i][0]=sc.nextInt();//A
			dice[i][1]=sc.nextInt();//b
			dice[i][2]=sc.nextInt();//c
			dice[i][4]=sc.nextInt();//d
			dice[i][5]=sc.nextInt();//e
			dice[i][3]=sc.nextInt();//f
		}
		int res=0;
		for (int i = 0; i < 6; i++) {//첫번째 주사위
			
			int bottom = dice[0][i];
			int top = dice[0][(i+3)%6];
			int sum = max(top,bottom);
			
			for (int j = 1; j < N; j++) {//다음 주사위부터
				for (int k = 0; k < 6; k++) {
					if(dice[j][k]==top) {//같으면
						bottom=dice[j][k];
						top=dice[j][(k+3)%6];
						break;
					}
				}
				sum+=max(top,bottom);	
			}
			res=Math.max(res, sum);
		}
		System.out.println(res);
	}

	public static int max(int top,int bottom) {
		
		if( (top + bottom) == 11)//5랑 6 사용
			return 4;
		else if( bottom == 6 || top == 6 )// 6 사용
			return 5;
		else //5랑 6 사용
			return 6;
	}
	
}
