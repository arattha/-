package BaekJoonIM대비;

import java.util.Scanner;

public class 빙고 {

	static int[][] map = new int[5][5];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		int cnt=0;
		while (true) {
			cnt++;
			int call= sc.nextInt();
			
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if(call == map[i][j])
						map[i][j] = 0;
				}
			}
			
			if(check())
				break;
			
		}
		System.out.println(cnt);
	}
	
	public static boolean check() {
		
		int bingo=0;
		
		for (int i = 0; i < 5; i++) {
			
			int q=0;
			int p=0;
			
			for (int j = 0; j < 5; j++) {
				
				if(map[i][j]==0) q++;
				if(map[j][i]==0) p++;
				
			}
			
			if(q==5)bingo++;
			if(p==5)bingo++;
			
		}
		int t=0;
		int w=0;
		for (int i = 0; i < 5; i++) {
			
			
			if(map[i][i]==0) t++;
			if(map[i][4-i]==0) w++;
			
			if(t==5)bingo++;
			if(w==5)bingo++;
			
		}
		
		if(bingo>=3)
			return true;
		
		return false;
	}
}
