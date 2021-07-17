package BOJ_GOLD5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class puyo_11559 {
	
	private static char[][] map = new char[12][6];
	private static boolean[][] visit = new boolean[12][6];
	
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	
	private static int cnt = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i=0; i<12; i++) {
			String input = reader.readLine();
			char[] c = input.toCharArray();
			for (int j=0; j<6; j++) {
				map[i][j] = c[j];
			}
		}
		
		int result = 0;
		
		while (true) {
			visit = new boolean[12][6];
			
			boolean flag = false;
			
			for (int i=0; i<12; i++) {
				for (int j=0; j<6; j++) {
					if (!visit[i][j] && map[i][j] != '.') {
						cnt = 1;
						
						if (findCnt(i,j, map[i][j])) {
							flag = true;
							bfs(i,j,map[i][j]);
						}
						
					}
				}
			}
			
			if (flag) {
				result++;
			} else {
				break;
			}
			
			//아래로 1칸씩 이동
			while (true) {
				boolean check = false;
				check = gravity(check);
				if (!check) {
					break;
				}
				
			}
			
		}
		
		System.out.println(result);
	}

	private static boolean gravity(boolean check) {
		for (int i=11; i>0; i--) {
			for (int j=5; j>=0; j--) {
				if (map[i][j] == '.' && map[i-1][j] != '.') {
					check = true;
					map[i][j] = map[i-1][j];
					map[i-1][j] = '.';
				}
			}
		}
		return check;
	}

	private static void bfs(int x, int y, char color) {
		
		Queue<Puyo> q = new LinkedList<Puyo>();
		
		q.add(new Puyo(x, y));
		
		while (!q.isEmpty()) {
			Puyo py = q.remove();
			
			int qx = py.x;
			int qy = py.y;
			
			for (int i=0; i<dx.length; i++) {
				int nx = qx + dx[i];
				int ny = qy + dy[i];
				
				if (nx < 0 || ny < 0 || nx >= 12 || ny >= 6 || map[nx][ny] != color) {
					continue;
				}
				
				if (visit[nx][ny] && map[nx][ny] == color) {
					//이전 개수셀 때 방문했고 색상이 같으면 .으로 변경(터뜨리기)
					map[nx][ny] = '.';
					q.add(new Puyo(nx, ny));
				}
			}
			
		}
		
	}

	private static boolean findCnt(int x, int y, char color) {
		
		visit[x][y] = true;
		
		for (int i=0; i<dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx < 0 || ny < 0 || nx >= 12 || ny >= 6 || map[nx][ny] != color) {
				continue;
			}
			
			if (!visit[nx][ny] && map[nx][ny] == color) {
				//인접한 곳중 색상이 같으면 카운트+1
				cnt++;
				findCnt(nx, ny, color);
			}
		}
		
		if (cnt >= 4) {
			return true;
		}
		return false;
		
	}
}


class Puyo {
	int x, y;
	
	public Puyo(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
