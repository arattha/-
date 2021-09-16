package 삼성기출;

import java.util.Arrays;
import java.util.Scanner;

public class 주사위윷놀이 {

	static Node root;
	static int dice[] = new int[10];
	static int horse[] = new int[10];
	static int result;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		result = 0;
		init();
		
		for (int i = 0; i < 10; i++) {
			dice[i] = sc.nextInt();
		}
		
		permutation(0);
		System.out.println(result);
	}
	
	public static void permutation(int cnt) {
		
		if(cnt == 10) {
			go();
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			horse[cnt] = i;
			permutation(cnt + 1);
		}
		
	}
	
	private static void go() {
		// TODO Auto-generated method stub
		int score = 0;
		Node pos[] = new Node[4];
		
		for (int i = 0; i < 4; i++) {//모든말 시작점
			pos[i] = root;
		}
		
		for (int i = 0; i < 10; i++) {
			int d = dice[i];
			int h = horse[i];
			pos[h].horse = false;//나 있던 자리 비우고 감.
			
			for (int j = 0; j < d; j++) {
				if(pos[h].finish) {// 주사위만큼 감
					break;
				}
				if(j==0 && pos[h].blue != null) {//파란색 칸이었다면
					pos[h] = pos[h].blue;
				} else {
					pos[h] = pos[h].next;
				}
			}
			
			if(pos[h].horse && !pos[h].finish) {//도착한 자리에 누가 있음 망함
				
				for (int k = 0; k < 4; k++) {
					pos[k].horse = false;
				}
				
				return;
			}
			
			pos[h].horse = true;
			score += pos[h].value;
		}
		
		result = Math.max(result, score);
		for (int k = 0; k < 4; k++) {
			pos[k].horse = false;
		}
		return;
		
	}
	
	
	static class Node{
		
		int value;
		Node next;
		Node blue;
		boolean horse; 
		boolean finish;
		
		public Node(int value) {
			super();
			this.value = value;
		}

		public Node addNext(int value) {
			Node nextNode = new Node(value);
			this.next = nextNode;
			return nextNode;
		}
		
		public Node getNode(int value) {
			Node temp = root;
			while(true) {
				if(temp.next == null) return null;
				if(temp.value == value) return temp;
				temp = temp.next;
			}
		}

		@Override
		public String toString() {
			return "Node [value=" + value + ", next=" + next + ", blue=" + blue + ", horse=" + horse + ", finish="
					+ finish + "]";
		}

		
		
	}
	
	private static void init() {
		// TODO Auto-generated method stub
		root = new Node(0);
		
		Node t = root;
		for (int i = 2; i <= 40; i+=2) {
			t = t.addNext(i);
		}
		
		Node end = t.addNext(0);
		end.finish = true;
		
		Node cross = new Node(25);
		
		Node b1 = new Node(13);
		Node temp = root.getNode(10);
		temp.blue = b1;
		b1 = b1.addNext(16);
		b1 = b1.addNext(19);
		b1.next = cross;
		
		Node b2 = new Node(22);
		temp = root.getNode(20);
		temp.blue = b2;
		b2 = b2.addNext(24);
		b2.next = cross;
		
		Node b3 = new Node(28);
		temp = root.getNode(30);
		temp.blue = b3;
		b3 = b3.addNext(27);
		b3 = b3.addNext(26);
		b3.next = cross;
		
		Node c = cross.addNext(30);
		c = c.addNext(35);
		c.next = root.getNode(40);
		
	}

}
