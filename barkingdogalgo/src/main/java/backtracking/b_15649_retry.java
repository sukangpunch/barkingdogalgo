package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// N과M(1)
public class b_15649_retry {

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

        findSequence(0);

        System.out.println(sb);
    }

    private static void findSequence(int count) {

        if (count == M) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                sb.append(list.get(i)).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= N; i++) {
            if(list.contains(i))continue;
            list.add(i);
            findSequence(count + 1);
            list.remove(list.size() - 1);
        }

    }
}
