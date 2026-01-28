package barkingdog_youtube.algorithm.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 부분합
public class b_1806_learn {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        s = br.readLine().split(" ");
        long []arr = new long[N+1];

        arr[0] = 0;
        arr[1] = Integer.parseInt(s[0]);

        for(int i=2; i<=N; i++){
            arr[i] = Integer.parseInt(s[i-1]) + arr[i-1]; // 누적합으로 arr[i] - arr[j] 를 통해 j~i 사이의 합을 구할 수 있다.
        }

        int st = 0;
        int en = 1;
        int min = Integer.MAX_VALUE;
        
        while(true){
            if(arr[en] - arr[st] >= M){
                min = Math.min(min, en - st);
                st++;
            }else{
                en++;
            }

            if(st >= en || en > N){
                break;
            }
        }

        if(min == Integer.MAX_VALUE){
            System.out.println(0);
        }else{
            System.out.println(min);
        }

    }
}
