package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 키순서_pro {
	
	static int N,M;
	static ArrayList<Integer> edgeList[];
	static int res[][];
	static boolean visited[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			
			res = new int[N+1][2];
			visited = new boolean[N+1][N+1];
			edgeList = new ArrayList[N+1];
			
			for (int i = 0; i <= N; i++) {
				edgeList[i]=new ArrayList<Integer>();
			}
			StringTokenizer st = null;
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				edgeList[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
			}
			
			
			for (int i = 1; i <= N; i++) {
				res[i][1]=edgeList[i].size();//내가 나가는 횟수 저장.
				dfs(i,i);//나로 시작
			}
			for (int i = 1; i <= N; i++) {
				System.out.println(Arrays.toString(res[i]));
			}
			
			int result=0;
			for (int i = 0; i < N; i++) {
				if(res[i][0]+res[i][1]==N-1)
					result++;
			}
			System.out.println("#"+tc+" "+result);
		}
		
	}
	
	public static void dfs(int idx,int start) {
		
		for (int i = 0; i < edgeList[start].size(); i++) {
			if(!visited[idx][edgeList[start].get(i)]) {//안갔으면
				
				visited[idx][edgeList[start].get(i)]=true;
				
				res[edgeList[start].get(i)][0]++;//내가 가는애꺼 늘리고
				dfs(idx,edgeList[start].get(i));
			}
		}
	}
	
}
