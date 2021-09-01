package BOJ_GOLD4;

import java.util.Scanner;

public class 문자열폭발 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		char[] str = sc.next().toCharArray();
		char[] bomb = sc.next().toCharArray();
		
		char[] res = new char[str.length];
		
		
		int idx = 0;
		int len = bomb.length;
		for (int i = 0; i < str.length; i++) {
			
			res[idx++] = str[i];
			
			if(bomb[len-1] == res[idx-1]) {//현재 문자와 같으면
				
				if(idx < len) continue;
				boolean flag = false;
				for (int j = 0; j < len; j++) {
					if(bomb[len-1-j]!=res[idx-1-j]) {
						flag = true;
						break;
					}
				}
				if(!flag) {//폭발가능하면
					idx -= len;
				}
				
			}
			
		}
		
		if(idx ==0) {
			System.out.println("FRULA");
		}
		else {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < idx; i++) {
				sb.append(res[i]);
			}
			System.out.println(sb);
		}
		
	}

}
