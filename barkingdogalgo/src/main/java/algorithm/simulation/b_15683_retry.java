package algorithm.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class b_15683_retry {

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

    // {y축, x축}
    static int[][] direction = {
            {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };
    static int N;
    static int M;
    static ArrayList<CCTV> cctv;
    static int minimumBlindSpotCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cctv = new ArrayList<>();

        int[][] office = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num <= 5 && num >= 1) {
                    office[i][j] = num;
                    cctv.add(new CCTV(i, j, num));
                } else {
                    office[i][j] = num;
                }
            }
        }

        minimumBlindSpotCount = Integer.MAX_VALUE;
        findMinimumOfficeBlindSpot(0, office);

        System.out.println(minimumBlindSpotCount);
    }

    private static void findMinimumOfficeBlindSpot(int depth, int[][] office) {
        if (depth == cctv.size()) {
            minimumBlindSpotCount = Math.min(minimumBlindSpotCount, countOfficeBlindSpot(office));
            return;
        }

        CCTV nowCctv = cctv.get(depth);
        int rotationCount = findRotationCount(nowCctv);

        for (int rotation = 0; rotation < rotationCount; rotation++) {
            int[][] snapshotOffice = copyOfficeStatus(office);
            checkCctvWatchRangeByRotation(rotation, nowCctv, snapshotOffice);
            findMinimumOfficeBlindSpot(depth + 1, snapshotOffice);
        }

    }

    private static int countOfficeBlindSpot(int[][] office) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (office[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    private static void checkCctvWatchRangeByRotation(int rotation, CCTV cctv, int[][] snapshotOffice) {
        int cctvType = cctv.type;

        if (cctvType == 1) {
            checkVisibilityOfCctvInTheOffice(rotation, snapshotOffice, cctv);
            return;
        }

        if (cctvType == 2) {
            checkVisibilityOfCctvInTheOffice(rotation, snapshotOffice, cctv);
            checkVisibilityOfCctvInTheOffice(rotation + 2, snapshotOffice, cctv);
            return;
        }

        if (cctvType == 3) {
            checkVisibilityOfCctvInTheOffice(rotation, snapshotOffice, cctv);
            checkVisibilityOfCctvInTheOffice((rotation + 1) % 4, snapshotOffice, cctv);
            return;
        }

        if (cctvType == 4) {
            checkVisibilityOfCctvInTheOffice(rotation, snapshotOffice, cctv);
            checkVisibilityOfCctvInTheOffice((rotation + 1) % 4, snapshotOffice, cctv);
            checkVisibilityOfCctvInTheOffice((rotation + 2) % 4, snapshotOffice, cctv);
            return;
        }

        if (cctvType == 5) {
            checkVisibilityOfCctvInTheOffice(0, snapshotOffice, cctv);
            checkVisibilityOfCctvInTheOffice( 1, snapshotOffice, cctv);
            checkVisibilityOfCctvInTheOffice( 2, snapshotOffice, cctv);
            checkVisibilityOfCctvInTheOffice( 3, snapshotOffice, cctv);
        }

    }

    private static void checkVisibilityOfCctvInTheOffice(int rotation, int[][] snapshotOffice, CCTV cctv) {
        int y = direction[rotation][0];
        int x = direction[rotation][1];

        int cctvY = cctv.y;
        int cctvX = cctv.x;

        while (true) {
            cctvY += y;
            cctvX += x;
            if (cctvY >= N || cctvX >= M || cctvY < 0 || cctvX < 0 || snapshotOffice[cctvY][cctvX] == 6) {
                return;
            }

            if (snapshotOffice[cctvY][cctvX] == 0) {
                snapshotOffice[cctvY][cctvX] = -1;
            }
        }
    }

    private static int[][] copyOfficeStatus(int[][] oldOffice) {
        int[][] newOffice = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                newOffice[i][j] = oldOffice[i][j];
            }
        }
        return newOffice;
    }

    private static int findRotationCount(CCTV nowCctv) {

        if (nowCctv.type == 2) {
            return 2;
        }

        if (nowCctv.type == 5) {
            return 1;
        }

        // 1, 3, 4 타입은 4방향 모두 탐색 해야한다.
        return 4;
    }

}
