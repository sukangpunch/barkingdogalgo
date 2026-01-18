package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

// 동전 0
public class b_11047_learn {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String []s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);

        Integer [] coins = new Integer[N];

        for(int i=0; i<N; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(coins, Collections.reverseOrder());

        int count = 0;
        for(int i=0; i<N; i++){
            int cnt = K / coins[i];
            K = K % coins[i];
            count += cnt;
        }

        System.out.println(count);
    }

}
