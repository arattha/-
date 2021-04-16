package Studies;

import java.util.Arrays;
import java.util.Scanner;

public class 김태헌식당예제 {

    static char arr[][] ;

    static String word;
    static int[] dr = {-1,0,1};
    static int[] dc = {1,1,1};
    static int R ;
    static int C ; 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R  = sc.nextInt();
        C  = sc.nextInt();
        arr = new char[R][C];

        for(int i =0; i<R; i++) {
        	word = sc.next();
            for(int j=0; j<C; j++) {
                arr[i][j] = word.charAt(j);
            }
        }

        for(int i =0; i<R; i++) {
                dfs(i,0);
        }
        
        System.out.println(cnt);
        
        for (int i = 0; i < R; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
    }
    static int cnt;
    public static void dfs(int r, int c) {
        arr[r][c] = 'x';
	    for(int i =0; i<3; i++) {
	        int nr = r+dr[i];
	        int nc = c+dr[i];
	        if(nr < 0 || nc < 0 || nr >= R || nc >= C )
	            continue;
	        if(arr[nr][nc] == 'x')
	            continue;
	        if( nc == C-1) {
	            cnt++;
	            return;
	        }
	        dfs(nr,nc);
	    }
	    
	}
}