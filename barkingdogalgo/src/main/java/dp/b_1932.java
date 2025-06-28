package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 답 보기 : x
// 메모리 : 30136 kb
// 시간 : 272 ms
public class b_1932 {
    static int [][]triangle;
    static int [][]dp;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        triangle = new int[N][N];
        dp = new int[N][N];

        for(int i=0; i<N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < line.length; j++) {
                triangle[i][j] = Integer.parseInt(line[j]);
            }
        }

        dp[0][0] = triangle[0][0];

        for(int i=1; i<N; i++){
            for(int j=0; j<=i; j++){
                if(j==0){
                    dp[i][j] = triangle[i][j] + dp[i-1][j];
                }else if(j==i){
                    dp[i][j] = triangle[i][j] + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(triangle[i][j] + dp[i-1][j-1], triangle[i][j] + dp[i-1][j]);
                }
            }
        }

        int max=0;
        for(int i=0; i<N; i++){
            if(max < dp[N-1][i]){
                max = dp[N-1][i];
            }
        }

        System.out.println(max);
    }
}
