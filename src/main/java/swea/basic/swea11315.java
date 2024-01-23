package swea.basic;

import java.util.Scanner;

//11315 - 오목 판정
public class swea11315 {
    static int n;
    static char[][] arr;

    //아래, 오른쪽, 오른 아래 대각선, 왼 아래 대각선만 고려
    static int[] dx = {0, 1, 1, 1};
    static int[] dy = {1, 1, 0, -1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {

            n = sc.nextInt();

            arr = new char[n][n];

            for (int i = 0; i < n; i++) {
                String s = sc.next();
                for (int j = 0; j < n; j++) {
                    arr[i][j] = s.charAt(j);
                }
            }

            boolean five = false; //오목인지를 판단할 변수
            String ans = "NO";
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] == 'o') {
                        five = checkFive(i, j);
                    }
                    if (five) {
                        ans = "YES"; //오목일 시 YES로 변경하고 반복문 종료
                        break;
                    }
                }
            }
            System.out.println("#" + test_case + " " + ans);
        }
    }
    static boolean checkFive(int i, int j) {

        for (int d = 0; d < 4; d++) {
            //5개 범위까지 돌의 유무 탐색
            for (int count = 1; count < 5; count++) {
                int nx = i + dx[d] * count;
                int ny = j + dy[d] * count;

                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (arr[nx][ny] == 'o') {
                        if (count == 4) {
                            return true;
                        }
                    }
                    else{
                        break;
                    }
                }
            }
        }
        return false;
    }
}
