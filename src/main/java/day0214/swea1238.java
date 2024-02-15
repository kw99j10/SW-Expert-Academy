package day0214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//Contact
public class swea1238 {
    static int len, start;
    static ArrayList<Integer>[] lists;
    static int[] visit;
    static ArrayList<Integer> index;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int test_case = 1; test_case <= 10; test_case++) {
            st = new StringTokenizer(br.readLine());

            len = Integer.parseInt(st.nextToken());
            start = Integer.parseInt(st.nextToken());

            lists = new ArrayList[101];
            visit = new int[101];
            for (int i = 1; i <= 100; i++) {
                lists[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < len / 2; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                lists[from].add(to);
            }

            index = new ArrayList<>();
            bfs();
            Collections.sort(index);
            int max = index.get(index.size() - 1);
            sb.append("#").append(test_case).append(" ").append(max).append("\n");
        }
        System.out.print(sb);
    }
    static void bfs() {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visit[start] = 1;
        int max = 0;

        while (!queue.isEmpty()) {
            Integer current = queue.poll();

            for (Integer list : lists[current]) {
                if (visit[list] != 0) {
                    continue;
                }
                visit[list] = visit[current] + 1;
                queue.add(list);
            }
            max = visit[current];
        }

        for (int i = 1; i <= 100; i++) {
            if (max != visit[i]) {
                continue;
            }
            index.add(i);
        }
    }
}
