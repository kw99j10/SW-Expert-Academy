package swea.ssafyTask;

import java.util.Scanner;

//최적 경로 - 완전 탐색 dfs
public class swea1247 {
    static int n; //고객의 수
    static int[][] map; //주어진 경로를 나타낼 지도
    static boolean[] visit; //방문을 확인할 배열
    static int min; //최단 경로

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {

            min = Integer.MAX_VALUE;
            n = sc.nextInt();
            map = new int[n + 2][2];
            visit = new boolean[n + 1];

            map[0][0] = sc.nextInt();
            map[0][1] = sc.nextInt(); //시작점

            map[n + 1][0] = sc.nextInt();
            map[n + 1][1] = sc.nextInt(); //도착점

            for (int i = 1; i < n + 1; i++) {
                map[i][0] = sc.nextInt();
                map[i][1] = sc.nextInt();
            }

            //고객을 모두 방문해야 함
            dfs(0, map[0][0], map[0][1], 0);
            System.out.println("#" + test_case + " " + min);
        }
    }

    static void dfs(int count, int current_x, int current_y, int dist) {
        if (count == n) {
            dist += Math.abs(current_x - map[n + 1][0]) + Math.abs(current_y - map[n + 1][1]);

            if (min > dist) {
                min = dist;
            }
            return;
        }
        //완전 탐색
        for (int i = 1; i < n + 1; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(count + 1, map[i][0], map[i][1],
                dist + Math.abs(current_x - map[i][0]) + Math.abs(current_y - map[i][1]));
                visit[i] = false;
            }
        }
    }
}
