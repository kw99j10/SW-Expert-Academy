package day0506;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//특이한 자석
public class swea4013 {
    static int[][] magnet;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {
            int k = Integer.parseInt(br.readLine());
            magnet = new int[4][8];
            for (int i = 0; i < 4; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 8; j++) {
                    magnet[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            while (k != 0) {
                st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken()) - 1;
                int dir = Integer.parseInt(st.nextToken());

                leftCheck(num - 1, -dir);
                rightCheck(num + 1, -dir);
                move(num, dir);
                k--;
            }
            int answer = magnet[0][0] + magnet[1][0] * 2 + magnet[2][0] * 4 + magnet[3][0] * 8;
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }
        System.out.print(sb);
    }

    static void move(int num, int dir) {
        if (dir == 1) {
            int tmp = magnet[num][7];
            for (int i = 7; i > 0; i--) {
                magnet[num][i] = magnet[num][i - 1];
            }
            magnet[num][0] = tmp;
        } else {
            int tmp = magnet[num][0];
            for (int i = 0; i < 7; i++) {
                magnet[num][i] = magnet[num][i + 1];
            }
            magnet[num][7] = tmp;
        }
    }

    static void leftCheck(int num, int dir) {

        if (num < 0) {
            return;
        }

        if (magnet[num][2] == magnet[num + 1][6]) {
            return;
        }

        leftCheck(num - 1, -dir);
        move(num, dir);
    }

    static void rightCheck(int num, int dir) {

        if (num > 3) {
            return;
        }

        if (magnet[num][6] == magnet[num - 1][2]) {
            return;
        }

        rightCheck(num + 1, -dir);
        move(num, dir);
    }
}
