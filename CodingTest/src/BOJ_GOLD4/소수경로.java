package BOJ_GOLD4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 소수경로 {
	
	static int S,E;
	
	static boolean arr[];
	static int t[] = {1000,100,10,1};
	static boolean visited[];
	static int res;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		prime();
		
		for (int tc = 0; tc < T; tc++) {
			
			S = sc.nextInt();
			E = sc.nextInt();
			res = Integer.MAX_VALUE;
			bfs();
			System.out.println(res == Integer.MAX_VALUE ? "Impossible": res);
			
		}
	}
	
	private static void bfs() {
		// TODO Auto-generated method stub
		
		Queue<Integer> q = new LinkedList<>();
		visited = new boolean[10001];
		q.offer(S);
		visited[S] = true;
		q.offer(0);
		
		while(!q.isEmpty()) {
			
			int num = q.poll();
			int cnt = q.poll();
			
			if(num == E) {
				res = Math.min(res, cnt);
				return;
			}
			
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 10; j++) {
					
					int newNum = make(num,t[i],j);
					if(newNum < 1000) continue;
					if(!arr[newNum]) continue;
					if(visited[newNum]) continue;
					
					q.offer(newNum); visited[newNum] = true;
					q.offer(cnt+1);
				}
			}
		}
	}

	public static int make(int target, int position, int n) {
		
		int left = target - target%(position*10);
		int right = target % (position);
		
		int result = left+right+(position*n);
		return result;
	}
	
	public static void prime() {
		int num = 10000;
 
        arr = new boolean[num+1];    //true 이면 해당 인덱스 소수.
        arr[0] = arr[1] = false;
        for(int i=2; i<=num; i++) {
            arr[i] = true;
        }
        for(int i=2; i*i<=num; i+=1) {
            for(int j=i*i; j<=num; j+=i) {
                arr[j] = false;        //2를 제외한 2의 배수 false
            }
        }
	}
	
}
