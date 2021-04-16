package 카카오커머스;

import java.util.Arrays;
import java.util.Scanner;

public class 상품권 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] giftcards=new int[N];
		int[] wants=new int[N];
		
		for (int i = 0; i < N; i++) {
			giftcards[i]=sc.nextInt();
		}
		for (int i = 0; i < N; i++) {
			wants[i]=sc.nextInt();
		}
		//giftcards.length
		int cnt[][] = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			cnt[giftcards[i]-1][0]++;
			cnt[wants[i]-1][1]++;		
		}
		int res=0;
		
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(cnt[i]));
		}
		
		for (int i = 0; i < N; i++) {
			res+=Math.abs(cnt[i][0]-cnt[i][1]);
		}
		System.out.println(res/2);
	}
	
}
