package study.week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 목장 건설하기
public class BOJ_14925 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String []s = br.readLine().split(" ");

        int M = Integer.parseInt(s[0]);
        int N = Integer.parseInt(s[1]);

        int [][]map = new int[M][N];
        int [][]dp = new int[M][N];

        for(int i=0; i<M; i++){
            s = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        for(int i=0; i<M; i++){
            dp[i][0] = map[i][0] == 0 ? 1 : 0;
        }

        for(int i=0; i<N; i++){
            dp[0][i] = map[0][i] == 0 ? 1 : 0;
        }

        for(int i=1; i<M; i++){
            for (int j=1; j<N; j++){
                if(map[i][j] != 0){
                    continue;
                }

                int tmpMin = Math.min(dp[i][j-1], dp[i-1][j-1]);
                int min = Math.min(dp[i-1][j], tmpMin);
                dp[i][j] = min + 1;
            }
        }

        int max = 0;

        for(int i=0; i<M; i++){
            for (int j=0; j<N; j++){
                if(max < dp[i][j]){
                    max = dp[i][j];
                }
            }
        }

        System.out.println(max);
    }
}
