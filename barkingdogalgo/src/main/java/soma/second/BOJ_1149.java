package soma.second;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// RGB 거리
// dp

/**
 * 상태값이 존재하는 dp 문제이다.
 * 각 집을 빨초파 칠하는 가격이 주어진다. 붙어있는 집은 같은 색을 칠할 수 없다.
 * 즉, 그리디하게 답을 찾을 수 없으므로 dp 활용
 * dp[i][0~2] 0~2 범위가 각각 순서대로 빨강, 초록, 파랑 이고 dp[i][0] 인경우, dp[i][1], dp[i][2] 인 집일 경우에만 칠할 수 있다.
 * 또한 dp[i+1] 인 집은 dp[i-1] 인 집의 색갈에 독립시행이기 떄문에, dp[i][...] 는 해당 색갈이 가능해지는 이전 값 중 최솟값을 찾으면 되는 것.
 * 마지막 집에서 빨, 초, 파랑으로 색칠한 경우 중 최소값을 찾으면 된다.
 */
public class BOJ_1149 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][3];

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        int result = solution(N, map);
        System.out.println(result);
    }

    private static int solution(int n, int[][] map) {
        int[][] dp = new int[n][3];

        dp[0][0] = map[0][0];
        dp[0][1] = map[0][1];
        dp[0][2] = map[0][2];

        for (int i = 1; i < n; i++) {
            dp[i][0] += Math.min(dp[i-1][1], dp[i-1][2]) + map[i][0];
            dp[i][1] += Math.min(dp[i-1][0], dp[i-1][2]) + map[i][1];
            dp[i][2] += Math.min(dp[i-1][0], dp[i-1][1]) + map[i][2];
        }

        int min = Integer.MAX_VALUE;
        for(int i=0; i<3; i++){
            if(dp[n-1][i] < min){
                min = dp[n-1][i];
            }
        }

        return min;
    }

}
