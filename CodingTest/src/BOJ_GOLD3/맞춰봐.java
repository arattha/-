package BOJ_GOLD3;

import java.util.Scanner;

public class 맞춰봐 {

	static int N;
	static int total;
	static char[][] S;
	static int res[];
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		res = new int[N];
		total = N*(N+1)/2;
		S = new char[N][N];
		
		char temp[] = sc.next().toCharArray();
		int idx = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(i>j) continue;
				S[i][j] = temp[idx++];
			}
		}
		
		go(0,0);
		
	}

	private static void go(int sum,int cnt) {
		
		if(N == cnt) {//끝에 도달
			for (int i = 0; i < N; i++) {
				System.out.print(res[i]+" ");
			}
			System.exit(0);
			return;
		}
		
		for (int i = -10; i <= 10; i++) {
			res[cnt]=i;
			if(check(sum + i,cnt)) {
				go(sum + i,cnt+1);
			}
		}
		
	}
	
	private static boolean check(int sum,int cnt) {
		
		for (int i = 0; i <= cnt; i++) {
			
			if(S[i][cnt] == '-') {
				if(sum >= 0) return false;
			} else if(S[i][cnt] == '+') {
				if(sum <= 0) return false;
			} else if(S[i][cnt] == '0') {
				if(sum != 0) return false;
			}
			sum -= res[i];
		}
		
		return true;
	}

}
