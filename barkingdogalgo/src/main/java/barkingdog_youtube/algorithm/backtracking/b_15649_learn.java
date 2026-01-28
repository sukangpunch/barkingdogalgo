package barkingdog_youtube.algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// N과 M(1)
public class b_15649_learn {

    static int N;
    static int M;
    static List<Integer> tmp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        tmp = new ArrayList<>();
        backtrack(0);

        System.out.println(sb);
    }

    private static void backtrack(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(tmp.get(i)).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if(tmp.contains(i))continue;
            tmp.add(i);
            backtrack(depth + 1);
            tmp.remove(tmp.size() - 1);

        }
    }
}
