package BaekJoon;

import java.io.*;
import java.util.*;

public class 나무재테크 {
	
	static int N,M,K;
	static int year;
	static int A[][];
	static int nutriment[][];
	static PriorityQueue<Tree> trees = new PriorityQueue<>();
	
	static int dr[] = {-1,-1,-1,0,1,1,1,0};//8방
	static int dc[] = {-1,0,1,1,1,0,-1,-1};
	
	static class Tree implements Comparable<Tree>{
		int y,x,age;
		
		public Tree(int y, int x, int year) {
			this.y = y;
			this.x = x;
			this.age = year;
		}
		@Override
		public int compareTo(Tree o) {
			return Integer.compare(this.age, o.age);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		year = 0;
		A = new int[N][N];
		nutriment = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			Arrays.fill(nutriment[i], 5);
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			trees.offer(new Tree(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken()))); //나무들 저장
		}
		while (year++ < K) {
			Queue<Tree> alive = new LinkedList<>(); //생존한 나무
			ArrayList<Tree> dead = new ArrayList<>(); //이번 년도 죽은 나무 저장할 배열
			while (!trees.isEmpty()) {
				//봄
				Tree t = trees.poll(); //나무 하나 꺼내서
				if(t.age <= nutriment[t.y][t.x]) {//양분이 충분한지 확인
					nutriment[t.y][t.x]-=t.age;//먹고
					alive.add(new Tree(t.y,t.x,t.age+1));//나이증가
				}
				else {//아니라면 죽어
					dead.add(t);
				}
			}
			for (int i = 0; i < dead.size(); i++) {	//여름
				Tree t = dead.get(i);
				nutriment[t.y][t.x] += t.age/2;
			}
			while(!alive.isEmpty()) {//가을
				Tree t = alive.poll();
				if(t.age%5 == 0) {
					for (int i = 0; i < dr.length; i++) {
						int nr = t.y + dr[i];
						int nc = t.x + dc[i];
						if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
						trees.offer(new Tree(nr,nc,1));//새끼치고
					}
				}
				trees.offer(t);//나도 들어가고
			}
			for (int i = 0; i < N; i++) {//겨울
				for (int j = 0; j < N; j++) {
					nutriment[i][j]+=A[i][j];
				}
			}
			
		}
		System.out.println(trees.size());
	}
}
