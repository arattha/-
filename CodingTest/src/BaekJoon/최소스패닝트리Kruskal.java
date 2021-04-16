package BaekJoon;

import java.util.Arrays;
import java.util.Scanner;

public class 최소스패닝트리Kruskal {
	
	static class Node implements Comparable<Node>{
		int from,to,weight;

		public Node(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
		
	}
	
	static int set[];
	static int V,E;
	static Node nodeList[];
	
	public static void make() {
		for (int i = 0; i < V; i++) {
			set[i]=i;
		}
	}
	
	public static int findSet(int a) {
		if(a==set[a]) return a;
		return set[a]=findSet(set[a]);
		
	}
	
	public static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot==bRoot) return false;
		set[bRoot]=aRoot;
		return true;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		V = sc.nextInt();
		E = sc.nextInt();
		
		set = new int[V];
		nodeList = new Node[E];
		
		for (int i = 0; i < E; i++) {
			nodeList[i]=new Node(sc.nextInt()-1,sc.nextInt()-1,sc.nextInt());
		}
		
		Arrays.sort(nodeList);
		
		make();
		
		long res=0;
		int cnt=0;
		for ( Node n : nodeList ) {
			
			if(union(n.from, n.to)) {
				res += n.weight;
				if(++cnt == V-1) break;
			}
			
		}
		System.out.println(res);
	}
	
}
