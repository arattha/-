package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Nod {
	int y;
	int x;
	
	Nod(int y, int x){
		this.y=y;
		this.x=x;
	}
	
}

public class 보급로 {
	
	static int N;
	static int map[][];
	static int go[][];
	static int res;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			
			N =Integer.parseInt(br.readLine());
			map= new int[N][N];
			go=new int[N][N];
			for (int i = 0; i < N; i++) {
				
				char[] temp=br.readLine().toCharArray();
				
				for (int j = 0; j < N; j++) {
					map[i][j]=(int) temp[j]-'0';
					go[i][j]=Integer.MAX_VALUE;
				}
			}
			
			go[0][0]=0;
			
			res=Integer.MAX_VALUE;
			bfs();
			
			System.out.println("#"+tc+" "+res);
		}
	}

	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,-1,1};
	
	private static void bfs() {
		// TODO Auto-generated method stub
		
		Queue<Nod> q = new LinkedList<Nod>();
		q.offer(new Nod(0,0));
		
		while(!q.isEmpty()) {
			Nod n = q.poll();
			
			int y = n.y;
			int x = n.x;
			
			if(y == N-1 && x == N-1) {
				res = res < go[x][y] ? res : go[x][y] ;
			}
			
			for (int i = 0; i < dr.length; i++) {
				int dy= y + dr[i];
				int dx= x + dc[i];
				
				if(dy >= 0 && dx >= 0 && dy < N && dx < N) {
					if( go[dy][dx] > go[y][x] + map[dy][dx] ) {
						go[dy][dx] = go[y][x] + map[dy][dx];
						q.offer(new Nod(dy,dx));
					}
				}
				
				
			}
			
		}
		
	}
}

