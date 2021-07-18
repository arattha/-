package BOJ_GOLD5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 숫자고르기_2668 {
	
	static ArrayList<Integer> list;
	static boolean[] visited;
	static int[] arr;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		arr = new int[n + 1];
		
		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
		}
		list = new ArrayList<>();
        visited = new boolean[n + 1];
        for(int i = 1; i <= n; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }
        
        Collections.sort(list);
        System.out.println(list.size());
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }    
    
    public static void dfs(int start, int target) {
        if(visited[arr[start]] == false) {
            visited[arr[start]] = true;
            dfs(arr[start], target);
            visited[arr[start]] = false;
        }
        if(arr[start] == target) list.add(target); 
    }

		
}


