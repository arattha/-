package D4;

import java.util.HashMap;
import java.util.Scanner;

public class 구간합 {
	
	
	static int temp[] = {0,1,3,6,10,15,21,28,36,45};
	static HashMap<Long, Long> m = new HashMap<>();

    
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		long idx = 9;
	    long f9 = 45;
	    long multi = 1;
	    long len = 1;
	    while(idx < 1000000000000000L){
	        m.put(idx, multi * f9);
	        idx = 10*idx + 9;
	        multi = multi*10 + pow10(len++);
	    }
		
		
		for (int tc = 1; tc <= T; tc++) {
			
			long start = sc.nextLong();
			long end = sc.nextLong();
			
			//System.out.println("#"+tc+" "+(func(end)-func(start-1)));
			System.out.println("#"+tc+" "+(f(end)-f(start-1)));
		}
		
	}
	
	public static long e(long n) {
		return n*(n+1)/2;
	}
	
	public static long g(long n){
       if(n<=9){
          return e(n);
       }else{
          long v=pow10(len(n));
          return (n/v)*(n%v+1L)+ f(n%v);
       }
    }
	
    public static long f(long n) {
       if(m.containsKey(n)) {
          return m.get(n);
       }else if(n<=9){
          return e(n);
       }else{
          long v=pow10(len(n));
          m.put(n, f(n-1L-n%v)+g(n));
          return m.get(n);
       } 
    }
    
	private static long pow10(long len) {
		// TODO Auto-generated method stub
		return (long) Math.pow(10, len);
	}

	private static long len(long n) {
		// TODO Auto-generated method stub
		return Long.toString(n).length()-1;
	}

//	public static int func(int n) {
//		if(n<10) {
//			return n*(n+1)/2;
//		}
//		
//		char str[] = Integer.toString(n).toCharArray();
//		
//		int temp = 0;
//		
//		for (int i = 0; i < str.length-1; i++) {
//			temp += (str[i]-'0') * (n%10+1);
//		}
//		
//		//return func(n-1-(n%10)) + (n/10) * (n%10+1) + func(n % 10);
//		return func(n-1-(n%10)) + temp + func(n % 10);
//	}
	
}
