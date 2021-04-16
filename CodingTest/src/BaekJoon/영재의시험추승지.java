package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 영재의시험추승지 {
	
	static int N;
	static int sum;
	static int[] arr;
	static int[] save;
	
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    N = 10;
	    arr = new int[N];
	    save = new int[N];
	    for (int i = 0; i < N; i++) {
	        arr[i] = Integer.parseInt(st.nextToken());
	    }

	    for (int pre = 1; pre <= 5; pre++) {
	        save[0] = pre;
	        if (arr[0] == pre)
	            permutation(pre, 1, 0, 1);
	        else
	            permutation(pre, 1, 0, 0);
	    }
	    System.out.print(sum);
	}

	// 중복 순열
	static void permutation(int pre, int cnt, int dupl, int score) {
	    if (dupl >= 3)
	        return;
	    if (cnt == N) {
	            if (score >= 5) 
	                sum++;
	            return;
	        }

	    for (int i = 1; i <= 5; i++) {
	        save[cnt] = i;
	        if(arr[cnt] == save[cnt]) //정답이랑 찍은거랑 맞으면 
	            score++;
	        if (pre == i)    //전꺼랑 똑같은거 고르면
	            permutation(i, cnt + 1, dupl + 1,score);
	        else
	            permutation(i, cnt + 1, 1, score);
	    }
	}
}

