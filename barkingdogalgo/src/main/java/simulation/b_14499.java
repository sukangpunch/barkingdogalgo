package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 주사위 굴리기
public class b_14499 {

    static int N, M, X, Y;
    static int[][] map;
    static int[] dice;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        X = Integer.parseInt(s[2]);
        Y = Integer.parseInt(s[3]);
        int k = Integer.parseInt(s[4]);

        map = new int[N][M];
        dice = new int[6];

        for (int i = 0; i < N; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        s = br.readLine().split(" ");
        for (int i = 0; i < k; i++) {
            int order = Integer.parseInt(s[i]);
            simulation(order - 1);
        }

        System.out.println(sb);
    }

    private static void simulation(int dir) {
        int nx = X + dx[dir];
        int ny = Y + dy[dir];

        if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
            return;
        }

        int tmp = dice[5];
        switch (dir) {
            case 0:
                dice[5] = dice[2];
                dice[2] = dice[0];
                dice[0] = dice[3];
                dice[3] = tmp;
                break;
            case 1:
                dice[5] = dice[3];
                dice[3] = dice[0];
                dice[0] = dice[2];
                dice[2] = tmp;
                break;
            case 2:
                dice[5] = dice[4];
                dice[4] = dice[0];
                dice[0] = dice[1];
                dice[1] = tmp;
                break;
            default:
                dice[5] = dice[1];
                dice[1] = dice[0];
                dice[0] = dice[4];
                dice[4] = tmp;
                break;
        }

        sb.append(dice[0]).append("\n");

        X = nx;
        Y = ny;

        if (map[X][Y] == 0) {
            map[X][Y] = dice[5];
        }
        else{
            dice[5] = map[X][Y];
            map[X][Y] = 0;
        }
    }
}
