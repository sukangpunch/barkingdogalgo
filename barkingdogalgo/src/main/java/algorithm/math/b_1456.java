package algorithm.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 답 보기 : o(답 봄)
// 메모리 : 43940 kb
// 시간 :  276 ms
public class b_1456 {

    static ArrayList<Integer> primes = new ArrayList<>();
    static boolean []isPrime;
    static long count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int last = (int) Math.sqrt(B);
        isPrime = new boolean[last+1];

        for(int i=2; i<=last; i++){
            if(!isPrime[i]){
                primes.add(i);
                for(int j=i*2; j<=last; j += i){
                    isPrime[j] = true;
                }
            }
        }

        for(int p : primes){
            long ap = (long) p*p;
            while(ap <= B){
                if(ap >= A) count++;
                if(ap > Long.MAX_VALUE/p)break;
                ap *= p;
            }
        }
        System.out.println(count);
    }

}
