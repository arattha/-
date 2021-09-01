package BOJ_GOLD4;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
 
public class 숨바꼭질4_13913 {
	
    static int N,K,cnt,min=Integer.MAX_VALUE;
    static int arr[] = new int[100001];
    static boolean visit[] = new boolean[100001];
    static int time[] = new int[100001];
    
    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        bfs();
        
        int i = K;
        Stack<Integer> stack = new Stack<>();
        
        stack.add(K);
        while(i != N) {
        	stack.add(time[i]);
        	i = time[i];
        }
        
        StringBuilder sb = new StringBuilder();
        
        sb.append(min).append("\n");
        while(!stack.isEmpty()) {
        	sb.append(stack.pop()).append(" ");
        }
        
        System.out.print(sb);
    }
    
    private static void bfs() {
        // TODO Auto-generated method stub
        Queue<Point> queue = new LinkedList<Point>();
        queue.add(new Point(N,0));
        while(!queue.isEmpty()) {
            Point po = queue.poll();
            
            if(po.x == K) {
                min = Math.min(min, po.y);
                break;
            }
            
            if(po.x * 2 <= 100000 && !visit[po.x*2]) {
                queue.add(new Point(po.x*2, po.y+1));
                time[po.x*2] = po.x;
                visit[po.x*2] = true;
            }
            if(po.x + 1 <= 100000 && !visit[po.x+1]) {
                queue.add(new Point(po.x+1, po.y+1));
                time[po.x + 1] = po.x;
                visit[po.x+1] = true;
            }
            if(po.x -1 >= 0 && !visit[po.x-1]) {
                queue.add(new Point(po.x-1, po.y+1));
                time[po.x - 1] = po.x;
                visit[po.x-1] = true;
            }
            
        }
    }
    
}
