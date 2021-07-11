package BOJ_GOLD5;

import java.util.Scanner;

public class 트리_1068 {

	static int N;
	static int[] tree;
	static int root;
	static int res;
	static boolean visited[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		tree = new int[N];
		for (int i = 0; i < N; i++) {
			tree[i] = sc.nextInt();
			if(tree[i] == -1) root = i;
		}
		res = 0;
		delete(sc.nextInt());
		visited = new boolean[N];
		leaf(root);
		System.out.println(res);
	}

	private static void leaf(int node) {
		// TODO Auto-generated method stub
		boolean leaf = true;
		visited[node] = true;
		if(tree[node] != -999) {
			for (int i = 0; i < N; i++) {
				if(tree[i] == node && visited[i] == false) {
					leaf(i);
					leaf = false;
				}
			}
			if(leaf) res++;
		}
	}

	private static void delete(int del) {
		// TODO Auto-generated method stub
		tree[del] = -999;
		for (int i = 0; i < N; i++) {
			if(tree[i] == del) {
				delete(i);
			}
		}
	}
	
	

}
