package stduy.week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 줄 서는 방법
public class pgs_12936_solution {

    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long K = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(i + 1);
        }

        int[] result = solution(N, K); // 인덱스 접근을 위해 k-1
        System.out.println(Arrays.toString(result));
    }

    public static int[] solution(int N, long K) {
        int[] answer = new int[N];

        int idx = 0;
        int n = N;
        long k = K-1;

        while (idx < N) {
            long fact = fact(n - 1);
            long range = k / fact;
            answer[idx] = list.remove((int) range);
            n -= 1;
            k -= fact * range;
            idx++;
        }

        return answer;
    }

    private static long fact(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
