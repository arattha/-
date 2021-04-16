package BaekJoon;

import java.util.Scanner;

public class 칸토어집합 {
	
	static char arr[];
	static int N,len;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNextInt()) {
			N = sc.nextInt();
			len = (int) Math.pow(3, N);
			arr = new char[len];
			
			cantorSet(0,len,true,1);
			
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < len; i++) {
				sb.append(arr[i]);
			}
			sb.append("\n");
			
			System.out.print(sb);
		}
		
		
	}
	
	public static void cantorSet(int left, int right, boolean bool, int cnt) {
		
		if(bool == true && right-left==1) {
			arr[left]='-';
			return;
		}
		
		if(bool == false) {
			for (int i = left; i < right; i++) {
				arr[i]=' ';
			}
			return;
		}
		else {
			int tempL=len;
			for (int i = 0; i < cnt; i++) {
				tempL /=3;
			} 
			cantorSet(left,tempL+left,true,cnt+1);
			cantorSet(tempL+left,tempL*2+left,false,cnt+1);
			cantorSet(tempL*2+left,right,true,cnt+1);
		}
		
	}
	
}
