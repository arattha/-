package D4;

import java.util.Scanner;

public class 가장빠른문자열타이핑 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner (System.in);
        int T = sc.nextInt();
        
        for (int tc = 1; tc <= T; tc++) {
                String A = sc.next();
                String B = sc.next();

                A = A.replace(B," ");
                System.out.println("#" + tc + " " + A.length());
        }
	}
	
}
