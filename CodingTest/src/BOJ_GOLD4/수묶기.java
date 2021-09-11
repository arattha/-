package BOJ_GOLD4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class 수묶기 {
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int arr[] = new int[N];
        
        PriorityQueue<Integer> plus = new PriorityQueue<Integer>();
        PriorityQueue<Integer> minus = new PriorityQueue<Integer>();
        
        int result = 0;
        int one = 0;
        int zero = 0;
        for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(br.readLine());
			if(temp > 1) plus.add(temp);
			else if(temp == 1) one++;//1은 더하는게 제일
			else if(temp == 0) zero++;//0은 음수에 필요하면 넣어서 0으로 만들고 아니면 더하기
			else minus.add(temp);
		}
        
        if(plus.size()%2 == 1) {
        	plus.add(1);//짝수 맞추기
        }
        if(minus.size()%2 == 1) {
        	if(zero == 0)
        		minus.add(1);//짝수 맞추기
        	else minus.add(0);
        }
        while(!plus.isEmpty()) {
        	result += plus.poll() * plus.poll();
        }
        while(!minus.isEmpty()) {
        	result += minus.poll() * minus.poll();
        }
        
        result += one;
        
        System.out.println(result);
	}

}
