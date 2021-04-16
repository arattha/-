package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 영재의시험전시영{

    static int[] input = new int[10];
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<10;i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        solve(0,0,0,0);
        System.out.println(ans);
    }
    static void solve(int idx, int pre, int cnt, int score) {
        if(cnt==3) {
            return;
        }
        if(idx==10) {
            if(score>=5) {
                ans++;
            }
            return;
        }

        for(int i=1;i<=5;i++) {
            if(pre==i) 
                cnt++;
            else 
                cnt=1;

            if(i==input[idx])
                score++;

            solve(idx+1,i,cnt,score);
        }
    }
}
