package stack_que_deq;

import java.io.*;
import java.util.ArrayList;

public class b_10845 {

    static class MyQueue{

        ArrayList<Integer> queue;

        public MyQueue(){
            queue = new ArrayList<>();
        }

        public void push(int x){
            queue.add(x);
        }

        public int pop(){
            if(queue.isEmpty()){
                return -1;
            }
            return queue.remove(0);
        }

        public int size(){
            return queue.size();
        }

        public int empty(){
            return queue.isEmpty() ? 1 : 0;
        }

        public int front(){
            if(queue.isEmpty()){
                return -1;
            }
            return queue.get(0);
        }

        public int back(){
            if(queue.isEmpty()){
                return -1;
            }
            return queue.get(queue.size()-1);
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        MyQueue queue = new MyQueue();

        for(int i = 0; i < N; i++){
            String[] s = br.readLine().split(" ");

            switch (s[0]){
                case "push": queue.push(Integer.parseInt(s[1])); break;
                case "pop": bw.write(queue.pop() + "\n"); break;
                case "size": bw.write(queue.size() + "\n"); break;
                case "empty": bw.write(queue.empty() + "\n"); break;
                case "front": bw.write(queue.front() + "\n"); break;
                case "back": bw.write(queue.back() + "\n"); break;
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
