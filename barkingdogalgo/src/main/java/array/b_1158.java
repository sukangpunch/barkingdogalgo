package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> dq = new ArrayDeque<>();

        for(int i=1; i<= N; i++){
            dq.add(i);
        }

        sb.append("<");
        do {
            for (int i = 1; i < K; i++) {
                dq.offer(dq.poll());
            }
            if(dq.size() == 1)sb.append(dq.poll());
            else sb.append(dq.poll()).append(", ");
        } while (!dq.isEmpty());

        sb.append(">");
        System.out.println(sb);
    }
}
