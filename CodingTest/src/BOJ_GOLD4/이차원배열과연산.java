package BOJ_GOLD4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 이차원배열과연산 {
	
	static int r,c,k;
	static int arr[][] = new int[101][101];
	static int ylen = 3;
	static int xlen = 3;
	
	public static class Number implements Comparable<Number>{
		
		int num;
		int cnt;
		
		public Number(int num, int cnt) {
			super();
			this.num = num;
			this.cnt = cnt;
		}
		
		@Override
		public int compareTo(Number o) {
			// TODO Auto-generated method stub
			
			if(this.cnt == o.cnt) {
				return Integer.compare(this.num, o.num);
			}else {
				return Integer.compare(this.cnt, o.cnt);
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int time = 0;
		
		while(time != 101) {
			if(arr[r][c] == k) {
				break;
			}
//				if(time < 5) {
//					for (int i = 1; i <= ylen; i++) {
//						System.out.println(Arrays.toString(arr[i]));
//					}System.out.println();
//					System.out.println(ylen+" "+xlen);
//				}
			
			if(ylen >= xlen) {
				R();
			}else {
				C();
			}
			
			
			
			time++;
			
			
			
		}
		System.out.println(time == 101 ? -1 : time);
	}


	private static void R() {
		// TODO Auto-generated method stub
		
		for (int i = 1; i <= ylen ; i++) {
			PriorityQueue<Number> pq = new PriorityQueue<>();
			Map<Integer , Integer> m = new HashMap<>();
			
			for (int j = 1; j <= xlen; j++) {
				if(arr[i][j] == 0) continue;
				m.compute(arr[i][j], (k,v) -> v == null ? 1: v + 1);
			}
			
			m.forEach((k,v) -> pq.add(new Number(k,v)));
			
			int t = 1;
			while(!pq.isEmpty()) {
				Number n = pq.poll();
				arr[i][t++] = n.num;
				arr[i][t++] = n.cnt;
			}
			
			xlen = Math.max(xlen, t);
			
			for (int j = t; j <=100 ; j++) {
				arr[i][j] = 0;
			}
		}
		
	}
	
	private static void C() {
		// TODO Auto-generated method stub
		//i == key
		//j == i
		for (int i = 1; i <= xlen ; i++) {
			PriorityQueue<Number> pq = new PriorityQueue<>();
			Map<Integer , Integer> m = new HashMap<>();
			
			for (int j = 1; j <= ylen; j++) {
				if(arr[j][i] == 0) continue;
				m.compute(arr[j][i], (k,v) -> v == null ? 1: v + 1);
			}
			
			m.forEach((k,v) -> pq.add(new Number(k,v)));
			
			int t = 1;
			while(!pq.isEmpty()) {
				Number n = pq.poll();
				arr[t++][i] = n.num;
				arr[t++][i] = n.cnt;
			}
			
			ylen = Math.max(ylen, t);
			
			for (int j = t; j <=100 ; j++) {
				arr[j][i] = 0;
			}
		}
		
	}
}



