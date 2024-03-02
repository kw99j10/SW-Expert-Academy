package day0301;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//미생물 격리
public class swea2382 {
    static class Micro implements Comparable<Micro> {
        int x, y, count, dir, num; //칸의 번호(겹칠 때)

        public Micro(int x, int y, int count, int dir) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.dir = dir;
        }

        @Override
        public int compareTo(Micro o) {
            if (this.num == o.num) {
                return o.count - this.count; //칸 번호가 같다면 미생물이 많은 것
            }
            return this.num - o.num;
        }
    }

    static ArrayList<Micro> lists;
    static int n, m, k;
    static int[][] grid;
    static int[] dx = {0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, -1, 1};
    static int sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            grid = new int[n][n];
            lists = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());

                int w = Integer.parseInt(st.nextToken());
                int h = Integer.parseInt(st.nextToken());
                int cnt = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());

                lists.add(new Micro(w, h, cnt, dir));
            }

            //m시간 동안 미생물 이동
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < lists.size(); j++) {
                    Micro current = lists.get(j); //현재 미생물

                    int nx = current.x + dx[current.dir];
                    int ny = current.y + dy[current.dir];

                    //방향 이동
                    current.x = nx;
                    current.y = ny;
                    current.num = current.x * n + current.y;

                    //약품에 닿은 경우
                    if (current.x == 0 || current.x == n - 1 || current.y == 0 || current.y == n - 1) {
                        current.count /= 2; //크기를 절반으로

                        //방향을 90도 회전
                        switch (current.dir) {
                            case 1:
                                current.dir = 2;
                                break;
                            case 2:
                                current.dir = 1;
                                break;
                            case 3:
                                current.dir = 4;
                                break;
                            case 4:
                                current.dir = 3;
                                break;
                        }
                        if (current.count == 0) {
                            lists.remove(j); //사이즈가 0이면 리스트에서 제거
                            j--;
                        }
                    }
                }
                Collections.sort(lists);
                for (int j = 0; j < lists.size() - 1; j++) {
                    Micro current = lists.get(j);
                    Micro next = lists.get(j + 1);
                    if (current.num == next.num) {
                        current.count += next.count;
                        lists.remove(j + 1);
                        j--;
                    }
                }
            }
            sum = 0;
            for (Micro list : lists) {
                sum += list.count;
            }
            sb.append("#").append(test_case).append(" ").append(sum).append("\n");
        }
        System.out.print(sb);
    }
}
