package D4;

import java.util.Arrays;
import java.util.Scanner;

public class 보물왕태혁 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			int P = sc.nextInt();
			
			int arr[]= new int[P];
			
			for (int i = 0; i < P; i++) {
				arr[i]=sc.nextInt();
			}
			
			Arrays.sort(arr);
			
			System.out.println("#"+tc+" "+(arr[0]*arr[P-1]));
			
		}
	}

}
