package BOJ_GOLD5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 치킨배달 {
	
	static int N,M;
	static int map[][];
	static ArrayList<Container> shops;
	static ArrayList<Container> homes;
	static int[] sel;
	static int res;
	
	public static class Container{
		int y,x;

		public Container(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		shops = new ArrayList<>();
		homes = new ArrayList<>();
		sel = new int[M];
		res = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) shops.add(new Container(i, j));
				if(map[i][j] == 1) homes.add(new Container(i, j));
			}
		}
		comb(0,0);
		System.out.println(res); //최대 M개
	}

	private static void comb(int cnt, int start) {
		// TODO Auto-generated method stub
		if(cnt == M) {
			res = Math.min(res, cal());
			return;
		}
		
		for (int i = start; i < shops.size(); i++) {
			sel[cnt] = i;
			comb(cnt+1,i+1);
		}
	}

	private static int cal() {
		int distance = 0;
		
		for (int i = 0; i < homes.size(); i++) {
			Container h = homes.get(i);
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < M; j++) {
				Container c= shops.get(sel[j]);
				int len = Math.abs( h.y - c.y) + Math.abs( h.x - c.x );
				if(min > len) {
					min = len;
				}
			}
			distance += min;
		}
		return distance;
		
	}
	
}
