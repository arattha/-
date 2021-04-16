package BaekJoonIM대비;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 직사각형네개의합집합의면적구하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int arr[][]=new int[101][101];
		
		for (int r = 0; r < 4; r++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			
			for (int i = y1; i < y2; i++) {
				for (int j = x1; j < x2; j++) {
					arr[i][j]=1;
				}
			}
		}
		int res=0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if(arr[i][j]==1)
					res++;
			}
		}
		List<Integer> test = new ArrayList<Integer>();
		
		System.out.println(res);
	}

}
