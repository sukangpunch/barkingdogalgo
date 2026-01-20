package stduy.week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 퇴사 2
public class BOJ_15486_solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N + 1];
        int[] P = new int[N + 1];

        for(int i = 1; i <= N; i++){
            String[] s = br.readLine().split(" ");
            T[i] = Integer.parseInt(s[0]);
            P[i] = Integer.parseInt(s[1]);
        }

        int[] dp = new int[N + 2]; // N+1일에 끝나는 상담을 위해 N+2 크기

        for(int i = 1; i <= N; i++){
            // i 일에 상담을 하지 않으면, i일의 수익이 i+1 에도 그대로 유지
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);

            // i일에 상담을 하는 경우
            int endDay = i + T[i];
            if(endDay <= N + 1){
                dp[endDay] = Math.max(dp[endDay], dp[i] + P[i]); // 수익이 발생하는 날에 바로 P값을 적용한 결과 저장
            }
        }

        System.out.println(dp[N + 1]);
    }
}
