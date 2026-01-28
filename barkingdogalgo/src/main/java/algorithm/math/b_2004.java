package algorithm.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 답 보기 : o(질문게시판 해설 봄)
// 메모리 : 14396 kb
// 시간 :  112 ms
public class b_2004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Integer.parseInt(st.nextToken());
        long m = Integer.parseInt(st.nextToken());

        long resultFive = countNum(n,5) - countNum(m,5) - countNum(n-m,5);
        long resultTwo = countNum(n,2) - countNum(m,2) - countNum(n-m,2);

        System.out.println(Math.min(resultFive, resultTwo));
    }

    static long countNum(long num, long divide){
        long result = 0;
        while(num>0){
            result += num/divide;
            num /= divide;
        }
        return result;
    }
}
