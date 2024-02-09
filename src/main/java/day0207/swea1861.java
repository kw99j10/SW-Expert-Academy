package day0207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//1861 정사각형 방
public class swea1861 {
    static int n;
    static int[][] move = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int[][] arr;
    static int count; //최대 방 이동 횟수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            arr = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int max = 0;
            int maxIndex = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    count = 0;
                    dfs(i, j);
                    if (count > max || (count == max && maxIndex > arr[i][j])) {
                        max = count;
                        maxIndex = arr[i][j];
                    }
                }
            }
            sb.append("#").append(test_case).append(" ").append(maxIndex).append(" ").append(max).append("\n");
        }
        System.out.print(sb);
    }

    private static void dfs(int i, int j) {
        count += 1;
        for (int d = 0; d < 4; d++) {
            int nx = i + move[d][0];
            int ny = j + move[d][1];

            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (arr[nx][ny] == arr[i][j] + 1) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
