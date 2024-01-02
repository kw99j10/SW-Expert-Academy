package swea.ssafyTask;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//최빈수 구하기: 정렬
public class swea1204 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {

            sc.nextInt();

            //최빈 값을 구하기 위한 map
            HashMap<Integer, Integer> student = new HashMap<>();

            for (int i = 0; i < 1000; i++) {
                int score = sc.nextInt(); //주어진 학생은 1000명
                student.put(score, student.getOrDefault(score, 0) + 1);
            }

            ArrayList<Map.Entry<Integer, Integer>> lists = new ArrayList<>(student.entrySet()); //학생에 대한 점수를 담을 리스트
            lists.sort((o1, o2) -> {
                if (o1.getValue().equals(o2.getValue())) {
                    return o2.getKey() - o1.getKey(); //최빈수가 여러 개면 가장 큰 값
                }
                return o2.getValue() - o1.getValue(); //최빈수 정렬
            });

            System.out.println("#" + test_case + " " + lists.get(0).getKey());
        }
    }
}
