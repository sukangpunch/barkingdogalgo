package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1, 2, 3 더하기
public class b_9095_retry {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t = 0 ; t<T ; t++){
            int N = Integer.parseInt(br.readLine());
            int [] dp = new int[N+1];
            dp[0] = 1;

            for(int i=1; i<=N; i++){
                for(int j=1; j<=3; j++){
                    if(i>=j){
                        dp[i] += dp[i-j];
                    }
                }
            }

            sb.append(dp[N]);
        }

        System.out.println(sb);
    }
}
