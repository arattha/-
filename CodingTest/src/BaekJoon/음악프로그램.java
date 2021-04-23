package BaekJoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 음악프로그램 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] indegree = new int[N];
		int[][] adj = new int[N][N];
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < M; i++) {
			int e = sc.nextInt();
			int prev = sc.nextInt()-1;
			for (int j = 0; j < e-1; j++) {
				int next=sc.nextInt()-1;
				if(adj[prev][next]==0) {
					adj[prev][next]=1;
					indegree[next]++;
				}
				prev=next;
			}
		}
		
		Queue<Integer> queue = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			if(indegree[i]==0)
				queue.add(i);
		}
		
		int cnt = 0;
		while(!queue.isEmpty()) {
			int q = queue.poll();
			cnt++;
			sb.append(q+1).append("\n");
			for (int i = 0; i < N; i++) {
				if(adj[q][i]==1) {
					indegree[i]--;
					if(indegree[i]==0)
						queue.add(i);
				}
			}
		}
		System.out.println(cnt != N ? 0 : sb);
	}

}
