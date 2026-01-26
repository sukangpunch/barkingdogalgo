package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 소인수 분해
public class b_11653_learn {

    static StringBuilder sb = new StringBuilder();
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        findSoinsu();

        System.out.println(sb);
    }

    private static void findSoinsu() {
        for (int i = 2; i * i <= N; i++) {
            while (N % i == 0) {
                sb.append(i).append("\n");
                N /= i;
            }
        }

        if (N != 1) {
            sb.append(N);
        }
    }
}
