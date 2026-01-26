package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 이항계수 2
public class b_11051_learn {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);

        if(K == 0){
            System.out.println(1);
            return;
        }

        int [][] dp = new int[N+1][N+1];

        for(int i=1; i<=N; i++){
            dp[i][0] = dp[i][i] = 1;
            for(int j=1; j<i; j++){
                dp[i][j] = (dp[i-1][j] + dp[i-1][j-1]) % 10007;
            }
        }

        System.out.println(dp[N][K]);

    }

}
