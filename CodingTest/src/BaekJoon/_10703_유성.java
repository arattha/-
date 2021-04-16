package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10703_유성 {
    static int R, S;
    static char[][] map, result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        
        map = new char[R][S];
        result = new char[R][S];
        for(int i=0;i<R;i++) {
            String s = br.readLine();
            map[i] = s.toCharArray();
            result[i] = s.toCharArray();
        }
        
        for(int i=0;i<R;i++) {
            for(int j=0;j<S;j++) {
                if(result[i][j]=='X')
                    result[i][j]='.';
            }
        }
        
        int m_index=-1;
        int l_index=0;
        int gap = Integer.MAX_VALUE;
        for(int i=0;i<S;i++) {
        	m_index=-1;
            for(int j=0;j<R;j++) {
                if(map[j][i]=='X') 
                    m_index=j;
            }
            for(int j=R-1;j>=0;j--) {
                if(map[j][i]=='#') 
                    l_index=j;
            }
            if(m_index != -1 && gap>l_index-m_index-1) 
                gap = l_index-m_index-1;
        }
        for(int i=0;i<R;i++) {
            for(int j=0;j<S;j++) {
                if(map[i][j]=='X') {
                    result[i+gap][j] = 'X';
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<R;i++) {
            for(int j=0;j<S;j++) {
                sb.append(result[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
