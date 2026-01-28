package algorithm.dp;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 답 보기 : o (질문게시판 확인)
// 메모리 : 14576 kb
// 시간 : 120 ms
public class b_1149 {
    static int [][] map;
    static int [][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        map = new int[N][3];
        dp = new int[N][3];
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] =  map[0][0];
        dp[0][1] =  map[0][1];
        dp[0][2] =  map[0][2];

        for(int i=1;i<N;i++){
            for(int j=0;j<3;j++){
                int min = Integer.MAX_VALUE;
                for(int k=0;k<3;k++){
                    if(j == k)continue;
                    if(min > dp[i-1][k])min = dp[i-1][k];
                }
                dp[i][j] = map[i][j] + min;
            }
        }

        int min = Integer.MAX_VALUE;

        for(int i=0; i<3; i++){
            if(dp[N-1][i] < min)min = dp[N-1][i];
        }

        System.out.println(min);
        br.close();
    }
}

