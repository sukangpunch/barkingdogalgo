package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 답 보기 : x
// 메모리 : 14372 kb
// 시간 : 128 ms
public class b_11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long [] dp = new long[n + 1];

        if(n >= 3){
            dp[1] = 1;
            dp[2] = 2;

            for(int i = 3; i <= n; i++) {
                dp[i] = (dp[i-1] % 10007 + dp[i-2] % 10007) % 10007;
            }
        }else{
            System.out.println(n);
            return;
        }

        System.out.println(dp[n]);
    }
}
