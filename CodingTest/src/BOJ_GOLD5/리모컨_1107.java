package BOJ_GOLD5;

import java.util.Scanner;

public class 리모컨_1107 {
	
	static int target;
	static int N;
	static int M;
	static boolean numpad[];
	static int res;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		numpad =  new boolean[10];
		
		//target = 100;
		N = sc.nextInt();
		M = sc.nextInt();
		
		for (int i = 0; i < M; i++) {
			numpad[sc.nextInt()] = true;
		}
		
		res = Math.abs(N-100); //최초 값
		
		for(int i = 0; i <= 999999; i++) {
            String str = String.valueOf(i);
            int len = str.length();
            
            boolean isBreak = false;
            for(int j = 0; j < len; j++) {
                if(numpad[str.charAt(j) - '0']) { 
                    isBreak = true; 
                    break; 
                }
            }
            if(!isBreak) {
                int min = Math.abs(N - i) + len; 
                res = Math.min(min, res);
            }
        }        
        System.out.println(res);
		
	}
	
	
}
