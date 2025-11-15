package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 파리 퇴치
// 누적합 사용
public class sw_2001_solution {

    static int[][] flies;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String [] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);

            flies = new int[N+1][N+1];

            for(int i = 1; i <= N; i++) {
                String [] line = br.readLine().split(" ");
                for(int j = 1; j <= N; j++) {
                    flies[i][j] = Integer.parseInt(line[j-1]);
                }
            }

            int result = killFilesByPrefix(N, M, flies);
            sb.append("#").append(t+1).append(" ").append(result).append("\n");
        }

        System.out.println(sb);
    }

    private static int killFilesByPrefix(int n, int m, int[][] flies) {
        int [][] prefix = new int[n+1][n+1];
        for(int i=1; i <= n; i++) {
            for(int j=1; j <= n; j++) {
                prefix[i][j] = flies[i][j] + prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1];
            }
        }

        int max = 0;
        for(int i=0; i < n - m + 1; i++) {
            for(int j=0; j < n - m + 1; j++) {
                int sum = prefix[i+m][j+m] - prefix[i][j+m] - prefix[i+m][j] + prefix[i][j];
                if(sum > max) {
                    max = sum;
                }
            }
        }

        return max;
    }

}
