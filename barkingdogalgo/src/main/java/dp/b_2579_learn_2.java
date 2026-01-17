package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 계단 오르기
public class b_2579_learn_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());


        int [] stair = new int[N+1];
        int total = 0;
        for(int i=1; i<=N; i++){
            stair[i] = Integer.parseInt(br.readLine());
            total += stair[i];
        }

        if(N <= 2){
            System.out.println(total);
            return;
        }

        int []dp = new int[N+1];

        dp[1] = stair[1]; 
        dp[2] = stair[2];
        dp[3] = stair[3];

        for(int i=4; i<=N-1; i++){
            dp[i] = Math.min(dp[i-2], dp[i-3]) + stair[i]; // 안 밟을 계단을 고른다.
        }

        System.out.println(total - Math.min(dp[N-1], dp[N-2])); // 마지막 계단은 무조건 안밟아야 하기 떄문
    }

}
