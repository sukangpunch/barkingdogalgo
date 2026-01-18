package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 평범한 배낭
public class b_12865_learn {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);

        int [][] items = new int[N+1][2];
        int [][] dp = new int[N+1][K + 1];

        for (int i = 1; i <= N; i++) {
            s = br.readLine().split(" ");
            int w = Integer.parseInt(s[0]);
            int v = Integer.parseInt(s[1]);
            items[i][0] = w;
            items[i][1] = v;
        }

        for(int j=1; j<=N; j++){
            int nowW = items[j][0];
            int nowV = items[j][1];
            for(int i=1; i<=K; i++){
                if(i >= nowW){
                    dp[j][i] = Math.max(dp[j-1][i], dp[j-1][i-nowW] + nowV);
                }else{
                    dp[j][i] = dp[j-1][i];
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}
