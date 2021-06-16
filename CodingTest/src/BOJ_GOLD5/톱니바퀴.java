package BOJ_GOLD5;

import java.util.Arrays;
import java.util.Scanner;

public class 톱니바퀴 {
	
	static int N = 4;
	static String[] gear;
	static int arr[][];
	static boolean move[];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		gear = new String[N];
		
		for (int i = 0; i < N; i++) {
			gear[i] = sc.next();
		}
		
		int K = sc.nextInt();
		arr = new int[K][2];
		
		for (int i = 0; i < K; i++) {
			arr[i][0] = sc.nextInt() - 1;
			arr[i][1] = sc.nextInt();
		}

		for (int i = 0; i < K; i++) {
			move = new boolean[4];
			go(arr[i][0],arr[i][1]);
		}
		int res = 0;
		for (int i = 0; i < N; i++) {
			if(gear[i].charAt(0) != '0') {
				if(i == 0) res++;
				else if(i == 1) res += 2;
				else if(i == 2) res += 4;
				else if(i == 3) res += 8;
			}
		}
		System.out.println(res);
	}
	//2가 오른쪽 톱니 6이 왼쪽 톱니
	private static void go(int num, int dir) {
		// TODO Auto-generated method stub
		if(move[num]) return;
		move[num]=true;
		
		char leftState = gear[num].charAt(6);
		char rightState =  gear[num].charAt(2);
		
		if(dir == 1)
			gear[num] = gear[num].substring(7,8) + gear[num].substring(0, 7);
		else
			gear[num] = gear[num].substring(1) + gear[num].substring(0,1);
		
		//왼 전파
		if(num - 1 >= 0 && gear[num - 1].charAt(2) != leftState) go(num - 1 , dir*-1);
		//오른 전파
		if(num + 1 < 4 && gear[num + 1].charAt(6) != rightState) go(num + 1 , dir*-1);
		
	}

}
