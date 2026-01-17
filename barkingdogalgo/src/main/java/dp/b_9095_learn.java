package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1, 2, 3 더하기
public class b_9095_learn {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine());

            if(N == 1){
                sb.append(1).append("\n");
                continue;
            }else if(N == 2){
                sb.append(2).append("\n");
                continue;
            }else if(N == 3){
                sb.append(4).append("\n");
                continue;
            }

            int [] dp = new int[N+1];

            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;

            for(int i=4; i<=N; i++){
                dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
            }

            sb.append(dp[N]).append("\n");
        }
        System.out.println(sb);
    }
}
