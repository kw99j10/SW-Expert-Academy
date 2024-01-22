package swea.basic;

import java.util.Scanner;

//6485 삼성시의 버스 노선
public class swea6485 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {

            int[] arr = new int[5001];
            int n = sc.nextInt();

            //첫번째 노선은 1이상 3이하 정류장만 다님
            for (int i = 1; i <= n; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                for (int j = a; j <= b; j++) {
                    arr[j] += 1;
                }
            }
            int p = sc.nextInt();
            int[] tmp = new int[p];
            for (int i = 0; i < p; i++) {
                tmp[i] = arr[sc.nextInt()];
            }
            System.out.print("#" + test_case + " ");
            for (int i = 0; i < p; i++) {
                System.out.print(tmp[i] + " ");
            }
            System.out.println();
        }
    }
}
