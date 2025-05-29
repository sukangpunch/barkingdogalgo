package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 답 보기 : x(반례 확인)
// 메모리 : 14536 kb
// 시간 : 132 ms
public class b_11053 {
    static int [] sentence;
    static int [] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        sentence = new int[N + 1];
        dp = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            sentence[i] = Integer.parseInt(st.nextToken());
        }

        if(N == 1){
            System.out.println(1);
            return;
        }

        for(int i=1; i<N; i++){
            if(dp[i] == 0){
                dp[i] = 1;
            }
            for(int j=i+1; j<=N; j++){
                if(sentence[i] < sentence[j]){
                    dp[j] = Math.max(dp[i] + 1, dp[j]);
                }
            }
        }

        int max =0;
        for(int i=1; i<=N; i++){
            if(max < dp[i]){
                max = dp[i];
            }
        }
        System.out.println(max);
    }
}
