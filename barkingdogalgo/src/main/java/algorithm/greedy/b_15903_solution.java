package algorithm.greedy;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class b_15903_solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            pq.offer(Long.parseLong(st.nextToken()));
        }

        for(int i=0; i<m; i++){
            long sum = pq.poll() + pq.poll();
            pq.offer(sum);
            pq.offer(sum);
        }

        long result = 0;
        while(!pq.isEmpty()){
            result += pq.poll();
        }

        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
