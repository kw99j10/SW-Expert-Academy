package swea.basic;

import java.util.Scanner;

//8104 - 조 만들기
public class swea8104 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {

            int n = sc.nextInt();
            int k = sc.nextInt();

            int[][] arr = new int[k + 1][n + 1];
            int count = 1;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= k; j++) {

                    if (i % 2 == 0) {
                        arr[k - j + 1][i] = count++; //역순 배치
                    } else {
                        arr[j][i] = count++;
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= k; i++) {
                int sum = 0;
                for (int j = 1; j <= n; j++) {
                    sum += arr[i][j]; // k번 조의 실력
                }
                sb.append(sum).append(" ");
            }

            System.out.println("#" + test_case + " " + sb);
        }
    }
}
