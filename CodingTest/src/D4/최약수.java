package D4;

import java.util.Scanner;

public class 최약수 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T =sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N =sc.nextInt();
			int cnt=0;
			int res=0;
			int temp=0;
			if(N>=1000) {
			 temp= N;
			}
			while(temp >= 1000) {
				temp /= 10;
				cnt++;
			}
			
			if(cnt==0) {
				if(N<10)
					res = (N >= 5) ? 3 : ( N >= 2 ? 2 : ( N >= 1 ? 1 : 0));
				else if(N<100) {
					res = (N >= 50) ? 7 : ( N >= 25 ? 6 : ( N >= 20 ? 5 : 4));
				}
				else if(N<1000) {
					res = (N >= 500) ? 12 : ( N >= 250 ? 11 : ( N >= 200 ? 10 :  ( N >= 125 ? 9 : 8)));
				}
			} else {
				res = 7 + 5*cnt;
				
			}
			
			if(temp >= 500)
				res+= 5;
			else if(temp >= 250)
				res+= 4;
			else if(temp >=200)
				res+= 3;
			else if(temp >=125)
				res+= 2;
			else if(temp >=100)
				res+= 1;
			
			System.out.println("#"+tc+" "+res);
		}
	}

}
