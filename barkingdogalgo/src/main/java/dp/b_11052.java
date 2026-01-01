package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 카드 구매하기
public class b_11052 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String [] s = br.readLine().split(" ");

        int [] cards = new int[N];
        for(int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(s[i]);
        }

        int [] dp = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            dp[i] = cards[i-1];
        }

        if(N == 1){
            System.out.println(dp[N]);
            return;
        }

        for(int i=2; i<=N; i++) {
            for(int j=1; j<=i; j++){
                dp[i] = Math.max(dp[i], dp[i-j] + dp[j]);
            }
        }

        System.out.println(dp[N]);
    }

}
