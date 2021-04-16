package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 격자판의숫자이어붙이기 {
    static HashSet<Integer> set;
    static int[][] map;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int tc = 1; tc <= T; tc++) {
            map = new int[4][4];
            set = new HashSet<>();
            StringTokenizer st = null;
            
            for(int i=0; i<4; i++) {
            	st= new StringTokenizer(br.readLine());
                for(int j=0; j<4; j++)
                    map[i][j] = Integer.parseInt(st.nextToken());
            }
            
            for(int i=0; i<4; i++) {
                for(int j=0; j<4; j++)
                    dfs(i, j, 1, map[i][j]);
            }
   
            System.out.println("#"+tc+" "+set.size());
		}
	}
    
    public static void dfs(int y, int x, int idx, int sum) {
       	if(idx==7) {
            set.add(sum);
            return;
        }
        
        for(int i=0; i<4; i++) {
            int ny = y+dy[i];
            int nx = x+dx[i];
            
            if(nx<0 || nx>=4 || ny<0 || ny>=4) continue;
            
            dfs(ny, nx, idx+1, sum*10+map[ny][nx]);
        }
    }
}
