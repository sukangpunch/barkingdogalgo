package algorithm.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 소수 구하기
public class b_1929 {

    static boolean [] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String [] s = br.readLine().split(" ");

        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        arr = new boolean[M+1];
        for(int i = N; i <= M; i++){
            arr[i] = findPrimeNumber(i);
        }

        for(int i=N; i<=M; i++){
            if (arr[i]){
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static boolean findPrimeNumber(int target) {
        if(target == 1){
            return false;
        }

        for(int i = 2; i<= Math.sqrt(target); i++){
            if(target % i == 0){
                return false;
            }
        }
        return true;
    }

}
