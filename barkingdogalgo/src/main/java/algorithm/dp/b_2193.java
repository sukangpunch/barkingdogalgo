package algorithm.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_2193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if(N == 1){
            System.out.println("1");
            return;
        }

        long [] arr = new long[N+1];

        arr[1] = 1;
        arr[2] = 1;

        for (int i = 3; i <= N; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }

        System.out.println(arr[N]);
    }
}

