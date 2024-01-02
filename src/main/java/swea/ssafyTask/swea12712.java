package swea.ssafyTask;

import java.util.Scanner;

//파리 퇴치: 배열
public class swea12712 {
    public static void main(String[] args) throws Exception{

        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++){

            int n = sc.nextInt();
            int m = sc.nextInt();

            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            int max = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int sum1 = arr[i][j];
                    //'+' 형태
                    for (int k = 1; k < m; k++) {
                        if (i - k >= 0) {
                            sum1 += arr[i - k][j];
                        }
                        if (i + k >= 0 && i + k < n) {
                            sum1 += arr[i + k][j];
                        }
                        if (j - k >= 0) {
                            sum1 += arr[i][j - k];
                        }
                        if (j + k >= 0 && j + k < n) {
                            sum1 += arr[i][j + k];
                        }
                    }
                    max = Math.max(max, sum1);

                    int sum2 = arr[i][j];
                    //'x' 형태
                    for (int k = 1; k < m; k++) {
                        if (i - k >= 0 && j - k >= 0) {
                            sum2 += arr[i - k][j - k];
                        }
                        if (i - k >= 0 && j + k >= 0 && j + k < n) {
                            sum2 += arr[i - k][j + k];
                        }
                        if (i + k >= 0 && i + k < n && j - k >= 0) {
                            sum2 += arr[i + k][j - k];
                        }
                        if ((i + k >= 0 && i + k < n) && (j + k >= 0 && j + k < n)) {
                            sum2 += arr[i + k][j + k];
                        }
                    }
                    max = Math.max(max, sum2);
                }
            }
            System.out.println("#" + test_case + " " + max);
        }
    }
}
