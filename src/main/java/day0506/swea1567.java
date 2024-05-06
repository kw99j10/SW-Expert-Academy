package day0506;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//프로세서 연결하기
public class swea1567 {
    static class Core {
        int x, y;

        public Core(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n, maxConnect, minSum;
    static int[][] board;
    static boolean[][] isConnected;
    static ArrayList<Core> lists;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {
            n = Integer.parseInt(br.readLine());

            lists = new ArrayList<>(); //core를 담을 리스트
            isConnected = new boolean[n][n];
            board = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());

                    if (board[i][j] == 1) {
                        if (i == 0 || i == n - 1 || j == 0 || j == n - 1) {
                            continue; //가장자리 Core는 무시
                        }
                        lists.add(new Core(i, j));
                    }
                }
            }

            maxConnect = Integer.MIN_VALUE; //최대한 많은 Core
            minSum = Integer.MIN_VALUE; //최소가 되는 전선 길이
            comb(0, 0);
            sb.append("#").append(test_case).append(" ").append(minSum).append("\n");
        }
        System.out.print(sb);
    }

    static void comb(int idx, int count) {
        if (idx == lists.size()) {
            if (count > maxConnect) {
                maxConnect = count;
                minSum = getLength();
            } else if (count == maxConnect) {
                minSum = Math.min(minSum, getLength());
            }
            return;
        }
        int x = lists.get(idx).x;
        int y = lists.get(idx).y;

        for (int d = 0; d < 4; d++) {
            if (isSearch(x, y, d)) {
                paint(x, y, d, 2);
                comb(idx + 1, count + 1);
                paint(x, y, d, 0);
            } else {
                comb(idx + 1, count); //전선이 겹친다면 개수는 유지한 채 다음 idx로
            }
        }
    }

    static boolean isSearch(int x, int y, int dir) {

        while (true) {
            x += dx[dir];
            y += dy[dir];
            if (x < 0 || x >= n || y < 0 || y >= n) {
                return true;
            }

            if (board[x][y] >= 1) {
                break; //전선이 겹치는 경우
            }
        }
        return false;
    }

    static void paint(int x, int y, int dir, int num) {
        while (true) {
            x += dx[dir];
            y += dy[dir];

            if (x < 0 || x >= n || y < 0 || y >= n) {
                break;
            }
            board[x][y] = num;
        }
    }

    static int getLength() {
        int length = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    length++;
                }
            }
        }
        return length;
    }
}
