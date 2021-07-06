package BOJ_GOLD5;

import java.util.Arrays;
import java.util.Scanner;

public class 미세먼지안녕_17144 {
	
	static int R,C,T;
	static int map[][];
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static int airClean[][];
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		T = sc.nextInt();
		map = new int[R][C];
		airClean = new int[2][2];
		airClean[0][0] = -1;
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = sc.nextInt();
				if(airClean[0][0] == -1 && map[i][j] == -1) {
					airClean[0][0] = i;
					airClean[0][1] = j;
					airClean[1][0] = i+1;
					airClean[1][1] = j;
				}
			}
		}
		
		for (int i = 0; i < T; i++) {
			go();
			//for (int j = 0; j < R; j++) {
			//	System.out.println(Arrays.toString(map[j]));
			//};
		}
		int res = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] != -1)
					res += map[i][j];
			}
		}
		System.out.println(res);
	}
	private static void go() {
		// TODO Auto-generated method stub
		
		int temp[][] = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] != 0) {
					int cnt = 0;
					for (int k = 0; k < dr.length; k++) {
						int nr = i + dr[k];
						int nc = j + dc[k];
						if(check(nr,nc)) {
							cnt++;
							temp[nr][nc] += map[i][j]/5;
						}
					}
					temp[i][j] += (map[i][j] - (map[i][j]/5) * cnt);
				}
			}
		}
		map = temp;
		clean();
	}
	private static void clean() {
		for (int i = 0; i < 2; i++) {
			int nr = airClean[i][0];
			int nc = airClean[i][1];
			//System.out.println("idx : "  + i);
			//상하로 끝까지
            if (i == 0) {
                while (nr > 0) {
                	if(map[nr][nc] != -1) {
	                    map[nr][nc] = map[nr - 1][nc];
                	}
                	//System.out.println("nr : " + nr + " nc : " + nc);
                	nr--;
                }
            } else {
                while (nr < R - 1) {
                	if(map[nr][nc] != -1) {
                		map[nr][nc] = map[nr + 1][nc];
                	}
                	//System.out.println("nr : " + nr + " nc : " + nc);
                	nr++;
                }
            }
            //<-
            while (nc < C - 1) {
                map[nr][nc] = map[nr][nc + 1];
                //System.out.println("nr : " + nr + " nc : " + nc);
                nc++;
            }
            
            //공기청정기 반대
            if (i == 0) {
                while (nr < airClean[i][0]) {
                    map[nr][nc] = map[nr + 1][nc];
                    //System.out.println("nr : " + nr + " nc : " + nc);
                    nr++;
                }
            } else {
            	while (nr > airClean[i][0]) {
                    map[nr][nc] = map[nr - 1][nc];
                    //System.out.println("nr : " + nr + " nc : " + nc);
                    nr--;
                }
            }
            
            while (nc > 0) {
            	if(map[nr][nc] != -1) {
            		map[nr][nc] = map[nr][nc - 1];
            	}
            	//System.out.println("nr : " + nr + " nc : " + nc);
            	nc--;
            }
            map[airClean[i][0]][airClean[i][1] + 1] = 0;
            
		}
	}
	private static boolean check(int y, int x) {
		// TODO Auto-generated method stub
		if(y < 0 || x < 0 || y >= R || x >= C) return false;
		if(map[y][x] == -1) return false;
		return true;
	}
	
}
