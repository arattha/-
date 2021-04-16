package BaekJoonIM대비;

import java.util.Arrays;
import java.util.Scanner;

public class 줄세우기 {
	static int stu[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		stu = new int[N];
		
		for (int i = 1; i <= N; i++) {
			stu[i-1]=i;
		}
		
		for (int i = 0; i < stu.length; i++) {
			int sel= sc.nextInt();
			
			swap(i,sel);
		}
		
		for (int i = 0; i < N; i++) {
			System.out.print(stu[i]+" ");
		}
		
	}

	private static void swap(int i, int sel) {
		// TODO Auto-generated method stub
		int temp=stu[i];
		
		for (int j = i; j > i-sel; j--) {
			stu[j]=stu[j-1];
		}
		stu[i-sel]=temp;
	}
	
}
