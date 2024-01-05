package swea.ssafyTask;

import java.util.Scanner;

//창용 마을 무리의 개수 -> dfs
public class swea7465 {
    static int[][] c;
    static boolean[] visit;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++){
            int n = sc.nextInt();
            int m = sc.nextInt();

            c = new int[n + 1][n + 1];
            visit = new boolean[n + 1];

            int group = 0; //무리의 개수

            for (int i = 0; i < m; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                c[a][b] = 1;
                c[b][a] = 1;
            }

            for (int i = 1; i < c.length; i++) {
                if (!visit[i]){
                    dfs(i);
                    group += 1;
                }
            }
            System.out.println("#" + test_case + " " + group);
        }
    }
    static void dfs(int v) {
        visit[v] = true;
        for (int i = 1; i < c.length; i++) {
            if (c[v][i] == 1 && !visit[i]) {
                dfs(i);
            }
        }
    }
}
