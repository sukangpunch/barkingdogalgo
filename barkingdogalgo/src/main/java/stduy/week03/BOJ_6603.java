package stduy.week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 로또
public class BOJ_6603 {

    static StringBuilder sb = new StringBuilder();
    static List<Integer> list;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] s = br.readLine().split(" ");
            int K = Integer.parseInt(s[0]);
            if (K == 0) {
                break;
            }
            arr = new int[K];
            list = new ArrayList<>();

            for (int i = 0; i < K; i++) {
                arr[i] = Integer.parseInt(s[i + 1]);
            }

            backtrack(0, 0, K);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void backtrack(int depth, int start, int K) {
        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(list.get(i)).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < K; i++) {
            list.add(arr[i]);
            backtrack(depth + 1, i + 1, K);
            list.remove(list.size() - 1);
        }
    }
}
