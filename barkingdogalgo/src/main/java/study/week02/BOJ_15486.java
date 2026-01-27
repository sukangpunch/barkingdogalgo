package study.week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 퇴사 2
public class BOJ_15486 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int [][] meetings = new int[N+1][2];

        for(int i=1; i<=N; i++){
            String []s = br.readLine().split(" ");
            int T = Integer.parseInt(s[0]);
            int P = Integer.parseInt(s[1]);
            meetings[i][0] = T;
            meetings[i][1] = P;
        }

        int [][]dp = new int[N+1][2];

        for(int i=1; i<=N; i++){
            if(meetings[i][0]+i > N+1){
                continue;
            }
            for(int j=0; j<i; j++){
                if(dp[j][0] + j <= i){
                    if(dp[i][1] < dp[i-1][1] + meetings[i][1]) {
                        dp[i][1] = Math.max(dp[i - dp[j][0]][1] + meetings[i][1], dp[i][1]);
                        dp[i][0] = meetings[i][0];
                    }
                }
            }
        }

        int max = 0;
        for(int i=1; i<=N; i++){
            if(max < dp[i][1]){
                max = dp[i][1];
            }
        }

        System.out.println(max);
    }

}
