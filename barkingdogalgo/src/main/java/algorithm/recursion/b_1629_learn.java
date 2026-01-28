package algorithm.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 곰셈
public class b_1629_learn {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String []s = br.readLine().split(" ");

        int A = Integer.parseInt(s[0]);
        int B = Integer.parseInt(s[1]);
        int C = Integer.parseInt(s[2]);

        long l = recursionPower(A, B, C);
        System.out.println(l);
    }

    // a^b = a^(b/2) * a^(b/2) 임을 이용하여, N 번 곱해야 하는 연산을, logN 번으로 줄임
    // 즉, 이전에 구한 2^1 값을 2^2 에서 활용하여 2^2에서 구한 값을 2^5 에서 활용하는 방식
    private static long recursionPower(int a, int b, int c) {
        if(b==1) return a % c;
        long val = recursionPower(a, b/2, c);
        val = val * val % c;

        if(b%2 == 0) return val;
        return val * a % c;
    }
}
