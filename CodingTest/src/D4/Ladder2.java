package D4;

import java.util.Arrays;
import java.util.Scanner;

public class Ladder2 {
	static int MAX = 100;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for(int tc = 1; tc <= T; tc++) {
			sc.nextInt(); 
			int[][] map = new int[MAX][MAX];
			for(int i = 0; i < MAX; i++) {
				for(int j = 0; j < MAX; j++) 
					map[i][j] = sc.nextInt();
			}
			int[] lanes = new int[MAX];//살 찾는 곳
			int idx = 0;
			for(int j = 0; j < MAX; j++) {
				if( map[MAX-1][j] != 0 ) {
					lanes[idx++] = j;//살 담고 인덱스 이동
				}
			}
			
			
			int resX=-1;
			int resL=200;
			for (int j = 0; j < 2; j++) {
				
				int currentIdx = j;//왼쪽 살부터.
				int start = lanes[j];//현 시작점 따로 저장
				int len=0;//길이
				
				for(int i = 0; i < MAX; i++) {
					
					if( lanes[currentIdx] - 1 >= 0 && map[i][lanes[currentIdx]-1] == 1 ) {// 바깥으로 나가는게 아니고, 왼쪽값이 1이면
						
						int pre=lanes[currentIdx];
						currentIdx--;//왼쪽살로 이동
						int post=lanes[currentIdx];
						len+=pre-post;
					}
					
					else if( lanes[currentIdx] + 1 < MAX && map[i][lanes[currentIdx]+1] == 1  ) {
						int pre=lanes[currentIdx];
						currentIdx++;//오른쪽살로 이동.
						int post=lanes[currentIdx];
						len+=post-pre;
					}
				}
				System.out.println(len);
				if(resL > len) {
					resX=start;
					resL=len;
				}
				else if(resL == len) {
					resX=Math.max(resX, start);
				}
				
			}
			System.out.println("#" + tc + " " + resX);
		}
	}
}
