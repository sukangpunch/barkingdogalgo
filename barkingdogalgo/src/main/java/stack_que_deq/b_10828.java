package stack_que_deq;

import java.io.*;
import java.util.ArrayList;

public class b_10828 {

    static class MyStack{
        private ArrayList<Integer> stack;

        public MyStack(){
            stack = new ArrayList<>();
        }

        public void push(int x){
            stack.add(x);
        }

        public int pop(){
            if(stack.isEmpty()){
                return -1;
            }
            return stack.remove(stack.size()-1);
        }

        public int size(){
            return stack.size();
        }

        public int top(){
            if(stack.isEmpty()){
                return -1;
            }
            return stack.get(stack.size()-1);
        }

        public int empty(){
            return stack.isEmpty() ? 1 : 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        MyStack stack = new MyStack();

        for(int i=0; i<N; i++){
            String []input = br.readLine().split(" ");
            switch (input[0]){
                case "push": stack.push(Integer.parseInt(input[1])); break;
                case "pop": bw.write(stack.pop() + "\n"); break;
                case "size": bw.write(stack.size() + "\n"); break;
                case "top": bw.write(stack.top() + "\n"); break;
                case "empty": bw.write(stack.empty() + "\n"); break;
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
