package day0130;

import java.util.Arrays;
import java.util.Scanner;

//1208 - Flattern
public class swea1208 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        for (int test_case = 1; test_case <= 10; test_case++) {
            int dump = sc.nextInt();

            int[] box = new int[100];
            for (int i = 0; i < 100; i++) {
                box[i] = sc.nextInt();
            }
            Arrays.sort(box);
            int min = box[0];
            int max = box[99];

            int count = 0; //박스 최대값 최소값 반복 정렬
            while (count != dump) {
                box[0] += 1;
                box[99] -= 1;
                Arrays.sort(box);
                min = box[0];
                max = box[99];
                count += 1;
            }

            int diff = max - min;
            System.out.println("#" + test_case + " " + diff);
        }
    }
}
