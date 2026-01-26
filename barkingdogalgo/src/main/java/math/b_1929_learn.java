package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_1929_learn {

    static boolean [] primes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String [] s = br.readLine().split(" ");
        int M = Integer.parseInt(s[0]);
        int N = Integer.parseInt(s[1]);

        primes = new boolean[N+1];
        primes[1] = true;

        checkPrime(N);

        for(int i=M; i<=N; i++){
            if(!primes[i]){
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);
    }

    private static void checkPrime(int N) {
        for(int i=2; i * i <= N; i++){
            if(primes[i]) continue;
            for(int j=i*i; j<=N; j += i){
                primes[j] = true;
            }
        }
    }

}
