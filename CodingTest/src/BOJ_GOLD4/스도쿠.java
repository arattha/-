package BOJ_GOLD4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class 스도쿠 {
	
	static int map[][]; 
	static List<Node> arr;
	static class Node{
		int y,x;
		boolean[] t = new boolean[10]; 
		public Node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		map = new int[9][9];
		
		arr = new ArrayList<Node>();
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 0) arr.add(new Node(i,j));
			}
		}
		
		check();
		dfs(0);
		
	}
	
	private static void check() {
		
		for (int k = 0 ; k < arr.size(); k++) {
			//세로 측정
			Node n = arr.get(k);
			arr.get(k).t[0] = true;
			for (int i = 0; i < 9; i++) {
				arr.get(k).t[map[i][n.x]] = true;
			}
			//가로 측정
			for (int i = 0; i < 9; i++) {
				arr.get(k).t[map[n.y][i]] = true;
			}
			//3x3 측정
			int p = n.y/3 * 3;
			int q = n.x/3 * 3;
			for (int i = p; i < p + 3; i++) {
				for (int j = q; j < q + 3; j++) {
					arr.get(k).t[map[i][j]] = true;
				}
			}
		}		
	}
	
	private static void dfs(int cnt) {
		// TODO Auto-generated method stub
		if(cnt == arr.size()) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(map[i][j] + " ");
				}
				sb.append("\n");
			}
			System.out.println(sb);
			System.exit(0);
			return;
		}
		
		Node n = arr.get(cnt);
		
		for (int i = 1; i < 10; i++) {
			if(n.t[i]) continue;
			//놔보고 되야지만 다음으로
			if(check2(n.y,n.x,i)) {
				map[n.y][n.x] = i;
				dfs(cnt+1);

			}
			map[n.y][n.x] = 0;
			//돌려놓자.
			
		}
	}
	
	private static boolean check2(int y, int x, int num) {
		for (int i = 0; i < 9; i++) {
			if(map[i][x] == num) return false;
		}
		
		for (int i = 0; i < 9; i++) {
			if(map[y][i] == num) return false;
		}
		//3x3 측정
		int p = y/3 * 3;
		int q = x/3 * 3;
		for (int i = p; i < p + 3; i++) {
			for (int j = q; j < q + 3; j++) {
				if(map[i][j] == num) return false;
			}
		}
		return true;
	}
	
}
