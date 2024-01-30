package day0130;

import java.util.Scanner;

public class swea2805 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {

            int n = sc.nextInt();
            int[][] farm = new int[n][n];
            int sum = 0; //수익
            for (int i = 0; i < n; i++) {
                String s = sc.next();
                for (int j = 0; j < n; j++) {
                    farm[i][j] = s.charAt(j) - '0';
                    sum += farm[i][j];
                }
            }
            int criteria = n / 2; //농작물을 수확할 기준 값
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    //거리 비교
                    int distance = Math.abs(i - n / 2) + Math.abs(j - n / 2);
                    if (distance > criteria) {
                        sum -= farm[i][j];
                    }
                }
            }
            System.out.println("#" + test_case + " " + sum);
        }
    }
}
