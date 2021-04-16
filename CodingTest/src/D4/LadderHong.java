package D4;

import java.util.Scanner;

public class LadderHong {
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
			int goalIdx = 0;
			for(int j = 0; j < MAX; j++) {
				if( map[MAX-1][j] != 0 ) {
					if(map[MAX-1][j] == 2)
						goalIdx = idx;//시작점으로 지정
					lanes[idx++] = j;//살 담고 인덱스 이동
				}
			}
			int currentIdx = goalIdx;
			for(int i = MAX-1; i >= 0; i--) {
				if( lanes[currentIdx] - 1 >= 0 && map[i][lanes[currentIdx]-1] == 1 ) // 바깥으로 나가는게 아니고, 왼쪽값이 1이면
					currentIdx--;//왼쪽살로 이동
				else if( lanes[currentIdx] + 1 < MAX && map[i][lanes[currentIdx]+1] == 1  )
					currentIdx++;//오른쪽살로 이동.
			}
			System.out.println("#" + tc + " " + lanes[currentIdx]);
		}
	}
}
