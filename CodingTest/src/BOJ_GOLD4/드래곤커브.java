package BOJ_GOLD4;

import java.util.Scanner;
import java.util.Stack;

public class 드래곤커브 {
	
	static boolean map[][] = new boolean[101][101];
	
	static int dr[] = {0,-1,0,1};
	static int dc[] = {1,0,-1,0};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		
		for (int i = 0; i < N; i++) {
			dragonCurve(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
			
		}
		int res = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1])
					res++;
			}
		}
		System.out.println(res);
	}
	
	public static void dragonCurve(int x,int y,int d,int g) {
		Stack<Integer> stack = new Stack<>();
		
		
		map[y][x] = true;//기본좌표
		
		int curY = y + dr[d];//기본좌표
		int curX = x + dc[d];//기본좌표 
		map[curY][curX] = true;
		stack.add(d);
		
		for (int i = 0; i < g; i++) {
			Stack<Integer> stack2 = (Stack<Integer>) stack.clone();
			
			int size = stack2.size();
			
			for (int j = 0; j < size; j++) {
				
				int dir = (stack2.pop() + 1) % 4; // 다음 방향
				
				int nr = curY + dr[dir];
				int nc = curX + dc[dir];
				
				map[nr][nc] = true;
				
				stack.add(dir);
				curY = nr;
				curX = nc;
			}
			
		}
		
	}
	
}
