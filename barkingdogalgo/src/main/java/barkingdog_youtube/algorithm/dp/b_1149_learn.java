package barkingdog_youtube.algorithm.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// RGB거리
public class b_1149_learn {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] house = new int[N + 1][3];
        int[][] dp = new int[N + 1][3];

        for (int i = 1; i <= N; i++) {
            String[] s = br.readLine().split(" ");
            int r = Integer.parseInt(s[0]);
            int g = Integer.parseInt(s[1]);
            int b = Integer.parseInt(s[2]);
            house[i][0] = r;
            house[i][1] = g;
            house[i][2] = b;
        }

        dp[1][0] = house[1][0];
        dp[1][1] = house[1][1];
        dp[1][2] = house[1][2];

        for (int i = 2; i <= N; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + house[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + house[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + house[i][2];
        }

        int min1 = Math.min(dp[N][0], dp[N][1]);
        int min2 = Math.min(min1, dp[N][2]);
        System.out.println(min2);
    }
}
