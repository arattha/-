package D5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 점심식사시간 {
	
	static int stair1,stair2;
	static int N,P;
	
	static ArrayList<Person> people;
	static ArrayList<Stair> stair;
	
	static PriorityQueue<Person>[] group;
	static int map[][];
	static int sel[];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			N = sc.nextInt();
			map = new int[N][N];
			P = 0;
			people = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					if(map[i][j] == 1)
						people.add(new Person(i,j));
					if(map[i][j]>1) {
						stair.add(new Stair(i,j,map[i][j]));
					}
					
				}
			}

			sel = new int[P];
			powerSet(0);
			
		}
		
	}
	
	static class Stair{
		int y;
		int x;
		int time;
		public Stair(int y, int x, int time) {
			this.y = y;
			this.x = x;
			this.time = time;
		}
	}
	
	static class Person implements Comparable<Person> {
		int y;
		int x;
		int stair;
		int time;
		public Person(int y, int x) {
			this.y = y;
			this.x = x;
		}
		@Override
		public int compareTo(Person o) {
			// TODO Auto-generated method stub
			return this.time - o.time;
		}
	}
	
	private static void powerSet(int cnt) {
		if(cnt == people.size()) {
			
			group = new PriorityQueue[2];
			group[0] = new PriorityQueue<Person>();
			group[1] = new PriorityQueue<Person>();
			
			int c = 0;
			for (int i = 0; i < P; i++) {
				group[people.get(i).stair].add(people.get(i)); //계단별로 사람정렬해서 저장
			}
			
			go();
			
			return;
		}
		people.get(cnt).stair=0;//0번
		people.get(cnt).time=Math.abs(people.get(cnt).y-stair.get(0).y) + Math.abs(people.get(cnt).y-stair.get(0).y); 
		powerSet(cnt+1);
		people.get(cnt).stair=1;//0번
		people.get(cnt).time=Math.abs(people.get(cnt).y-stair.get(1).y) + Math.abs(people.get(cnt).y-stair.get(1).y); 
		powerSet(cnt+1);
	}


	private static void go() {
		
		
		
	}
	
}
