package Studies;


import java.util.Arrays;
import java.util.Scanner;

public class 박세영2 {
    static int N, sum;
    static int[] arr;
    static int[][] map;
    static boolean[] isVisited;
    static boolean[] nodeCheck;
    static int ans = Integer.MAX_VALUE;

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    arr = new int[N];
    map = new int[N][N];
    nodeCheck = new boolean[N];
    isVisited = new boolean[N];
    for (int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();
    }

    for (int i = 0; i < N; i++) {
        int n = sc.nextInt();
        for (int j = 0; j < n; j++) {
            int a = sc.nextInt() - 1;
            map[i][a] = 1;
        }
    }
    
    
    powerset(0);
    System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
}

static void powerset(int cnt) {

    if (cnt == N) {
    	
    	nodeCheck = new boolean[N];
    	
        int sum1 = 0;
        int sum2 = 0;

        if (check()) {
            for (int i = 0; i < N; i++) {
                if (isVisited[i]) {
                    sum1 += arr[i];
                }
                if (!isVisited[i]) {
                    sum2 += arr[i];
                }

            }

            int min = Math.abs(sum1 - sum2);
            ans = Math.min(min, ans);
        } 

        return;
    }

    isVisited[cnt] = true;
    powerset(cnt + 1);
    isVisited[cnt] = false;
    powerset(cnt + 1);

}

static boolean check() {
    int v = -1;
    for (int i = 0; i < N; i++) {
        if (isVisited[i]) {
            v = i;
        }

    }
    
    int v2=-1;
    for (int i = 0; i < N; i++) {
        if (!isVisited[i]) {
            v2 = i;
        }

    }

    if(v == -1 || v2== -1) return false;
    
    dfs1(v);
    dfs2(v2);
    for (int i = 0; i < N; i++) {
        if (!nodeCheck[i])
            return false;
    }
    return true;
}

// 정점이 이어져 있는지 확인
static void dfs1(int v) {
    nodeCheck[v] = true;

    for (int i = 0; i < N; i++) {
        if (map[v][i] == 1 && !nodeCheck[i] && isVisited[i]) {
            dfs1(i);

        }
    }

}

static void dfs2(int v) {
    nodeCheck[v] = true;

    for (int i = 0; i < N; i++) {
        if (map[v][i] == 1 && !nodeCheck[i] && !isVisited[i]) {
            dfs2(i);

        }
    }

}
}


