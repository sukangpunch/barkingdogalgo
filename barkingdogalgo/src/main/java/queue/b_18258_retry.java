package queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

// 큐2
public class b_18258_retry {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            switch(input[0]){
                case "push": dq.add(Integer.parseInt(input[1]));break;
                case "pop": sb.append(myPop(dq)).append('\n'); break;
                case "size": sb.append(dq.size()).append('\n'); break;
                case "empty": sb.append(myEmpty(dq)).append('\n'); break;
                case "front": sb.append(myFront(dq)).append('\n'); break;
                case "back": sb.append(myBack(dq)).append('\n'); break;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int myBack(Deque<Integer> dq) {
        if(dq.isEmpty()) return -1;
        return dq.getLast();
    }

    private static int myFront(Deque<Integer> dq) {
        if(dq.isEmpty()) return -1;
        return dq.getFirst();
    }

    private static int myEmpty(Deque<Integer> dq) {
        if(dq.isEmpty()){
            return 1;
        }
        return 0;
    }

    private static int myPop(Deque<Integer> dq) {
        if(dq.isEmpty()) return -1;
        return dq.poll();
    }
}
