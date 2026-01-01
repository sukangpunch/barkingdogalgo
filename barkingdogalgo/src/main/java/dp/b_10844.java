package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 쉬운 계단 수
public class b_10844 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = 0;
        int N = Integer.parseInt(br.readLine());
        int [][] dp = new int[N + 1][10];

        for(int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        if(N == 1){
            for(int i=0; i<=9; i++){
                cnt += dp[1][i];
            }
            System.out.println(cnt);
            return;
        }

        for(int i=2; i<=N; i++){
            for(int j=0; j<=9; j++){
                if(j==0){
                    dp[i][j] = dp[i-1][j+1];
                }else if(j==9){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000;
                }
            }
        }

        for(int i=0; i<=9; i++){
            cnt += dp[N][i];
            cnt %= 1000000000;
        }

        System.out.println(cnt);
    }

}
