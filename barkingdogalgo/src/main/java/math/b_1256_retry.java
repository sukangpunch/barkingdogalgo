package math;

import java.io.*;
import java.util.StringTokenizer;


// 답 보기 : o
// 메모리 : 14516 kb
// 시간 : 108 ms
public class b_1256_retry {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        long [][] dp = new long[N+M+1][N+M+1];

        // 이항계수 조합 값
        dp[0][0] = 1;
        for(int i=1; i<=N+M; i++){
            dp[i][0] = 1;
            dp[i][i] = 1;
            for(int j=1; j<i; j++){
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];

                // long 범위를 넘어서는 경우
                if(dp[i][j] > 1000000000){
                    dp[i][j] = 1000000001;
                }
            }
        }

        if(dp[N+M][N] < K){
            bw.write("-1");
        }else{
            while(N != 0 || M != 0){
                if(dp[N+M-1][M] >= K){
                    sb.append("a");
                    N--;
                }else{
                    sb.append("z");
                    K -= dp[N+M-1][M];
                    M--;
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
