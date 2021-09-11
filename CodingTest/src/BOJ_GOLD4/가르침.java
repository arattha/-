package BOJ_GOLD4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 가르침 {
	
	static boolean[] alpha;
	static char words[][];
	static int N,K;
	static int res;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        
        
        if (K < 5) {
        	System.out.println(0);
			System.exit(0);
		}
        alpha = new boolean[26];
        words = new char[N][];
        res = 0;
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	words[i] = st.nextToken().toCharArray();
		}
        
        alpha['a'-'a'] = true;
        alpha['c'-'a'] = true;
        alpha['i'-'a'] = true;
        alpha['n'-'a'] = true;
        alpha['t'-'a'] = true;//5개는 무조건 필요
        dfs(0,0);
        System.out.println(res);
        
	}

	public static void dfs(int cnt, int start) {
		
		if(cnt == K - 5) {
			int t = 0;
			for (int i = 0; i < N; i++) {
				boolean flag = false;
				for (int j = 4; j < words[i].length - 4; j++) {
					if(!alpha[words[i][j] - 'a']) {
						flag = true;
						break;
					}
				}
				
				if(!flag) {
					t++;
				}
			}
			res = Math.max(res, t);
		}
		
		for (int i = start; i < alpha.length; i++) {
			if(!alpha[i]) {
				alpha[i] = true;
				dfs(cnt+1,i+1);
				alpha[i] = false;
			}
		}
		
	}
	
}
