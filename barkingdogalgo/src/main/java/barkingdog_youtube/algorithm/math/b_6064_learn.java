package barkingdog_youtube.algorithm.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 카잉 달력
public class b_6064_learn {

    static int M;
    static int N;
    static int x;
    static int y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t<T; t++){
            String [] s = br.readLine().split(" ");

            M = Integer.parseInt(s[0]);
            N = Integer.parseInt(s[1]);
            x = Integer.parseInt(s[2]);
            y = Integer.parseInt(s[3]);

            int finalDay = calFinalDay(M, N);
            int result = findKaing(finalDay);

            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

    private static int calFinalDay(int a, int b) {
        if(a > b){
            int tmp = a;
            a = b;
            b = tmp;
        }

        return lcm(a,b);
    }

    private static int lcm(int a, int b) {
        return (a / gcd(a,b)) * b;
    }

    private static int gcd(int a, int b) {
        if(a==0) return b;
        return gcd(b%a, a);
    }

    private static int findKaing(int finalDay) {
        if(x==M) x=0;
        if(y==N) y=0;

        for(int i=1; i<=finalDay; i++){
            if(i % M == x && i % N == y){
                return i;
            }
        }

        return -1;
    }

}
