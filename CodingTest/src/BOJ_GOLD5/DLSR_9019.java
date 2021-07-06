package BOJ_GOLD5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DLSR_9019 {
	
	static boolean arr[];
	
	static class Node{
		int num;
		String str;
		
		public Node(int num, String str) {
			this.num = num;
			this.str = str;
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 0; tc < T; tc++) {
			
			arr = new boolean[10000];
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			Queue<Node> q = new LinkedList<>();
			
			q.add(new Node(A,""));
			arr[A] = true;
			
			while(!q.isEmpty()) {
				
				Node n = q.poll();
				
				if(n.num == B) {
					System.out.println(n.str);
					break;
				}
				
				int D = n.num*2 % 10000;
				int S = n.num == 0 ? 9999 : n.num-1;
				int L = n.num % 1000 * 10 + n.num/1000;
				int R = n.num % 10 * 1000 + n.num / 10;
				
				if(!arr[D]) {
					q.add(new Node(D,n.str+"D"));
					arr[D] = true;
				}
				if(!arr[S]) {
					q.add(new Node(S,n.str+"S"));
					arr[S] = true;
				}
				if(!arr[L]) {
					q.add(new Node(L,n.str+"L"));
					arr[L] = true;
				}
				if(!arr[R]) {
					q.add(new Node(R,n.str+"R"));
					arr[R] = true;
				}
				
			}
		}
	}

}
