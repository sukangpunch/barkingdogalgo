package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// N과M(3)
public class b_15651_retry {

    static int N;
    static int M;
    static List<Integer> list;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        list = new ArrayList<>();

        findSequence3(1, 0);

        System.out.println(sb);
    }

    private static void findSequence3(int depth, int count) {
        if (count == M) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                sb.append(list.get(i)).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int j = 1; j <= N; j++) {
            list.add(j);
            findSequence3(depth + 1, count + 1);
            list.remove(list.size() - 1);
        }
    }

}
