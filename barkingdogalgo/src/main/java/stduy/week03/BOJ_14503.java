package stduy.week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 로봇 청소기
public class BOJ_14503 {

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] map;
    static int cnt = 0;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        s = br.readLine().split(" ");
        int nowR = Integer.parseInt(s[0]);
        int nowC = Integer.parseInt(s[1]);
        int nowD = Integer.parseInt(s[2]);

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        while (true) {
            if (map[nowR][nowC] == 0) {
                map[nowR][nowC] = -1;
                cnt++;
            }

            boolean found = false;
            for (int i = 0; i < 4; i++) {
                nowD = (nowD + 3) % 4;
                int ny = nowR + dy[nowD];
                int nx = nowC + dx[nowD];

                if (ny >= 0 && ny < N && nx >= 0 && nx < M && map[ny][nx] == 0) {
                    nowR = ny;
                    nowC = nx;
                    found = true;
                    break;
                }
            }

            if (!found) {
                int backD = (nowD + 2) % 4;
                int ny = nowR + dy[backD];
                int nx = nowC + dx[backD];
                if (ny >= 0 && ny < N && nx >= 0 && nx < M && map[ny][nx] != 1) {
                    nowR = ny;
                    nowC = nx;
                } else {
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}
