package D4;

import java.util.Arrays;
import java.util.Scanner;

public class 수진이의팰린드롬 {
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			int[] alphabet = new int[26];
			char[] str = sc.next().toCharArray();
			
			for (int i = 0; i < str.length; i++) {
				int a = str[i]-'a';
				alphabet[a]++;
			}
			
			int sum=0;
			
			for (int i = 0; i < 26; i++) {
				if(alphabet[i]==0) continue;
				else sum+= (alphabet[i])*(alphabet[i]+1)/2;
							
			}
			System.out.println("#"+tc+" "+sum);
		}
		
	}

}
