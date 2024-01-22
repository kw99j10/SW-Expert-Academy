package swea.basic;

import java.util.ArrayList;
import java.util.Scanner;

//1859 - 백만 장자 프로젝트
public class swea1859 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {

            int n = sc.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            long max = 0; //최대 매매가
            ArrayList<Long> list = new ArrayList<>();

            for (int i = n - 1; i >= 0; i--) {
                if (arr[i] > max) {
                    max = arr[i];
                }
                list.add(max - arr[i]);
            }

            long sum = 0; //최대 이익
            for (Long aLong : list) {
                sum += aLong;
            }

            sb.append("#").append(test_case).append(" ").append(sum).append("\n");
        }
        System.out.print(sb);
    }
}
