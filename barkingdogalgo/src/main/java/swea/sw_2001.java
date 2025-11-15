package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 파리퇴치 - D2
public class sw_2001 {

    static int[][] flies;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            String [] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);

            flies = new int[N][N];

            for(int i = 0; i < N; i++) {
                String [] line = br.readLine().split(" ");
                for(int j = 0; j < N; j++) {
                    flies[i][j] = Integer.parseInt(line[j]);
                }
            }

            long result = killFlies(N, M, flies);
            sb.append("#").append(t+1).append(" ").append(result).append("\n");
        }

        System.out.println(sb);
    }

    private static long killFlies(int n, int m, int[][] flies) {
        long max = 0;

        for(int i = 0; i <= n - m; i++) {
            for(int j = 0; j <= n - m; j++) {
                int nowResult = 0;

                for(int c = i; c < i + m; c++) {
                    for(int r = j; r < j + m; r++) {
                        nowResult += flies[c][r];
                    }
                }

                if(nowResult > max) {
                    max = nowResult;
                }
            }
        }

        return max;
    }
}