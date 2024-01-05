package swea.ssafyTask;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

//보급로 - bfs + 부분 dp
public class swea1249 {
    static int[][] map; //주어진 도로의 지도
    static int[][] time; //경로의 복구 시간
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++){

            int n = sc.nextInt();
            map = new int[n][n];
            time = new int[n][n];

            for (int i = 0; i < n; i++) {
                String tmp = sc.next();
                for (int j = 0; j <tmp.length(); j++) {
                    map[i][j] = Integer.parseInt(String.valueOf(tmp.charAt(j)));
                }
                Arrays.fill(time[i], Integer.MAX_VALUE);
            }

            //시작점 초기화
            LinkedList<int[]> queue = new LinkedList<>();
            time[0][0] = 0;
            queue.add(new int[]{0, 0});

            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];

                for (int i = 0; i < 4; i++) {
                    int next_x = x + dx[i];
                    int next_y = y + dy[i];

                    if (next_x >= 0 && next_x < n && next_y >= 0 && next_y < n) {
                        if (time[next_y][next_x] > time[y][x] + map[next_y][next_x]) {
                            time[next_y][next_x] = time[y][x] + map[next_y][next_x];
                            queue.add(new int[]{next_x, next_y});
                        }
                    }
                }
            }
            System.out.println("#" + test_case + " " + time[n - 1][n - 1]);
        }
    }
}
