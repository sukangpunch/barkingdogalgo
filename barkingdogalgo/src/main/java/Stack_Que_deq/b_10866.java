package Stack_Que_deq;

import java.io.*;
import java.util.ArrayList;

public class b_10866 {

    static class MyDeque{
        private ArrayList<Integer> deque;

        public MyDeque(){
            deque = new ArrayList<>();
        }

        public void push_front(int x){
            deque.add(0,x);
        }

        public void push_back(int x){
            deque.add(x);
        }

        public int pop_front(){
            if(deque.isEmpty()) return -1;
            return deque.remove(0);
        }

        public int pop_back(){
            if(deque.isEmpty()) return -1;
            return deque.remove(deque.size()-1);
        }

        public int size(){
            return deque.size();
        }

        public int empty(){
            return deque.isEmpty() ? 1 : 0;
        }

        public int front(){
            return deque.isEmpty() ? -1 : deque.get(0);
        }

        public int back(){
            return deque.isEmpty() ? -1 : deque.get(deque.size()-1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        MyDeque myDeque = new MyDeque();

        for(int i = 0; i < N; i++){
            String []s = br.readLine().split(" ");
            switch (s[0]){
                case "push_front": myDeque.push_front(Integer.parseInt(s[1])); break;
                case "push_back": myDeque.push_back(Integer.parseInt(s[1])); break;
                case "pop_front": bw.write(myDeque.pop_front() + "\n"); break;
                case "pop_back": bw.write(myDeque.pop_back() + "\n"); break;
                case "size": bw.write(myDeque.size() + "\n"); break;
                case "empty": bw.write(myDeque.empty() + "\n"); break;
                case "front": bw.write(myDeque.front() + "\n"); break;
                case "back": bw.write(myDeque.back() + "\n"); break;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
