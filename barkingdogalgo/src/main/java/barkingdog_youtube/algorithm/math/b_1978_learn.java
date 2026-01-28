package barkingdog_youtube.algorithm.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_1978_learn {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String [] s = br.readLine().split(" ");
        int cnt = 0;
        for(int i=0; i<N; i++){
            int num =  Integer.parseInt(s[i]);
            if(checkPrimeNum(num)){
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    private static boolean checkPrimeNum(int num) {
        if(num <= 1){
            return false;
        }

        for(int i=2; i*i <= num; i++){
            if(num % i == 0)return false;
        }

        return true;
    }
}
