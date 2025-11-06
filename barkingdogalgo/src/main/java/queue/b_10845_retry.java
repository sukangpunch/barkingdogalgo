package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// 큐
public class b_10845_retry {
    static class MyQueue{
        ArrayList<Integer> queue = new ArrayList<>();

        void push(int x){
            queue.add(x);
        }

        int pop(){
            if(queue.isEmpty()){
                return -1;
            }
            return queue.remove(0);
        }

        int size(){
            return queue.size();
        }

        int empty(){
            if(queue.isEmpty()){
                return 1;
            }
            return 0;
        }

        int front(){
            if(queue.isEmpty()){
                return -1;
            }
            return queue.get(0);
        }

        int back(){
            if(queue.isEmpty()){
                return -1;
            }
            return queue.get(queue.size()-1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        MyQueue myQueue = new MyQueue();

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            switch(input[0]){
                case "push": myQueue.push(Integer.parseInt(input[1])); break;
                case "pop": sb.append(myQueue.pop()).append('\n'); break;
                case "size": sb.append(myQueue.size()).append('\n'); break;
                case "empty": sb.append(myQueue.empty()).append('\n'); break;
                case "front": sb.append(myQueue.front()).append('\n'); break;
                case "back": sb.append(myQueue.back()).append('\n'); break;
            }
        }

        System.out.println(sb);

    }

}
