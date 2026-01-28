package algorithm.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 퇴사
public class b_14501 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int [] T = new int[N];
        int [] P = new int[N];
        int [] dp = new int[N+1];

        for(int i=0; i<N; i++){
            String [] s = br.readLine().split(" ");
            int times = Integer.parseInt(s[0]);
            int cost =  Integer.parseInt(s[1]);
            T[i] = times;
            P[i] = cost;
        }

        for(int i=0; i<N;i++){
            if(i+T[i] <= N){
                dp[i + T[i]] = Math.max(dp[i+T[i]], dp[i] + P[i]);
            }
            dp[i+1] = Math.max(dp[i+1], dp[i]);
        }
        System.out.println(dp[N]);
    }
}
