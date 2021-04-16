package D4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 벽돌깨기 {
	
	static int N,W,H;
	static int map[][];
	static int shoot[];
	static int dr[]= {-1,1,0,0};
	static int dc[]= {0,0,-1,1};
	static int block;
	static int res;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			W = sc.nextInt();
			H = sc.nextInt();
			res = W*H;
			map = new int[H][W];
			block=0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					map[i][j]=sc.nextInt();
					if(map[i][j]!=0) block++;
				}
			}
			
			shoot = new int[N];
			
			permutation(0);
			
			System.out.println("#"+tc+" "+res);
		}
		
	}
	
	private static void permutation(int cnt) {
		if(cnt==N) {
			int temp[][] = new int[H][W];
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					temp[i][j]=map[i][j];
				}
			}
			shooting(temp);
			return;
		}
		for (int i = 0; i < W; i++) {//중복순열
			shoot[cnt]=i;
			permutation(cnt+1);
		}
	}

	private static void shooting(int[][] map) {
		// TODO Auto-generated method stub
		int cnt=0;
		for (int i = 0; i < N; i++) {
			int start=-1;
			for (int j = 0; j < H; j++) {
				
				if(map[j][shoot[i]]!=0) {
					start = j;
					break;
				}
			}
			
			if(start == -1) continue;
			
			cnt += bfs(map,start,shoot[i]);
			down(map);
		}
		
		res = res > block-cnt ? block-cnt : res;
		
	}
	
    private static void down(int[][] map) {
        
        for (int c = 0; c < W; c++) {
            
            int r = H - 1;
            while(r > 0) {
                // 빈 공간이라면
                if(map[r][c] == 0) {
                    // 직전 행부터 탐색
                    int nr = r - 1;
                    // 처음 만나는 벽돌 찾기
                    while(nr > 0 && map[nr][c] == 0) nr--;
                    
                    map[r][c] = map[nr][c];
                    map[nr][c] = 0;
                }
                
                r--;
            }
        }
        
    }
	
	private static int bfs(int map[][],int r, int c) {
		int cnt = 0;
        Queue<Node> q = new LinkedList<>();
        // 벽돌의 숫자가 1보다 크면 queue에 추가
        if(map[r][c] > 1) q.add(new Node(r, c, map[r][c]));
        // 벽돌이 깨지면 0
        map[r][c] = 0;
        cnt++;
        
        while(!q.isEmpty()) {
            
            Node now = q.poll();
                        
            for (int d = 0; d < 4; d++) {
                int nr = now.r;
                int nc = now.c;
                for (int k = 0; k < now.cnt - 1; k++) {
                    nr += dr[d];
                    nc += dc[d];
                    if(nr < 0 || nr >= H || nc < 0 || nc >= W || map[nr][nc] == 0) continue;
                    if(map[nr][nc] > 1) q.add(new Node(nr, nc, map[nr][nc]));
                    
                    map[nr][nc] = 0;
                    cnt++;
                }
            }
        }
        
        return cnt;
	}

	static class Node {
        int r, c, cnt;
 
        public Node(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
        
    }


}
