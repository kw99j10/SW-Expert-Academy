package swea.ssafyTask;

import java.util.Scanner;

//스도쿠 검증: 완전 탐색 -> 각 열 or 행 or 격자의 합이 45 임을 이용
public class swea1974 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {

            int[][] sudoku = new int[9][9];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sudoku[i][j] = sc.nextInt();
                }
            }

            boolean data = true; //배열의 가로, 세로, 3x3 격자의 숫자가 겹치는 지 판단

            //행 && 열 체크
            for (int i = 0; i < 9; i++) {
                int col_sum = 0;
                int row_sum = 0;

                for (int j = 0; j < 9; j++) {
                    col_sum += sudoku[i][j];
                    row_sum += sudoku[j][i];
                }

                if (col_sum != 45 || row_sum != 45) {
                    data = false;
                }
            }

            //3x3 격자 체크
            for (int i = 0; i < 9; i += 3) {
                for (int j = 0; j < 9; j += 3) {
                    int sum = 0;

                    for (int k = 0; k < 3; k++) {
                        for (int t = 0; t < 3; t++) {
                            sum += sudoku[i + k][j + t];
                        }
                    }
                    if (sum != 45) {
                        data = false;
                    }
                }
            }

            int answer = data ? 1 : 0; //조건을 모두 만족하면 1 아니면 0
            System.out.println("#" + test_case + " " + answer);
        }
    }
}
