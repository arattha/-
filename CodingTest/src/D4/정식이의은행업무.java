package D4;

import java.util.Scanner;

public class 정식이의은행업무 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		
		for (int tc = 1; tc <= T; tc++) {
			
			char two[] = sc.next().toCharArray();
			char three[] = sc.next().toCharArray();
			
			loop: for (int i = 0; i < two.length; i++) {
				for (int j = 0; j < three.length; j++) {
					
					for (int p = 0; p < 2; p++) {
						char ttwo[] = two.clone();
						char temp2= (char) ( p + '0' );
						
						ttwo[i] = temp2;
						
						for (int q = 0; q < 3; q++) {
							char[] tthree = three.clone();
							char temp3 = (char) ( q + '0' );
							
							tthree[j] = temp3;
							
							if(Integer.parseInt(String.valueOf(ttwo),2)==Integer.parseInt(String.valueOf(tthree),3)) {
								System.out.println("#"+tc+" "+Integer.parseInt(String.valueOf(ttwo),2));
								break loop;
							}
							
						}
						
					}
					
					
				}
			}
		}
		
	}

}
