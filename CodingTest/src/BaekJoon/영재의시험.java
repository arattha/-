package BaekJoon;

import java.util.Arrays;
import java.util.Scanner;

public class 영재의시험 {
	
	static int N = 10;
	static int[] ans;
	static int score;
	static int result;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		ans = new int[N];
		score=0;
		for (int i = 0; i < 10; i++) {
			ans[i]=sc.nextInt();
		}
		permutation(0,0,0,0);
		System.out.println(result);
	}
	//cnt 배열용 dup 중복용 pre 이전거 score 점수
	public static void permutation(int cnt,int dup,int pre,int score) {
		
		if(score>=5) {
			result++;
			return;
		}
		
		if(cnt == N) {
			return;
		}
		
		for (int i = 1; i <= 5; i++) {//중복순열
			if(pre==i)
				dup++;
			else
				dup=1;
			if(dup==3)//중복 3번이면 안해.
				continue;
			
			if(ans[cnt]==i)
				score++;
			
			permutation(cnt+1,dup,i,score);
		}
	}
}
