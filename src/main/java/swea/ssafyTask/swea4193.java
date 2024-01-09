package swea.ssafyTask;

import java.util.LinkedList;
import java.util.Scanner;

//수영대회 결승전 - 완전 탐색 - bfs
public class swea4193 {
    static int n; //주어진 바다 범위
    static int[][] sea; //바다 공간
    static boolean[][] visit; //방문을 확인할 배열
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int min; //도착할 수 있는 최소 시간

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            n = sc.nextInt();

            min = Integer.MAX_VALUE;

            sea = new int[n][n];
            visit = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sea[i][j] = sc.nextInt(); //장애물:1, 소용돌이:2(주기 2초)
                }
            }
            int start_x = sc.nextInt();
            int start_y = sc.nextInt(); //시작점

            int goal_x = sc.nextInt();
            int goal_y = sc.nextInt(); //도착점

            if (start_x == goal_x && start_y == goal_y) {
                System.out.println("#" + test_case + " " + 0);
                return; //시작 좌표와 도착 좌표가 같다면 리턴
            }

            bfs(start_x, start_y, goal_x, goal_y); //시작 좌표, 최소 시간

            min = min != Integer.MAX_VALUE ? min : -1; //도착할 수 없으면 -1 출력
            System.out.println("#" + test_case + " " + min);
        }
    }

    static void bfs(int a, int b, int c, int d) {
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{a, b, 0});
        visit[a][b] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll(); //현재 좌표와 이동 거리
            int y = current[0];
            int x = current[1];
            int z = current[2];

            if (x == d && y == c) {
                min = z;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int move_x = x + dx[i];
                int move_y = y + dy[i];

                //주어진 바다 내에서만 이동할 수 있음
                if (move_x >= 0 && move_x < n && move_y >= 0 && move_y < n) {
                    if (!visit[move_y][move_x]) {

                        if (sea[move_y][move_x] == 1) {
                            continue;
                        } else if (sea[move_y][move_x] == 2) {
                            if (z % 3 == 2) {
                                visit[move_y][move_x] = true;
                                queue.add(new int[]{move_y, move_x, z + 1});
                            } else {
                                visit[y][x] = true;
                                queue.add(new int[]{y, x, z + 1});
                            }
                        } else {
                            visit[move_y][move_x] = true;
                            queue.add(new int[]{move_y, move_x, z + 1});
                        }
                    }
                }
            }
        }
    }
}
