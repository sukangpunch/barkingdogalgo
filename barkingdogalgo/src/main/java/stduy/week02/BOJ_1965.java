package stduy.week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 상자 넣기
// 알고리즘 종류 확인
public class BOJ_1965 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int [] arr = new int[N+1];
        String [] s = br.readLine().split(" ");
        int [] dp = new int[N+1];

        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(s[i-1]);
            dp[i] = 1;
        }

        for(int i=2; i<=N; i++){
            for(int j=1; j<i; j++){
                if(arr[i] > arr[j]){
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
        }

        int max = 0;
        for(int i=1; i<=N; i++){
            if(max < dp[i]){
                max = dp[i];
            }
        }

        System.out.println(max);
    }
}
