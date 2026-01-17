package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1로 만들기 2
public class b_12852_learn {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int []dp = new int[N+1];
        int []pre = new int[N+1]; // 값이 도출된 경로를 저장하기 위한 배열

        dp[1] = 0;
        for(int i=2; i<=N; i++){
            dp[i] = dp[i-1] + 1;
            pre[i] = i-1;

            if(i%2 == 0 && dp[i] > dp[i/2] + 1){
                dp[i] = dp[i/2] + 1;
                pre[i] = i/2;
            }
            if(i%3 == 0 && dp[i] > dp[i/3] + 1){
                dp[i] = dp[i/3] + 1;
                pre[i] = i/3;
            }
        }
        sb.append(dp[N]).append("\n");
        int cur = N;
        while(true){
            sb.append(cur).append(" ");
            if(cur == 1) break;
            cur = pre[cur];
        }

        System.out.println(sb);
    }
}
