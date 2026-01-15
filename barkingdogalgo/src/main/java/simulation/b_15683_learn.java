package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 감시
public class b_15683_learn {

    static class CCTV {

        int y;
        int x;
        int type;

        public CCTV(int y, int x, int type) {
            this.y = y;
            this.x = x;
            this.type = type;
        }
    }

    static int N;
    static int M;
    static List<CCTV> cctvs;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {-1, 0, 1, 0};
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        int[][] map = new int[N][M];
        cctvs = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(s[j]);
                if (num > 0 && num < 6) {
                    cctvs.add(new CCTV(i, j, num));
                }
                map[i][j] = num;
            }
        }

        simulate(0, map);

        System.out.println(result);

    }

    private static void simulate(int depth, int[][] map) {
        if (depth == cctvs.size()) {
            result = Math.min(result, calculateBlindSpot(map));
            return;
        }

        CCTV now = cctvs.get(depth);
        int rotationCount = 4;

        if (now.type == 2) {
            rotationCount = 2;
        } else if(now.type == 5) {
            rotationCount = 1;
        }

        for (int rotation = 0; rotation < rotationCount; rotation++) {
            int[][] newMap = copyMap(map); // 백트래킹 할 때, 함수 리턴 후 최근 값을 지워주지만, map 전체를 지우기는 비효율적이라 매 스택마다 새로운 map 을 두어 depth 빠져나오면 알아서 변경사항 취소되도록
            makeMapCheck(newMap, now.y, now.x, now.type, rotation);
            simulate(depth + 1, newMap);
        }
    }

    private static int[][] copyMap(int[][] oldMap) {
        int[][] newMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            System.arraycopy(oldMap[i],0, newMap[i],0, M); // 깊은 복사 - 왼쪽 배열의 값을 오른쪽으로
        }

        return newMap;
    }

    private static int calculateBlindSpot(int[][] map) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static void makeMapCheck(int[][] map, int y, int x, int type, int rotation) {
        switch (type) {
            case 1:
                check(map, rotation, y, x);
                break;
            case 2:
                check(map, rotation, y, x);
                check(map, rotation + 2, y, x);
                break;
            case 3:
                check(map, rotation, y, x);
                check(map, (rotation + 1) % 4, y, x);
                break;
            case 4:
                check(map, rotation, y, x);
                check(map, (rotation + 1) % 4, y, x);
                check(map, (rotation + 2) % 4, y, x);
                break;
            case 5:
                check(map, rotation, y, x);
                check(map, rotation + 1, y, x);
                check(map, rotation + 2, y, x);
                check(map, rotation + 3, y, x);
                break;
        }
    }

    private static void check(int[][] map, int rotation, int y, int x) {
        while (true) {
            y += dy[rotation];
            x += dx[rotation];

            if (y < 0 || y >= N || x < 0 || x >= M || map[y][x] == 6) {
                break;
            }

            if (map[y][x] == 0) {
                map[y][x] = -1;
            }
        }
    }
}
