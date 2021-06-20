package BOJ_GOLD5;

import java.util.Arrays;
import java.util.Scanner;

public class AC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		
		loop : for (int tc = 1; tc <= T; tc++) {
			String order = sc.next();
			int size = sc.nextInt();
			String str = sc.next();
			
			String num[] = str.substring(1,str.length() - 1).split(",");
			int arr[] = new int[size];
			for (int i = 0; i < size; i++) {
				arr[i] = Integer.parseInt(num[i]);
			}
			
			int frontIdx = 0;
			int backIdx = size - 1;
			
			int dir = 1;
			
			for (int i = 0; i < order.length(); i++) {
				if(order.charAt(i) == 'R') {
					dir *= -1;
				} else {
					if(dir == 1) {
						frontIdx++;
						size--;
					} else {
						backIdx--;
						size--;
					}
					if(size < 0) {
						sb.append("error").append("\n");
						continue loop;
					}
				}
			}
			sb.append("[");
			if(dir == 1) {
				
				for (int i = frontIdx; i <= backIdx; i++) {
					sb.append(arr[i]);
					if(i != backIdx) {
						sb.append(",");
					}
				}
				
			} else {
				for (int i = backIdx; i >= frontIdx; i--) {
					sb.append(arr[i]);
					if(i != frontIdx) {
						sb.append(",");
					}
				}
			}
			sb.append("]").append("\n");
			
		}
		System.out.print(sb);
	}

}
