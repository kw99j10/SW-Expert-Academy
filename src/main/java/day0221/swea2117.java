package day0221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//홈 방범 서비스
public class swea2117 {
    static int n, m;
    static int[][] arr;
    static ArrayList<int[]> house;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken()); //하나의 집의 지불 비용
            arr = new int[n][n];
            house = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());

                    if (arr[i][j] == 1) {
                        house.add(new int[]{i, j});
                    }
                }
            }

            max = 0;
            //서비스 영역 k에 대하여 집이 있는 좌표와 서비스 영역의 거리를 구함
            for (int k = 1; k <= n + 1; k++) {
                int operate = k * k + (k - 1) * (k - 1);
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        int count = 0; //영역 내 집의 개수

                        for (int[] home : house) {
                            int x = Math.abs(i - home[0]);
                            int y = Math.abs(j - home[1]);
                            if (k > x + y) {
                                count++;
                            }
                        }
                        //수익-운영비용인 이익을 구함 이때, 손해만 보지 않으면 됨
                        if (count > max && count * m >= operate) {
                            max = count;
                        }
                    }
                }
            }
            System.out.println("#" + test_case + " " + max);
        }
    }
}
