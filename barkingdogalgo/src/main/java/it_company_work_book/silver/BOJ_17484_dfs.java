package it_company_work_book.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 진우의 달 여행 (Small)
// 다이나믹 프로그래밍, 브루트 포스, dfs
/**
 * dfs 로도 문제를 해결 할 수 있다.
 * 높이 0, 열 0~M 까지의 값들부터 시작하여, 왼아래, 아래, 오른아래 방향으로의 dfs 탐색을 돌리면 된다.
 * dfs 기저 조건은 nextY가 N-1 마지막 인덱스 까지 도착이고, SUM 매개변수를 활용해 값을 더해나간다.
 * 0~2 까지 방향에서 이전 방향과 다른 방향에서의 dfs 를 탐색 해 나간다.
 */
public class BOJ_17484_dfs {

    static int N;
    static int M;
    static int[][] map;
    static int []dx = {-1, 0, 1};
    static final int INF = 987654321;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        result = INF;
        for(int i=0; i<M; i++){
            for(int j=0; j<3; j++){
                dfs(0, i, map[0][i], j);
            }
        }

        System.out.println(result);

    }

    private static void dfs(int nowY, int nowX, int sum, int dir) {
        if(nowY == N-1){
            result = Math.min(result, sum);
            return;
        }

        for(int i=0; i<3; i++){
            if(i==dir)continue;
            int nextX = nowX + dx[i];
            int nextY = nowY + 1;

            if(nextX < 0 || nextX >= M || nextY < 0 || nextY >= N) continue;
            dfs(nextY, nextX, sum + map[nextY][nextX], i);
        }
    }
}
