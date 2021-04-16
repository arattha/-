package BaekJoon;


import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class 빵집 {
	static int R,C;
	static char map[][];
	static int ans;
	static boolean temp;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		R=sc.nextInt();
		C=sc.nextInt();
		
		map=new char[R+2][C+2]; 
		
		for (int i = 1; i <= R; i++) {
			char temp[]=sc.next().toCharArray();
			for (int j = 1; j <= C; j++) {
				map[i][j]=temp[j-1];
			}
		}
		for (int i = 1; i <=R; i++) {
			setPipe(i,1);
		}
		System.out.println(ans);
	}
	
	public static boolean setPipe(int rowNo,int colNo) {	
		if(!isAvailable(rowNo,colNo)) {
			return false;
		}
		map[rowNo][colNo]='-';
		if(colNo==C) {
			ans++;
			return true;
		}
		for (int i = rowNo-1; i <= rowNo+1 ; i++) {
			if(setPipe(i,colNo+1)) return true;
		}
		return false;		
	}	
	private static boolean isAvailable(int rowNo,int colNo) {//이미 파이프가 있거나, 건물이 있다.
		// TODO Auto-generated method stub
		if(map[rowNo][colNo]=='.')
			return true;
		return false;
	}
}
