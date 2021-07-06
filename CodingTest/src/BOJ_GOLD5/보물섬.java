 package BOJ_GOLD5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 보물섬 {

	static int height; // 보물섬 지도 높이
	static int width; // 보물섬 지도 너비
	static char[][] map; // 보물섬 지도
	static boolean[][] visited; // 방문 관리

	// 4방 탐색
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int minTime; // 최소 이동 시간

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		map = new char[height][width];
		minTime = 0;

		for (int i = 0; i < height; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {

				if (map[i][j] == 'L') {
					visited = new boolean[height][width];
					int time = bfs(new Pos(i, j, 0));
					minTime = Math.max(minTime, time);
				}
			}
		}

		System.out.println(minTime);
		br.close();
	}

	private static int bfs(Pos pos) {
		int ret = 0;
		Queue<Pos> q = new LinkedList<Pos>();
		q.add(pos);
		visited[pos.row][pos.col] = true;

		while (!q.isEmpty()) {
			Pos p = q.poll();
			for (int d = 0; d < 4; d++) {
				int nextRow = p.row + dy[d];
				int nextCol = p.col + dx[d];

				// 범위 && 방문 && 육지 확인
				if (isIn(nextRow, nextCol) && !visited[nextRow][nextCol] && map[nextRow][nextCol] == 'L') {
					visited[nextRow][nextCol] = true; // 방문 표시
					q.add(new Pos(nextRow, nextCol, p.cnt + 1));
					ret = Math.max(ret, p.cnt + 1);
				}

			}
		}

		return ret;

	}

	// 범위검사
	private static boolean isIn(int row, int col) {
		if (row < 0 || row >= height || col < 0 || col >= width) {
			return false;
		}
		return true;
	}
}

class Pos {
	int row;
	int col;
	int cnt;

	public Pos(int row, int col, int cnt) {
		this.row = row;
		this.col = col;
		this.cnt = cnt;
	}

}