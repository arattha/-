package D4;

import java.util.Scanner;

public class 방향전환 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			
			int dx = Math.abs(x1-x2);
			int dy = Math.abs(y1-y2); 
			
			if(dy > dx) {
				int temp=dx;
				dx=dy;
				dy=temp;
			}
				
			
			int ans = ((dx/2)*4) + dx%2;
			
			if(dy % 2 ==1) {
				if(dx%2==1) ans++;
				else ans--;
			}
			
			System.out.println("#"+tc+" "+ans);
			
		}
	}

}
