package algorithm.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 연속합
public class b_1912_retry {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String [] s = br.readLine().split(" ");

        int [] arr = new int[N];
        int [] dp = new int[N];

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(s[i]);
        }

        dp[0] = arr[0];

        for(int i=1;i<N;i++){
            if(arr[i] < dp[i-1] + arr[i]){
                dp[i] = dp[i-1] + arr[i];
            }else{
                dp[i] = arr[i];
            }
        }

        Arrays.sort(dp);
        System.out.println(dp[N-1]);
    }

}
