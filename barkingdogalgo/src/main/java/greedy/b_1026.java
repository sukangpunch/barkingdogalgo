package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b_1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int [] A = Arrays.stream(br.readLine().trim().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int [] B = Arrays.stream(br.readLine().trim().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        Arrays.sort(A);
        Arrays.sort(B);

        int minCount = 0;
        int endIdx = N-1;

        for(int i = 0; i < N; i++) {
            minCount += A[i] * B[endIdx];
            endIdx--;
        }

        System.out.println(minCount);
    }
}
