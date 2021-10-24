package LineCodingTest;

import java.util.Arrays;

public class 달팽이 {
	
	//static int[] order = {2,3,3};
	static int[] order = {3,3};
	static int[][] map;
	static int num;
	static int size;
	
	static int sizeArr[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		size = 1;
		sizeArr = new int[order.length];
		for (int i = 0; i < order.length; i++) {
			sizeArr[i] = size;//gap 구해두기
			size *= order[i];
		}
		num = 1;
		map = new int[size][size];
		
		recur(order.length,0,0);
		
		for (int i = 0; i < map.length; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}

	public static void recur(int cnt, int sy, int sx) {
		if(cnt == 0) {
			map[sy][sx] = num++;
			return;
		}
		
		int deg = order[cnt - 1];//내 차수, 그려야하는 달팽이 크기
		int s = sizeArr[cnt-1];//gap은 현재 내 deg 이전 모든 수를 곱한 것, 맨 처음 것은 1
		int nr = sy;
		int nc = sx - s;//시작 좌표, 더하면서 시작해서 얘는 한칸 뒤에서
		
		while(true) {//달팽이 그리면서 재귀
			for(int i = 0; i < deg; i++) {
				
				nc += s;//gap
				recur(cnt - 1,nr,nc);
			}
			deg--;//내 차수만큼 다그렸으면 끄기
			if(deg == 0)
				break;
			
			for(int i = 0; i < deg; i++) {
				nr += s;
				recur(cnt - 1,nr,nc);
			}
			
			s *= -1;//방향 변경
			
		}
	}
	
	
}
