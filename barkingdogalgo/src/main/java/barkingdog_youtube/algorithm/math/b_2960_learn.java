package barkingdog_youtube.algorithm.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_2960_learn {

    static boolean[] arr;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);

        arr = new boolean[N+1];
        arr[1] = true;
        checkPrimeNums(N, K);

        System.out.println(result);
    }

    private static void checkPrimeNums(int N, int K) {
        int cnt = 0;
        for(int i = 2; i<=N; i++){
            if(arr[i]) continue;
            for(int j = i; j<=N; j += i){ // 실제로 i*i 로 초기화 해도 에라토스테네스 체 구현은 가능, 하지만 현 문제에선 불가능.
                if(!arr[j]){
                    arr[j] = true;
                    cnt++;
                    if(cnt == K){
                        result = j;
                        return;
                    }
                }
            }
        }
    }
}
