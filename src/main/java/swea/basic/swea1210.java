package swea.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//1210 - Ladder1
public class swea1210 {
    static int[][] move = {{0, 1}, {-1, 0}, {0, -1}};
    static int[][] arr;
    static boolean[][] visit;
    static int obj_x, obj_y;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= 10; test_case++) {

            int t = Integer.parseInt(br.readLine());

            arr = new int[100][100];
            visit = new boolean[100][100];

            for (int i = 0; i < 100; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());

                    if (arr[i][j] == 2) {
                        obj_x = i;
                        obj_y = j;
                    }
                }
            }
            visit[obj_x][obj_y] = true;
            findLadder(obj_x, obj_y); //목적지에서 시작
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    static void findLadder(int x, int y) {
        while (true) {
            if (x == 0) {
                answer = y;
                break;
            }
            for (int i = 0; i < 3; i++) {
                int nx = x + move[i][0];
                int ny = y + move[i][1];

                if (nx >= 0 && nx < 100 && ny >= 0 && ny < 100) {
                    if (arr[nx][ny] == 1 && !visit[nx][ny]) {
                        visit[nx][ny] = true;
                        x = nx;
                        y = ny;
                    }
                }
            }
        }
    }
}
