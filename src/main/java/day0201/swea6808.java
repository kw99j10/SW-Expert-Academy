package day0201;

import java.util.Scanner;
public class swea6808 {
    static int win, lose;
    static int[] gyu;
    static int[] in;
    static boolean[] isSelected;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {

            gyu = new int[9];
            in = new int[9];
            isSelected = new boolean[18];

            for (int i = 0; i < 9; i++) {
                gyu[i] = sc.nextInt();
                isSelected[gyu[i] - 1] = true;
            } //규영이 카드를 먼저 저장

            int idx = 0;
            for (int i = 0; i < 18; i++) {
                if (isSelected[i]) {
                    continue;
                }
                in[idx++] = i + 1;
            }//인영이 카드가 주어짐

            win = 0; //규영이가 이김
            lose = 0; //규영이가 짐(인영이가 이김)
            game(0);
            sb.append("#").append(test_case).append(" ").append(win).append(" ").append(lose).append("\n");
        }
        System.out.print(sb);
    }
    static void game(int cnt) {
        if (cnt == 9) {
            int sum1 = 0;
            int sum2 = 0;

            for (int i = 0; i < 9; i++) {
                if (gyu[i] > in[i]) {
                    sum1 += (gyu[i] + in[i]);
                } else if (gyu[i] < in[i]) {
                    sum2 += (gyu[i] + in[i]);
                }
            }
            if (sum1 > sum2) {
                win++;
            } else if (sum2 > sum1) {
                lose++;
            }
            return;
        }

        for (int i = 0; i < 18; i++) {
            if (!isSelected[i]) {
                isSelected[i] = true;
                in[cnt] = i + 1;
                game(cnt + 1);
                isSelected[i] = false;
            }
        }
    }
}
