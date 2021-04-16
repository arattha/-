package BaekJoon;

import java.util.Scanner;


public class 정수제곱근 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Scanner sc= new Scanner(System.in);
		
		long n = sc.nextLong();
		
		long right=n/2;//기본 값이 너무 크므로 /2 해준다.
		long left=1;
		
		long mid=0;
		long midP=0;
		
		while(left <= right) { // 왼쪽이랑 오른쪽이 곂치게되면 그만둔다
			
			mid=(left+right)/2;//중앙 찾기
			midP=mid*mid;//제곱
			
			if(midP > n || midP<=0) right = mid-1;//제곱수가 n보다 크면 mid보다 작은범위에서
			//단 값이 너무 커 long 도 overflow 나므로 음수가 나오면 n보다 크다고 판단.
			else if(midP < n) left = mid + 1;//제곱수가 n보다 작으면 mid보다 큰범위에서
			else break;
			
		}
		if(n>midP)
			mid+=1;		
		System.out.println(mid);
		
	}

}
