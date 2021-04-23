package D5;

import java.util.Arrays;
import java.util.Scanner;

public class 보호필름 {
	
	static int D,W,K;
	static int res;
	static int film[][];
	static int sel[];
	static boolean exit;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			D = sc.nextInt();
			W = sc.nextInt();
			K = sc.nextInt();
			film = new int[D][W];
			
			for (int i = 0; i < D; i++) {
				for (int j = 0; j < W; j++) {
					film[i][j] = sc.nextInt();
				}
			}

			if(K==1) {//무조건 통과
				System.out.println("#"+tc+" "+0);
			}
			else {
				
				exit = false;
				res = 987654321;
				sel = new int[D];
				Arrays.fill(sel, -1);
		
				for (int i = 0; i <= K; i++) {
					//점점 약품수를 늘리자.
					powerSet(0,0,i);
				}
				
				System.out.println("#"+tc+" "+res);
			}
		}
	}

	private static void powerSet(int idx,int cnt,int end) {
		if(exit) return; //한번이라도 성공했다면 더이상 볼필요 없다 다 꺼라.
		
		if(cnt == end) {//적게 넣는 것부터 시작한다. 약품을 투입할 경우의 수를 확정했다.
			//System.out.println(Arrays.toString(sel));
			if(filmTest()) {
				exit = true;
				res = cnt;
			};//필름 테스트를 시작해라.
			return;
		}
		if(idx == D) return;
		sel[idx] = 0;//A약품
		powerSet(idx+1,cnt+1,end);
		sel[idx] = 1;//B약품
		powerSet(idx+1,cnt+1,end);
		sel[idx] = -1;//약품선택안함
		powerSet(idx+1,cnt,end);
	}
	
	private static boolean filmTest() {
		
		boolean flag = true;//맨처음은 해야하니 true로 초기화
		
		for (int i = 0; i < W; i++) {
			if(!flag) break; //한번이라도 실패하면 더 이상 루프를 반복할 필요가 없다.
				
			int prev = film[0][i];		
			int cnt = 0;
			flag = false;
			
			for (int j = 0; j < D; j++) {//위부터 눌러보면서
				
				int next = film[j][i];
				if(sel[j] != -1) next = sel[j];//약품이 있으면 그수로 초기화
				
				if(next == prev) cnt++;
				else {
					prev = next;
					cnt = 1;
				}
				
				if(cnt==K) {
					flag = true;
					break; //성공했으면 더 밑을 볼 필요가 없다.
				}
			}
		}
		return flag;//성공했다면 flag가 true일 것이다.
	}
}
