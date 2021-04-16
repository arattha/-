package BaekJoonIM대비;

import java.util.Scanner;

public class 개미 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int W = sc.nextInt();
		int H = sc.nextInt();
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		int K =sc.nextInt();
		
		x+=K;
		y+=K;
		
		x = x%(2*W);
		y = y%(2*H);
		
		if(x>W) x=(2*W)-x;
		if(y>H) y=(2*H)-y;
		System.out.println(x+" "+y);
		
	}

}
