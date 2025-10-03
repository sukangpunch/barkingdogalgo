package stack_que_deq;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 이게 더 느린데?
public class b_1021_solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        LinkedList<Integer> deque = new LinkedList<>();
        for(int i=1; i<=N; i++){
            deque.offer(i);
        }

        st=  new StringTokenizer(br.readLine());
        int count = 0;
        while(M-- > 0){
            int num = Integer.parseInt(st.nextToken());
            int idx = deque.indexOf(num);
            int mid = deque.size()/2;
            if(idx <= mid){
                while(num != deque.peek()){
                    deque.offerLast(deque.pollFirst());
                    count++;
                }
            }else{
                while(num != deque.peek()){
                    deque.offerFirst(deque.pollLast());
                    count++;
                }
            }
            deque.remove();
        }
        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
