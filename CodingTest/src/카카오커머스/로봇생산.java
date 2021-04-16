package 카카오커머스;

import java.util.Arrays;

public class 로봇생산 {

	
	
	static int[][] needs = { { 1, 0, 0 }, {1, 1, 0}, {1, 1, 0}, {1, 0, 1}, {1, 1, 0}, {0, 1, 1} };
	
	static int R = 2;
	static int L,N,res;
	static int test[];
	public static void main(String[] args) {
		test= new int[needs[0].length];
		L=needs.length;
		N=needs[0].length;
		res=0;
		
		combination(0, 0);
		
		System.out.println(res);
	}
	
	
	static void combination(int cnt, int start) {
		if(R==cnt) {
			int countR=0;
			boolean check=true;
			for (int i = 0; i < L; i++) {
				check=true;
				for (int j = 0; j < N; j++) {
					if(needs[i][j]==0)continue;//필요없는 부품은 체크안함
					if(test[j] != needs[i][j]){//필요있는 부품인데, 없어
						check=false;
					}
				}
				if(check)
					countR++;
			}
			
			if(res<cnt) {
				res=countR;
			}
			
		}
		
		
		for (int i = start; i < N; i++) {
			if(test[i]==1) continue;
			test[i]=1;
			combination(cnt+1, i+1);
			test[i]=0;
		}
		
	}
	
	/*
	 * 
	 * 
	 * 
	 * 
	 *  1 0 1
	 * [1 0 0]  ->
	 * [1 1 0]  ->
	 * [1 1 0]  ->
	 * [1 0 1]  ->
	 * [1 1 0]  ->
	 * [0 1 1]  ->
	 * 
	 * 
	 * 
	 * 만들수 있는거 6개
	 * 0 0
	 * 1 0 1
	 * 2 0 1
	 * 3 0 2
	 * 4 0 2
	 * 5 0 1
	 * 6 1 2
	 * 
	 * 
	 * 
	 * 6 4
	 * */
	
}
