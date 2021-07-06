package BOJ_GOLD5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 스타트링크 {
	
	static class Node{
		int cnt,current;

		public Node(int cnt, int current) {
			this.cnt = cnt;
			this.current = current;
		}

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int F = sc.nextInt();
		int S = sc.nextInt();
		int G = sc.nextInt();
		int U = sc.nextInt();
		int D = sc.nextInt();
		
		Queue<Node> q = new LinkedList<Node>();
        q.add(new Node(0,S));
        boolean[] arr = new boolean[F+1];
        arr[S] = true;
        Node res= new Node(-1,-1);
        
        while (!q.isEmpty()) {
            Node n = q.poll();
            if (n.current == G) {
            	res = n;
            	break;
            }
            //다음 up 이동할 위치가 최대값보다 작고 방문하지 않은 지점이여야 한다.
            if (n.current + U <= F) {
                if (!arr[n.current + U]) {
                    arr[n.current + U] = true;
                    q.add(new Node(n.cnt+1 ,n.current + U));
                }
 
            }
            //다음 down 이동할 위치가 최대값보다 작고 방문하지 않은 지점이여야 한다.
            if (n.current - D > 0) {
                if (!arr[n.current - D]) {
                    arr[n.current - D] = true;
                    q.add(new Node(n.cnt+1 ,n.current - D));
                }
            }
 
        }
		System.out.println(res.cnt == -1 ? "use the stairs" : res.cnt);
	}

}
