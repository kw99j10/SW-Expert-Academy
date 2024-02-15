package day0213;

import java.util.Scanner;

//상호의 배틀필드
public class swea1873 {
    static int h, w;
    static char[][] map;
    static char[] arrow = {'^', 'v', '<', '>'};
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1}; //화살표 방향에 따른 이동 방향 (상,하,좌,우)
    static int x, y, dir; //현재 좌표와 현재 방향은 공유되어야 함
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            h = sc.nextInt();
            w = sc.nextInt();
            map = new char[h][w];
            for (int i = 0; i < h; i++) {
                String s = sc.next();
                for (int j = 0; j < w; j++) {
                    map[i][j] = s.charAt(j);

                    for (int d = 0; d < 4; d++) {
                        if (map[i][j] == arrow[d]) {
                            x = i;
                            y = j;
                            dir = d;
                            map[i][j] = '.';
                        }
                    }
                }
            }

            int n = sc.nextInt();
            String input = sc.next();
            for (int i = 0; i < n; i++) {
                char order = input.charAt(i);

                if (order == 'S') {
                    int curx = x;
                    int cury = y;
                    while (true) {
                        int nx = curx + dx[dir];
                        int ny = cury + dy[dir];

                        //맵 밖을 나가거나 강철 벽을 만나면 break
                        //벽돌 벽을 만나면 벽을 부수고 break
                        if (nx < 0 || nx >= h || ny < 0 || ny >= w || map[nx][ny] == '#') {
                            break;
                        } else if (map[nx][ny] == '*') {
                            map[nx][ny] = '.';
                            break;
                        }
                        curx = nx;
                        cury = ny;
                    }
                } else {
                    dir = turn(order); //방향에 따라 한 칸씩 이동
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];

                    if (nx >= 0 && nx < h && ny >= 0 && ny < w && map[nx][ny] == '.') {
                        x = nx;
                        y = ny;
                    }
                }
            }
            map[x][y] = arrow[dir]; //전차를 들어서 위치할 수 있음
            printMap(test_case);
        }
    }

    static int turn(char opt) {
        switch (opt) {
            case 'U':
                return 0;
            case 'D':
                return 1;
            case 'L':
                return 2;
            case 'R':
                return 3;
        }
        return -1;
    }

    static void printMap(int test_case) {
        System.out.print("#" + test_case + " ");
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}
