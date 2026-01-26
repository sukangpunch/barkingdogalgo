package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 이항계수
public class b_11050_learn {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);

        if(K == 0){
            System.out.println(1);
            return;
        }

        int [] dp = new int[N+1];

        dp[0] = 1;
        dp[1] = 1;

        for(int i=2; i<=N; i++){
            dp[i] = dp[i-1] * i;
        }

        System.out.println(dp[N] /(dp[K] * dp[N-K]));

    }
}
