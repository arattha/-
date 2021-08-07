package BOJ_GOLD4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 이분그래프 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 0; tc < T; tc++) {
			
			int V = sc.nextInt();
			int E = sc.nextInt();
			
			LinkedList<Integer> adjList[] = new LinkedList[V];
			for (int i = 0; i < V; i++) {
				adjList[i] = new LinkedList<>();
			}
			
			
			for (int i = 0; i < E; i++) {
				int start = sc.nextInt() - 1;
				int end = sc.nextInt() - 1;
				
				adjList[start].add(end);
				adjList[end].add(start);
			}

			
			boolean flag = false;
			int[] visit = new int[V]; //0이면 아직 안감
			Queue<Integer> q = new LinkedList<>();
			
			for (int i = 0; i < V; i++) {
				if(visit[i] == 0) {//출발 안한, 안갔던 노드에 한해서.
					q.offer(i);
					visit[i] = 1;
					while(!q.isEmpty()) {
						int node = q.poll();
						
						for (int t : adjList[node]) {
							if(visit[t] == 0) {//다음 정점 안갔으면
								q.offer(t);
								visit[t] = visit[node] * -1; // 나랑 다른 색
							} else if(visit[t] == visit[node]) {//나랑 인접했는데 같은색이면 끝
								flag = true;
								break;
							}
						}
						
						if(flag) break;
					}
				}
			}
			System.out.println(flag ? "NO" : "YES");
		}
		
		
	}

}
