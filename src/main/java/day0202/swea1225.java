package day0202;

import java.util.LinkedList;
import java.util.Scanner;

//1215 암호 생성기
public class swea1225 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int test_case = 1; test_case <= 10; test_case++){
            sc.nextInt(); //테스트케이스 번호

            LinkedList<Integer> queue = new LinkedList<>();
            for (int i = 0; i < 8; i++) {
                queue.offer(sc.nextInt()); //8개의 데이터
            }

            int idx = 1;
            while (true) {
                //한 사이클

                if (idx > 5) {
                    idx = 1;
                }

                if (!queue.isEmpty()) {
                    if (queue.peekFirst() - idx <= 0) {
                        queue.addLast(0);
                        queue.pollFirst();
                        break;
                    } else {
                        queue.addLast(queue.pollFirst() - idx);
                    }
                }
                idx++;
            }

            System.out.print("#" + test_case + " ");
            for (Integer list : queue) {
                System.out.print(list + " ");
            }
            System.out.println();
        }
    }
}
