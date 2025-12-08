package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 수 정렬하기 2
public class b_2751 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0 ; i < N ; i++){
            int num = Integer.parseInt(br.readLine());
            pq.add(num);
        }

        for(int i = 0 ; i < N ; i++){
            sb.append(pq.poll()).append("\n");
        }

        System.out.println(sb);

    }
}
