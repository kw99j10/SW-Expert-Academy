package day0301;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//보호 필름
public class swea2112 {
    static int d, w, k;
    static int[][] board;
    static int[][] tmp; //부분 집합을 위해 복제할 배열
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            d = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            board = new int[d][w];
            tmp = new int[d][w];
            min = Integer.MAX_VALUE;

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                    tmp[i][j] = board[i][j];
                }
            }
            if (input()) {
                sb.append("#").append(test_case).append(" ").append(0).append("\n");
                continue; //이미 합격 기준이면 0을 출력 -> 성능 검사 넘어감
            }
            subset(0, 0);
            sb.append("#").append(test_case).append(" ").append(min).append("\n");
        }
        System.out.println(sb);
    }

    static boolean input() {
        for (int i = 0; i < w; i++) {
            int count = 1; //시작 열 포함
            int max = 0;
            for (int j = 1; j < d; j++) {
                if (tmp[j - 1][i] == tmp[j][i]) {
                    count++;
                } else {
                    count = 1; //같지 않으면 카운트 초기화
                }
                max = Math.max(max, count);
            }
            if (k > max) {
                return false; //k 기준에 만족해야함
            }
        }
        return true;
    }

    static void subset(int idx, int cnt) {
        if (input()) {
            min = Math.min(min, cnt);
            return;
        }

        if (idx == d) {
            return;
        }

        subset(idx + 1, cnt); //약물을 넣지 않은 경우

        for (int i = 0; i < w; i++) {
            tmp[idx][i] = 0;
        }
        subset(idx + 1, cnt + 1);

        for (int i = 0; i < w; i++) {
            tmp[idx][i] = 1;
        }
        subset(idx + 1, cnt + 1);

        for (int i = 0; i < w; i++) {
            tmp[idx][i] = board[idx][i];
        }
    }
}
