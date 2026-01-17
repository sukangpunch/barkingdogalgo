package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_11659_learn {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String [] s = br.readLine().split(" ");

        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        int [] sum = new int[N+1];
        s = br.readLine().split(" ");

        for(int i =1; i<=N; i++){
            int num = Integer.parseInt(s[i-1]);
            sum[i] = sum[i-1] + num;
        }

        for(int i = 0; i < M; i++){
            s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);

            int result = sum[end] - sum[start-1];
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

}
