package swea.basic;

import java.util.Scanner;

//13038 - 교환학생
public class swea13038 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {

            int n = sc.nextInt(); // n일 동안 수업 들어야 함

            int[] days = new int[7];
            for (int i = 0; i < 7; i++) {
                days[i] = sc.nextInt();
            }

            int[] min = new int[7];
            int minValue = Integer.MAX_VALUE;

            //언제부터 시작해야 최소 일수일지
            for (int i = 0; i < 7; i++) {
                boolean start = false; // 최소 일수를 계산하기 위한 시작점 계산
                int count = 0;
                int obj = 0;
                int idx = i;

                while (obj != n) {

                    if (days[idx % 7] == 1) {
                        start = true;
                        obj += 1;
                    }

                    if (start) {
                        count += 1;
                    }
                    idx += 1;
                }
                min[i] = count;
                minValue = Math.min(minValue, min[i]);
            }
            System.out.println("#" + test_case + " " + minValue);
        }
    }
}
