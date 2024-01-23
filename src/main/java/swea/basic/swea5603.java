package swea.basic;

import java.util.Scanner;

//5603 - 건초더미
public class swea5603 {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {

            int n = sc.nextInt();

            int sum = 0;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                sum += arr[i];
            }

            int count = 0;
            int standard = sum / arr.length; //기준치를 계산

            for (int i = 0; i < n; i++) {
                if (standard > arr[i]) {
                    count += standard - arr[i]; //기준치에 따른 움직임 횟수 계산
                }
            }

            System.out.println("#" + test_case + " " + count);
        }
    }
}
