package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 파도반 수열
public class b_9461 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            long [] dp = new long[N + 1];

            if(N == 1 || N == 2 || N == 3) {
                sb.append("1").append("\n");
                continue;
            }
            if(N == 4 || N == 5) {
                sb.append("2").append("\n");
                continue;
            }

            dp[1] = 1;
            dp[2] = 1;
            dp[3] = 1;
            dp[4] = 2;
            dp[5] = 2;

            for(int i = 6; i <= N; i++) {
                dp[i] = dp[i-1] + dp[i-5];
            }

            sb.append(dp[N]).append("\n");
        }

        System.out.println(sb);

    }
}
