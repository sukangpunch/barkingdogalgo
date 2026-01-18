package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

// 로프
public class b_2217_learn {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Integer[] ropes = new Integer[N];
        for (int i = 0; i < N; i++) {
            ropes[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(ropes, Collections.reverseOrder());

        int sum = 0;
        for (int i = 0; i < N; i++) {
            if (sum == 0) {
                sum = ropes[i];
                continue;
            }

            int nowRope = ropes[i];
            int tmp = nowRope * (i + 1);
            if (sum < tmp) {
                sum = tmp;
            }
        }

        System.out.println(sum);

    }
}
