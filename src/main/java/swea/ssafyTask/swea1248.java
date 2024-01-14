package swea.ssafyTask;

import java.util.LinkedList;
import java.util.Scanner;

//공통조상
public class swea1248 {
    static int[] parent; //노드의 부모 노드를 기록할 배열
    static int[][] child; //자식 노드를 담을 배열
    static boolean[] visit; //방문을 확인할 배열
    static int v, e; //정점의 개수와 간선의 개수
    static int com1, com2; //두 개의 정점 번호

    public static void main(String[] args) throws Exception{

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            v = sc.nextInt();
            e = sc.nextInt();
            com1 = sc.nextInt();
            com2 = sc.nextInt();

            parent = new int[v + 1];
            child = new int[v + 1][2];
            visit = new boolean[v + 1];


            for (int i = 0; i < e; i++) {

                int a = sc.nextInt();
                int b = sc.nextInt();
                parent[b] = a;
                if (child[a][0] == 0) {
                    child[a][0] = b; //자식이 없다면 왼쪽 노드에 저장
                }
                else{
                    child[a][1] = b; //자식이 있다면 오른쪽 노드에 저장
                }
            }

            int x = com1;
            int y = com2; //두개의 정점
            visit[x] = visit[y] = true;

            int next1 = 0;
            int next2 = 0;

            int ans1 = 0;
            int ans2 = 0;

            LinkedList<Integer> queue = new LinkedList<>();

            while (true) {
                if (parent[x] != 0) {
                    next1 = parent[x];

                    if (visit[next1]) {
                        ans1 = next1;
                        break;
                    }

                    visit[next1] = true;
                }

                if (parent[y] != 0) {
                    next2 = parent[y];

                    if (visit[next2]) {
                        ans1 = next2;
                        break;
                    }
                    visit[next2] = true;
                }
                x = next1;
                y = next2;
            }
            queue.add(ans1);
            while (!queue.isEmpty()) {
                Integer current = queue.poll();
                ans2 += 1;

                if (child[current][0] == 0) {
                    continue;
                }
                queue.add(child[current][0]);

                if (child[current][1] == 0) {
                    continue;
                }
                queue.add(child[current][1]);
            }
            System.out.println("#" + test_case + " " + ans1 + " " + ans2);
        }
    }

}
