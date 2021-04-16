package D5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 무선충전 {
	
	static class Node{
		
		int y,x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	static class Battery implements Comparable<Battery>{
		int id;
		int x,y;
		int range;
		int power;
		public Battery(int id,int x, int y, int range, int power) {
			super();
			this.id = id;
			this.y = y;
			this.x = x;
			this.range = range;
			this.power = power;
		}
		@Override
		public int compareTo(Battery o) {
			// TODO Auto-generated method stub
			return o.power-this.power;
		}
	}
	
	static int[] dr = {0,-1,0,1,0}; //안이동 상 후 하 좌
	static int[] dc = {0,0,1,0,-1};
	
	static int[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			map = new int[11][11];
			int M =  Integer.parseInt(st.nextToken()); //이동 횟수
			int BC = Integer.parseInt(st.nextToken()); //배터리 갯수
			
			Queue<Node> playerA= new LinkedList<>();
			Queue<Node> playerB= new LinkedList<>();
			
			int ay=1;
			int ax=1;
			int by=10;
			int bx=10;
			
			playerA.offer(new Node(ay, ax));
			playerB.offer(new Node(by, bx));
			StringTokenizer stA = new StringTokenizer(br.readLine());
			StringTokenizer stB = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < M; i++) {
				
				int dA=Integer.parseInt(stA.nextToken());//갈방향
				int dB=Integer.parseInt(stB.nextToken());//갈방향
				
				ay+=dr[dA];ax+=dc[dA];
				by+=dr[dB];bx+=dc[dB];
				
				playerA.offer(new Node(ay,ax));
				playerB.offer(new Node(by,bx));
				
			}
			
			Battery[] batteryPack = new Battery[BC];
			
			for (int i = 0; i < BC; i++) {
				st = new StringTokenizer(br.readLine());
				
				batteryPack[i]=new Battery(i,Integer.parseInt(st.nextToken()), 
											Integer.parseInt(st.nextToken()), 
											Integer.parseInt(st.nextToken()), 
											Integer.parseInt(st.nextToken()));
				
			}
			
			int res=0;
			
			while (!playerA.isEmpty()) {
				
				Node NodeA = playerA.poll();
				Node NodeB = playerB.poll();
				
				PriorityQueue<Battery> a = new PriorityQueue<>();
				PriorityQueue<Battery> b = new PriorityQueue<>();
				
				for (int i = 0; i < BC; i++) {
					if(batteryPack[i].range >= Math.abs(batteryPack[i].x-NodeA.x) + Math.abs(batteryPack[i].y-NodeA.y)) {
						//현재 배터리팩에 들어올 수 있으면?
						a.offer(batteryPack[i]);
					}
					
					if(batteryPack[i].range >= Math.abs(batteryPack[i].x-NodeB.x) + Math.abs(batteryPack[i].y-NodeB.y)) {
						//현재 배터리팩에 들어올 수 있으면?
						b.offer(batteryPack[i]);
					}
				}
				
				int total=0;
				int aP=0;
				
				boolean check[]= new boolean[BC];
				
				if (!a.isEmpty() && !b.isEmpty()) {
					for (Battery aBattery : a) {
						total = Math.max(total, aBattery.power);
						aP = aBattery.power;
						check[aBattery.id]=true;
						for(Battery bBattery : b) {
							if(!check[bBattery.id])
								total = Math.max(total, aP + bBattery.power);
						}
						check[aBattery.id]=false;
					}
					res += total;
				} else if(!a.isEmpty() && b.isEmpty()) {
	                res += a.poll().power;
	            } else if(a.isEmpty() && !b.isEmpty()) {
	                res += b.poll().power;
	            }
				
				
			}
			
			System.out.println("#"+tc+" "+res);
		}
		
		
	}

}


//if(chargeA==chargeB) {
//	//같은 배터리 팩을 골랐을때,경우의 수
//	//A가 바꾸던가
//	//B가 바꾸던가
//	//둘다 못바꾸던가.
//	
//	if(cntB == 1 && cntA == 1) {//둘다 못바꿈
//		res+= batteryPack[chargeA].power;
//	} 
//	else {
//		int newA = -1;
//		int newB = -1;
//		for (int i = 0; i < BC; i++) {
//			
//			if(chargeA==i) continue; //지금 고른거 말고
//			
//			if(rA[i]) {//고를 수 있으면
//				if(newA == -1)
//					newA = i;
//				else if(batteryPack[newA].power<batteryPack[i].power)
//					newA = i;
//			}
//			
//			if(rB[i]) {//고를 수 있으면
//				if(newB == -1)
//					newB = i;
//				else if(batteryPack[newB].power<batteryPack[i].power)
//					newB = i;
//			}
//			
//		}
//		
//		if(newA == -1 && newB == -1) {
//			res+= batteryPack[chargeA].power;
//		}
//		else if(newA == -1) {//A가 다른거 못고르는 경우
//			res += batteryPack[newB].power+batteryPack[chargeA].power;
//		}
//		else if(newB == -1) {//B가 다른거 못고르는 경우
//			res+=batteryPack[newA].power+batteryPack[chargeB].power;
//		}
//		else if(batteryPack[newB].power < batteryPack[chargeA].power/2 && batteryPack[newA].power < batteryPack[chargeA].power/2) {
//			//바꿨는데 바꾼애가 현재/2보다 안좋으면
//			res+= batteryPack[chargeA].power;
//		}
//		else {//둘다 변경가능할때
//			if(newA==newB) {//같은애 골랐으면 아무나 바꿔
//				res+=batteryPack[newB].power+batteryPack[chargeA].power;
//			}
//			else if(batteryPack[newB].power < batteryPack[newA].power) {//A가 바꿔
//				res+=batteryPack[newA].power+batteryPack[chargeB].power;;
//			}
//			else if(batteryPack[newB].power > batteryPack[newA].power) {//B가 바꿔
//				res+=batteryPack[newB].power+batteryPack[chargeA].power;;
//			}
//		}
//	}
//	
//}