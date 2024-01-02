package swea.ssafyTask;

import java.util.Scanner;

//두 개의 숫자열: 완전 탐색
public class swea1959 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {

            int N = sc.nextInt(); //배열 A의 크기
            int M = sc.nextInt(); //배열 B의 크기

            int[] A = new int[N];
            int[] B = new int[M];

            for (int i = 0; i < N; i++) {
                A[i] = sc.nextInt();
            }
            for (int i = 0; i < M; i++) {
                B[i] = sc.nextInt();
            }

            int max = 0; //최댓값

            if (N == M) {
                for (int i = 0; i < N; i++) {
                    max += A[i] * B[i];
                }
            } else if (N > M) {
                for (int i = 0; i < N - M + 1; i++) {
                    int sum = 0; //숫자들을 곱한 뒤 더한 값
                    for (int j = 0; j < M; j++) {
                        sum += B[j] * A[j + i];
                    }
                    max = Math.max(sum, max);
                }
            } else {
                for (int i = 0; i < M - N + 1; i++) {
                    int sum = 0; //숫자들을 곱한 뒤 더한 값
                    for (int j = 0; j < N; j++) {
                        sum += A[j] * B[j + i];
                    }
                    max = Math.max(sum, max);
                }
            }
            System.out.println("#" + test_case + " " + max);
        }
    }
}
