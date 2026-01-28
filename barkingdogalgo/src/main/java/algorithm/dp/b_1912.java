package algorithm.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 답 보기 : x
// 메모리 : 24052 kb
// 시간 : 232 ms
public class b_1912 {
    static int [] sequence;
    static int [] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        sequence = new int[N];
        dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = sequence[0];

        for(int i=1; i<N; i++) {
            dp[i] = Math.max(sequence[i], dp[i-1] + sequence[i]);
        }

        int max = dp[0];
        for(int i=1; i<N; i++) {
            if(dp[i] > max) {
                max = dp[i];
            }
        }

        System.out.println(max);
    }
}

