package BaekJoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 캐슬디펜스Hong {
	
	//적군의 배열을 만들어서, 적군의 위치정보를 배열에 모아서 관리하면 조금 더 쉬움.
	static int N, M, D;
	
	static class Enemy{
		int r,c;
		Enemy(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	
	static List<Enemy> list;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		D = sc.nextInt();
		
		list = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++)
			{
				if(sc.nextInt() == 1)
					list.add(new Enemy(i, j));
			}
		}
		
		int ans = 0;
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < M; j++) {
				for(int k = 0; k < M; k++) {
					List<Enemy> list2 = new ArrayList<>();
					for(Enemy e: list) {
						list2.add(new Enemy(e.r, e.c)); 
					} 
					int cnt = game(list2, new int[] {i,j,k});
					
					ans = Math.max(cnt, ans);
				}
			}
		}
		System.out.println(ans);
	}
	
	
	static int game(List<Enemy> list, int[] pos) {
		int cnt = 0;
		//적군이 다 죽을떄까지
		while(list.size() != 0)
		{
			List<Enemy> tmp = new ArrayList<>();
			//각 궁수별로
			for(int p : pos) {
				//	자신과 가장 가까운 적군을 찾는다.
				int target = findNear(list, p);
				//	찾은 적군을 임시 리스트에 담아놓는다.
				if( target != -1 ) {
					tmp.add(list.get(target));
				}
				
			}
			//임시 배열을 돌면서
			for(Enemy e : tmp) {
				//	임시배열에 포함된 적군을 적군리스트에서 지운다.
				if( list.remove(e) )
					cnt++;
			}
			
			//적군 한칸씩 내려온다.
			//밖으로 나간 적군은 죽는다.
			for(int i = 0; i < list.size(); i++) {
				Enemy e = list.get(i);
				e.r++;
				if(e.r == N) {
					list.remove(i);
					i--;
				}
			}
		}
		return cnt;
	}
	//p열에 위치한 궁수로부터 가장 가까운 적군을 찾는다.
	static int findNear(List<Enemy> list, int p) {
		int dist = 987654321; //가장 가까운 적군의 나와의 거리
		int minW = 987654321; //가장 가까운 적군의 열 위치
		int res = -1; //찾아낸 적군의 인덱스
		for(int i = 0; i < list.size(); i++) {
			Enemy e = list.get(i);
			int d = N - e.r + Math.abs(p - e.c);
			//사정거리 밖이면 패스
			if( d > D)
				continue;
			//알려진 최소거리 보다 작다면
			if( d < dist ) {
				dist = d;
				minW = e.c;
				res = i;
			}
			//알고 있던 최소값과 같은 적군이 나왔으면
			else if( d == dist ) {
				if( minW > e.c ) {
					minW = e.c;
					res = i;
				}
			}
		}
		return res;
	}
}
