package algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int cnt = 0;

        int [] coins = new int[N];

        for(int i=0; i<N; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }

        int idx = N-1;
        while(K != 0 && idx >= 0){
            if(K / coins[idx] != 0){
                cnt += K / coins[idx];
                K = K % coins[idx];
            }
            idx--;
        }
        System.out.println(cnt);
    }
}
