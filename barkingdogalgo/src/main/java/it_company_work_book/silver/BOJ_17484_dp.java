package it_company_work_book.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 진우의 달 여행 (Small)
// 다이나믹 프로그래밍, 브루트 포스
/**
 * 알고리즘과 로직은 떠올렸는데, 복잡도 이슈로 구현을 못했다(답 확인)
 * 3차원 배열을 사용해야 하는데, 어떻게 dp를 진행하면서 값을 채워야 하는지 몰랐다.
 * 초기 값 0 에선 방향 상관 없이 값이 동일하기 때문에 모든 방향 값을 채운다.
 * 이후부턴, 왼쪽 벽, 오른쪽 벽 예외인 부분만 다르게 처리하고, 왼위, 위, 오른위 에서 내려오는 경우들의 최솟값들을 현재 위치 값과 더해주면서 반복
 * 마지막 행 인덱스에서 각 열의 3가지 방향 모든 값에서 최솟값을 찾으면 된다.
 */
public class BOJ_17484_dp {

    static int N;
    static int M;
    static int[][] map;
    static int[][][] dp;
    static final int INF = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        map = new int[N][M];
        dp = new int[N][M][3];

        for (int i = 0; i < N; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(s[j]);
                Arrays.fill(dp[i][j], INF);
            }
        }

        for (int i = 0; i < M; i++) {
            dp[0][i][0] = map[0][i];
            dp[0][i][1] = map[0][i];
            dp[0][i][2] = map[0][i];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (j == 0) {
                    dp[i][j][0] = Math.min(dp[i - 1][j + 1][1], dp[i - 1][j + 1][2]) + map[i][j];
                    dp[i][j][1] = dp[i - 1][j][0] + map[i][j];
                } else if (j == M - 1) {
                    dp[i][j][2] = Math.min(dp[i-1][j-1][0], dp[i-1][j-1][1]) + map[i][j];
                    dp[i][j][1] = dp[i-1][j][2] + map[i][j];
                }else{
                    dp[i][j][0] = Math.min(dp[i - 1][j + 1][1], dp[i - 1][j + 1][2]) + map[i][j];
                    dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + map[i][j];
                    dp[i][j][2] = Math.min(dp[i - 1][j-1][0], dp[i - 1][j-1][1]) + map[i][j];
                }
            }
        }

        int min = INF;
        for(int i=0; i<M; i++){
            for(int j=0; j<3; j++){
                if(min > dp[N-1][i][j]){
                    min = dp[N-1][i][j];
                }
            }
        }
        System.out.println(min);
    }
}
