package swea.ssafyTask;

import java.util.Scanner;

//숫자 배열 회전: 문자열
public class swea1961 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {

            int N = sc.nextInt(); //N x N의 행렬
            int[][] arr = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            int[][] tmp = rotation(N, arr); //90도 회전
            int[][] tmp2 = rotation(N, tmp); //180도 회전
            int[][] tmp3 = rotation(N, tmp2); //270도 회전
            System.out.println("#" + test_case);

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(tmp[i][j]);
                }
                System.out.print(" ");

                for (int j = 0; j < N; j++) {
                    System.out.print(tmp2[i][j]);
                }
                System.out.print(" ");

                for (int j = 0; j < N; j++) {
                    System.out.print(tmp3[i][j]);
                }
                System.out.println();
            }
        }
    }

    private static int[][] rotation(int N, int[][] arr) {
        int[][] tmp = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tmp[i][j] = arr[arr.length - j - 1][i];
            }
        }
        return tmp;
    }
}
