package D4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Contact {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			
			int N = sc.nextInt();
			int first = sc.nextInt();
			
			int resDepth=0;
			int resN=0;
			
			boolean emergency[][] = new boolean[101][101];
			boolean visited[] = new boolean[101];
			
			Queue<Call> q = new LinkedList<>();
			
			for (int i = 1; i <= N/2; i++) {
				
				int start = sc.nextInt();
				int end = sc.nextInt();
				emergency[start][end] = true;
				
			}
			
			visited[first] = true;
			q.offer(new Call(first,1));
			//
			
			while(!q.isEmpty()) {
				
				Call p = q.poll();
				
				for (int i = 1; i <= 100; i++) {
					if(emergency[p.point][i] && (!visited[i])) { //연락해야하면서 안갔었으면,
						visited[i] = true;//갔던 애라고 표시.
						q.offer(new Call(i,p.depth + 1)); //다음 번호 등록, depth 등록
					}
				}
				
				if(p.depth > resDepth) {
					resDepth = p.depth;
					resN= p.point;
				}
				else if(p.depth == resDepth && p.point > resN) {
					resN= p.point;
				}
			}
			
			System.out.println("#"+tc+" "+resN);
			
		}
	}

}

class Call {
	
	int point;
	int depth;
	
	Call(int start,int depth){
		this.point = start;
		this.depth = depth;
	}
	
}
