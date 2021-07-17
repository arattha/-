package BOJ_GOLD5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 이모티콘_14226 {
	
	static boolean visited[][] = new boolean[2001][2001];
	static int S;
	static int res;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		S = sc.nextInt();
		
		bfs();
		//System.out.println(res);
	}
	
	static class Node {
		int time;
		int clen;
		int elen;
		public Node(int time, int clen, int elen) {
			super();
			this.time = time;
			this.clen = clen;
			this.elen = elen;
		}
		
		
	}
	
	private static void bfs() {
		
		Queue<Node> q = new LinkedList();
		q.add(new Node(0,0,1));
		visited[0][1] = true;
		visited[0][0] = true;
		
		
		int l = 0;
		while(!q.isEmpty()) {
			Node n = q.poll();
			
			if(n.elen == S) {
				System.out.println(n.time);
				return;
			}
			
			//1번 모두 복사해서 클립보드에 저장
			if(n.elen > 0 && n.elen < 2000) {
				
				if(!visited[n.elen][n.elen]) {
					visited[n.elen][n.elen] = true;
					q.offer(new Node(n.time + 1,n.elen,n.elen));
				}
				
				if(!visited[n.elen - 1][n.elen]) {
					visited[n.elen - 1][n.elen] = true;
					q.offer(new Node(n.time + 1,n.clen, n.elen - 1));
				}
				
			}
			
			if(n.clen > 0 && n.elen + n.clen < 2000) {
				if(!visited[n.elen + n.clen][n.clen]) {
					visited[n.elen + n.clen][n.clen] = true;
					q.offer(new Node(n.time + 1 , n.clen, n.elen + n.clen));
				}
			}
		}
	}
	
}
