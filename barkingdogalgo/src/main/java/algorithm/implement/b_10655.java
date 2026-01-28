package algorithm.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 마라톤 1
public class b_10655 {

    static int N;
    static int[][] cp;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cp = new int[N][2];

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            cp[i][0] = Integer.parseInt(s[0]);
            cp[i][1] = Integer.parseInt(s[1]);
        }

        int total = 0;
        for (int i = 1; i < N; i++) {
            total += dist(i - 1, i);
        }

        int maxSaved = 0;
        for (int i = 1; i < N - 1; i++) {
            int saved =
                    dist(i - 1, i) + dist(i, i + 1) - dist(i - 1, i + 1);

            maxSaved = Math.max(maxSaved, saved);
        }

        System.out.println(total - maxSaved);
    }

    static int dist(int a, int b) {
        return Math.abs(cp[a][0] - cp[b][0])
                + Math.abs(cp[a][1] - cp[b][1]);
    }
}
