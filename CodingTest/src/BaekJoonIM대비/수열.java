package BaekJoonIM대비;

import java.util.Scanner;

public class 수열 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int res=1;
		
		int[] arr=new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i]=sc.nextInt();
		}
		
		int cnt=1;
		
		for (int i = 0; i < N-1; i++) {//커지는 지 체크
			if(arr[i]<=arr[i+1])cnt++;
			else {
				if(res<cnt) 
					res=cnt;
				cnt=1;
			}
		}
		if(res<cnt)
			res=cnt;
		cnt=1;
		for (int i = 0; i < N-1; i++) {//작아지는지 체크
			if(arr[i]>=arr[i+1])cnt++;
			else {
				if(res<cnt)
					res=cnt;
				cnt=1;
			}
		}
		if(res<cnt)
			res=cnt;
		System.out.println(res);
	}

}
