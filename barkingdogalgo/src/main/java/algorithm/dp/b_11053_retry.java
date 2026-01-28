package algorithm.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 가장 긴 증가하는 부분 수열
public class b_11053_retry {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int [] seq = new int[N+1];
        int [] dp = new int[N+1];
        String [] s = br.readLine().split(" ");

        for(int i=1; i<=N; i++){
            seq[i] = Integer.parseInt(s[i-1]);
            dp[i] = 1;
        }

        int max = 1;
        for(int i=1; i<=N; i++){
            for(int j=1; j<i; j++){
                if(seq[i] > seq[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
