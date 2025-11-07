package deque;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

// 덱
public class b_10866 {
    static class MyDeque{
        Deque<Integer> deque = new LinkedList<>();

        void pushFront(int x) {
            deque.addFirst(x);
        }

        void pushBack(int x) {
            deque.addLast(x);
        }

        int popFront() {
            if(deque.isEmpty()) return -1;
            return deque.removeFirst();
        }

        int popBack() {
            if(deque.isEmpty()) return -1;
            return deque.removeLast();
        }

        int size() {
            return deque.size();
        }

        int empty() {
            if(deque.isEmpty()) return 1;
            return 0;
        }

        int front(){
            if(deque.isEmpty()) return -1;
            return deque.getFirst();
        }

        int back(){
            if(deque.isEmpty()) return -1;
            return deque.getLast();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        MyDeque myQueue = new MyDeque();

        for(int i = 0; i < n; i++){
            String[] input = br.readLine().split(" ");
            switch(input[0]){
                case "push_front": myQueue.pushFront(Integer.parseInt(input[1])); break;
                case "push_back": myQueue.pushBack(Integer.parseInt(input[1])); break;
                case "front": sb.append(myQueue.front()).append("\n"); break;
                case "back": sb.append(myQueue.back()).append("\n"); break;
                case "pop_front": sb.append(myQueue.popFront()).append("\n"); break;
                case "pop_back": sb.append(myQueue.popBack()).append("\n"); break;
                case "size": sb.append(myQueue.size()).append("\n"); break;
                case "empty": sb.append(myQueue.empty()).append("\n"); break;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
