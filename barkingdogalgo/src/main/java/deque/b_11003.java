package deque;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// 최솟값 찾기
public class b_11003 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Deque<int[]> dq = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());
            while(!dq.isEmpty() && dq.peekLast()[0] > num) dq.pollLast();

            dq.offer(new int[]{num, i});
            if(dq.peek()[1] < i -(L-1)){
                dq.poll();
            }
            bw.write(dq.peek()[0] + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}