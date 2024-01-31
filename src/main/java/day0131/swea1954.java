package day0131;

import java.util.Scanner;

//달팽이 숫자
public class swea1954 {
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    public static void main(String[] args) throws Exception{

        Scanner sc = new Scanner(System.in);
        int T =sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();

            int[][] arr = new int[n][n];
            int count = 1;

            int idx = 0;
            int nx = 0;
            int ny = 0;
            while (count <= n * n) {

                if (nx >= 0 && nx < n && ny >= 0 && ny < n && arr[ny][nx] == 0) {
                    arr[ny][nx] = count++;
                    nx += dx[idx];
                    ny += dy[idx];
                }
                else {
                    nx -= dx[idx];
                    ny -= dy[idx];
                    idx = (idx + 1) % 4;
                    nx += dx[idx];
                    ny += dy[idx];
                }
            }
            System.out.println("#" + test_case);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
