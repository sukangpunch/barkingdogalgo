package it_company_work_book.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 주식
// 그리디
/**
 * 그리디 문제이다.
 * 역순 배열로 해결 가능, max값을 업그레이드 해 가면서 max보다 작은 값들이라면 max-현재값 을 result에 더하고,
 * max 보다 크거나 깉은 값이라면, max = 현재값 으로 업데이트 하면 해결
 */
public class BOJ_11501 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine());
            String []s = br.readLine().split(" ");
            int []stocks = new int[N];
            for(int i=0; i<N; i++){
                stocks[i] = Integer.parseInt(s[i]);
            }

            long result = 0;
            int max = stocks[N-1];
            for(int i=N-2; i>=0; i--){
                if(max <= stocks[i]){
                    max = stocks[i];
                }else{
                    result += max - stocks[i];
                }
            }

            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
