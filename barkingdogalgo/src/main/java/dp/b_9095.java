package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 답 보기 : x
// 메모리 : 14148 kb
// 시간 : 108 ms
public class b_9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            int test = Integer.parseInt(br.readLine());

            int []dp = new int[test+1];
            dp[0] = 1;

            for(int j=1; j <= test; j++){
                for(int k=1; k <= 3; k++){
                    if(j>=k){
                        dp[j] += dp[j-k];
                    }
                }
            }

            sb.append(dp[test]).append("\n");
        }
        System.out.println(sb);
    }
}
