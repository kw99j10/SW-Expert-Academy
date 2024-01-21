package swea.ssafyTask;

import java.util.LinkedList;
import java.util.Scanner;

//파핑파핑 지뢰찾기

/**
 *  문제 풀이: 지뢰의 위치 탐색 -> 지뢰가 없는 곳 인접 지뢰 개수를 탐색
 *      -> bfs 수행 -> 방문하지 않은 위치 탐색
 */
public class swea1868 {
    static int n;
    static char[][] arr;
    static boolean[][] visit; //방문을 확인할 배열
    static int[] dx = {0, 0, -1, 1, 1, -1, -1, 1};
    static int[] dy = {-1, 1, 0, 0, 1, -1, 1, -1}; //경우의 수 8방향
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            n = sc.nextInt();

            arr = new char[n][n];
            visit = new boolean[n][n];

            // n*n 크기의 지뢰 찾기 표
            for (int i = 0; i < n; i++) {
                String s = sc.next();
                for (int j = 0; j < s.length(); j++) {
                    arr[i][j] = s.charAt(j);
                    if (arr[i][j] == '*') {
                        visit[i][j] = true; //지뢰는 미리 방문 처리
                    }
                }
            }

            //지뢰가 없는 곳에 맞닿아 있는 지뢰 개수를 탐색
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int count = 0;

                    for (int k = 0; k < 8; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                            if (arr[nx][ny] == '*') {
                                count += 1; //인접한 지뢰 개수 탐색
                            }
                        }
                    }
                    if (arr[i][j] == '.') {
                        arr[i][j] = (char) (count + '0'); //인접 지뢰 개수를 저장
                    }
                }
            }

            int click = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] == '0' && !visit[i][j]) {
                        bfs(i, j);
                        click += 1; //bfs 수행
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visit[i][j]) {
                        click += 1; //방문 안된 것들을 더함
                    }
                }
            }
            System.out.println("#" + test_case + " " + click);
        }
    }
    static void bfs(int i, int j) {
        LinkedList<int[]> lists = new LinkedList<>();
        lists.add(new int[]{i, j});
        visit[i][j] = true;

        while (!lists.isEmpty()) {
            int[] current = lists.poll();
            int x = current[0];
            int y = current[1];

            for (int k = 0; k < 8; k++) {
                int move_x = x + dx[k];
                int move_y = y + dy[k];

                if (move_x >= 0 && move_x < n && move_y >= 0 && move_y < n) {
                    if (!visit[move_x][move_y]) {
                        if (arr[move_x][move_y] == '0') {
                            visit[move_x][move_y] = true;
                            lists.add(new int[]{move_x, move_y});
                        }
                        else if (arr[move_x][move_y] != '0') {
                            visit[move_x][move_y] = true; //인접 지뢰가 있으므로 방문만 함
                        }
                    }
                }
            }
        }
    }
}