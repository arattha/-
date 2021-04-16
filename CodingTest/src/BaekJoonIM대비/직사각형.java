package BaekJoonIM대비;

import java.util.Scanner;

public class 직사각형 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		for (int tc = 0; tc < 4; tc++) {
			
			int x1=sc.nextInt();
			int y1=sc.nextInt();
			int p1=sc.nextInt();
			int q1=sc.nextInt();
			
			int x2=sc.nextInt();
			int y2=sc.nextInt();
			int p2=sc.nextInt();
			int q2=sc.nextInt();
			
			
			if(p1 < x2 || p2 < x1 || q1 < y2 || q2 < y1)//밖
				System.out.println("d");
			else if((x1 == p2 && y1 == q2) || ( p1 == x2 && y1 == q2) || (p1 == x2 && q1 == y2 ) || ( x1 == p2 && q1 == y2 ))
				System.out.println("c");//점으로 곂치는 경우
			else if(x1 == p2 || p1 == x2 || q1 == y2  || q2 == y1 )
				System.out.println("b");//선분으로 곂치는 경우
			else
				System.out.println("a");
		}
	}

}
