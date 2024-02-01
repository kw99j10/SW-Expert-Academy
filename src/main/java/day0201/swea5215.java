package day0201;

import java.util.Scanner;

//햄버거 다이어트
public class swea5215 {
    static int n, l;
    static int[][] arr;
    static boolean[] visit;
    static int max;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++) {
            n = sc.nextInt();
            l = sc.nextInt();

            arr = new int[n][n];
            visit = new boolean[n];

            for (int i = 0; i < n; i++) {
                arr[i][0] = sc.nextInt(); //재료 점수
                arr[i][1] = sc.nextInt(); //칼로리
            }
            max = 0;
            hamburger(0, 0);
            System.out.println("#" + test_case + " " + max);
        }
    }

    static void hamburger(int cnt, int sum) {
        if (cnt == n) {
            if (l >= sum) {
                int resSum = 0;
                for (int i = 0; i < n; i++) {
                    if (visit[i]) {
                        resSum += arr[i][0];
                    }
                }
                max = Math.max(max, resSum);
            }
            return;
        }

        visit[cnt] = true;
        hamburger(cnt + 1, sum + arr[cnt][1]);
        visit[cnt] = false;
        hamburger(cnt + 1, sum);
    }
}
