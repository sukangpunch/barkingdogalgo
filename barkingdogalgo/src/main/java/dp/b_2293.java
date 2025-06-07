package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 답 보기 : x
// 메모리 : 14352 kb
// 시간 : 116 ms
public class b_2293 {
    static int [] coins;
    static int [] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        dp = new int[k+1];
        coins = new int[n];
        for(int i=0; i<n; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(coins);

        dp[0] = 1;

        for(int i=0; i<n; i++){
            for(int j=1; j<=k; j++){
                if(j>=coins[i]){
                    dp[j] += dp[j-coins[i]];
                }
            }
        }

        System.out.println(dp[k]);
    }
}
