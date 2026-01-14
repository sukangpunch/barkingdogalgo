package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_9663_learn {

    static int N;
    static boolean [] isused1;
    static boolean [] isused2;
    static boolean [] isused3;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        isused1 = new boolean[N];
        isused2 = new boolean[2*N - 1];
        isused3 = new boolean[2*N - 1];

        backtrack(0);
        System.out.println(result);
    }

    // isused1 은 열을 나타낸다.(N)
    // isused2 은 오른쪽 위 - 왼 아래 방향 대각선을 뜻한다 (2N - 1)
    // isused3 은 왼쪽 위 - 오른쪽 아래 방향 대각선을 뜻한다 (2N - 1)
    private static void backtrack(int depth) {
        if(depth == N){
            result += 1;
            return;
        }

        // 오위-왼아 대각선은 i(col) + depth(row) -> (1,0), (0,1) 이나 (2,0),(1,1),(0,2) 와 같은 모양
        // 왼위-오아 대각선은 depth(row) - i(col) + N - 1 -> (2,0), (3,1) 이나 (0,2), (1,3) 와 같은 모양 음수(col이 row보다 크면 음수) 를 막기 위해 N-1 을 더한다
        for(int i=0; i<N; i++){
            if(isused1[i] || isused2[i+depth] || isused3[depth-i+N-1])
                continue;

            isused1[i] = true;
            isused2[i+depth] = true;
            isused3[depth-i+N-1] = true;
            backtrack(depth+1);
            isused1[i] = false;
            isused2[i+depth] = false;
            isused3[depth-i+N-1] = false;
        }
    }
}
