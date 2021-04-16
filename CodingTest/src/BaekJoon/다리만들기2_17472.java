package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class 다리만들기2_17472 {
	static int N, M;
	static int map[][];
	static int adjMatrix[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map=new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st=new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int cnt=2;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]==1) {
					map[i][j]=cnt;
					islandSearch(i,j,cnt);//섬에 2번부터 번호 붙이기.
					cnt++;
				}
			}
		}
		int[] minEdge = new int[cnt];
		boolean[] visited=new boolean[cnt];
		adjMatrix = new int[cnt][cnt];//인접행렬 선언
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]!=0) {
					roadSearch(i,j,map[i][j]);//섬에서 다른섬 가는 최단경로 체크하기
				}
			}
		}
		
		//prim 시작
		Arrays.fill(minEdge,Integer.MAX_VALUE);
		minEdge[2]=0;
		for (int t = 2; t < cnt; t++) {
			int min = Integer.MAX_VALUE;
			int minVertex=2;
			for (int i = 2; i < cnt; i++) {
				if(!visited[i] && min>minEdge[i]) {
					min = minEdge[i];
					minVertex = i;
				}
			}
			visited[minVertex] = true;
			
			for (int i = 2; i < cnt; i++) {//선택된 애 기준으로 최솟값 업데이트
				if(!visited[i] && adjMatrix[minVertex][i] != 0 && minEdge[i]> adjMatrix[minVertex][i]) {
					minEdge[i] = adjMatrix[minVertex][i];
				}
			}
		}
		int result=0;
		for (int i = 2; i < cnt; i++) {
			if(minEdge[i]==Integer.MAX_VALUE) {
				result=-1;
				break;
			}
			else
				result+=minEdge[i];
		}
		
		System.out.println(result);
	}
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	
	private static void roadSearch(int y, int x,int start) {
		// TODO Auto-generated method stub		
		for (int i = 0; i < dc.length; i++) {
			int tmpY=y+dr[i];
			int tmpX=x+dc[i];
			if(tmpY <0 || tmpX<0 || tmpY>=N || tmpX>=M) continue;
			if(map[tmpY][tmpX]==0) {
				int length=0;
				while(true) {
					if(tmpY <0 || tmpX<0 || tmpY>=N || tmpX>=M) break;
					if(map[tmpY][tmpX]==start) break;//나 자신을 만나도 안됨
					if(map[tmpY][tmpX]!=0 && map[tmpY][tmpX]!=start) {//나도 아니고 물도 아닌 다른 섬을 만나면,
						if(length==1) {//겨우 한칸 간것, 다리 못놓는다.
							break;
						}
						else {//다리 놓을 수 있다.
							if(adjMatrix[start][map[tmpY][tmpX]]==0)
								adjMatrix[start][map[tmpY][tmpX]]=length;
							else if(adjMatrix[start][map[tmpY][tmpX]]>length)//이전 크기보다 작은 거리가 존재하면,
								adjMatrix[start][map[tmpY][tmpX]]=length;
							break;
						}
					}
					length++;
					tmpY+=dr[i];
					tmpX+=dc[i];
				}
			}
		}
	}
	private static void islandSearch(int y, int x,int cnt) {
		// TODO Auto-generated method stub
		for (int i = 0; i < dc.length; i++) {
			int tmpY=y+dr[i];
			int tmpX=x+dc[i];
			if(tmpY <0 || tmpX<0 || tmpY>=N || tmpX>=M) continue;
			if(map[tmpY][tmpX]==1) {
				map[tmpY][tmpX]=cnt;
				islandSearch(tmpY, tmpX, cnt);
			}
		}
	}
}
