package BaekJoonIM대비;

import java.util.Arrays;
import java.util.Scanner;

public class 자리배정 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int R = sc.nextInt();
		int C = sc.nextInt();
		int K = sc.nextInt();
		
		int map[][]= new int[R][C];//바꿔서 편하게
		int tempR= R;
		int tempC= C;
		int i=0; //x좌표
		int j=-1; //y좌표
		int change=1;
		int cnt=1;
		while(true) {
			
			for(int k=0;k<tempC;k++) {//가로
				j+=change;
				map[i][j]=cnt++;
			}
			if(cnt==K)
				break;
			tempC--;
			tempR--;
			for(int k=0;k<tempR;k++) {//세로
				i+=change;
				map[i][j]=cnt++;
			}
			change*=-1;
		}
		for (int l = 0; l < R; l++) {
			System.out.println(Arrays.toString(map[l]));
		}
	}

}
