package BaekJoon;

import java.util.Arrays;
import java.util.Scanner;

public class 알파벳찾기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		char[] str = sc.next().toCharArray();
		int[] arr = new int[26];
		
		Arrays.fill(arr, -1);
		// b a ekjoon
		for (int i = 0; i < str.length; i++) {
			if(arr[str[i]-'a']==-1)
				arr[str[i]-'a']=i;	
		}
		System.out.println(Arrays.toString(arr));
	}

}
