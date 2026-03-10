package it_company_work_book.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1,2,3 더하기 4
// dp
/**
 * 사용할 수 있는 수는 1,2,3 이다.
 * 그리고 4를 만들기 위해선 1111, 211,22, 31 등이 가능(순서x)
 * 1만 사용했을 때는 4까지 1개의 경우의 수, 1(미리 구해놈)과 2를 사용할때는 2가지 경우의 수,
 * 1(미리 구해놈),2(미리 구해놈), 3을 쓸때는 1가지 경우의 수로 총 4가지 경우의 수가 나온다.
 */
public class BOJ_15989 {

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine());
            int [] dp = new int[N+1];
            dp[0] = 1;
            for(int i=1; i<=3; i++){
                for(int j=1; j<=N; j++){
                    if(j>=i){
                        dp[j] += dp[j-i];
                    }
                }
            }
            sb.append(dp[N]).append("\n");
        }

        System.out.println(sb);
    }
}
