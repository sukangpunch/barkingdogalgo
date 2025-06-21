package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 답 보기 : x
// 메모리 : 14076 kb
// 시간 : 104 ms
public class b_1003 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0) {
                sb.append(1).append(" ").append(0).append("\n"); continue;
            }else if(num==1){
                sb.append(0).append(" ").append(1).append("\n"); continue;
            }

            int [][]dp = new int[num+1][2];
            dp[0][0] = 1; dp[0][1] = 0;
            dp[1][0] = 0; dp[1][1] = 1;

            for(int j=2; j<=num;j++){
                dp[j][0] = dp[j-1][0] + dp[j-2][0];
                dp[j][1] = dp[j-1][1] + dp[j-2][1];
            }
            sb.append(dp[num][0]).append(" ").append(dp[num][1]).append("\n");
        }

        System.out.println(sb);

    }
}
