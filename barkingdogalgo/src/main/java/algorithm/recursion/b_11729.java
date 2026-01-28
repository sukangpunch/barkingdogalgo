package algorithm.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 답 보기 : o(블로그)
// 메모리 : 80128 kb
// 시간 : 560 ms
public class b_11729 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        sb.append((int) (Math.pow(2,N) -1)).append("\n");
        hanoi(N, 1,2,3);
        System.out.println(sb);
    }

    static void hanoi(int N, int start, int mid, int to) {
        // 이동할 원반의 수가 1개라면?
        if(N == 1){
            sb.append(start + " " + to).append("\n");
            return;
        }

        // A -> C 로 옮긴다고 가정할 때,
        // STEP 1 : N-1 개를 A에서 B로 이동 (= start 지점의 N-1개의 원판을 mid 지점으로 옮긴다.)
        hanoi(N-1, start, to, mid);

        // STEP 2: 1개를 A에서 C로 이동 (= start 지점의 N번째 원판을 to 지점으로 옮긴다.)
        sb.append(start + " " + to).append("\n");

        // STEP 3: N-1 개를 B에서 C로 이동 (= mid 지점의 N-1개의 원판을 to 지점으로 옮긴다.)
        hanoi(N-1, mid, start, to);
    }
}
