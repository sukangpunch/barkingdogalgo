package algorithm.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 답 보기 : o(gpt 활용)
// 메모리 : 14144 kb
// 시간 : 104ms
public class b_1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        System.out.println(square(A, B, C));
    }

    static int square(int target, int cnt, int divide) {
        if(cnt == 1){
            return target % divide;
        }

        int half = square(target, cnt/2, divide);
        long result = (1L * half * half) % divide;

        if(cnt % 2 == 1){
            result = (result * target) % divide;
        }

        return (int)result;
    }
}
