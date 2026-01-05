package stduy.week01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 스택
public class BOJ_10828 {
    static class MyStack{
        int [] st;
        int top;

        public MyStack(int size){
            this.st = new int[size];
            this.top = -1;
        }

        public void push(int x){
            st[++top] = x;
        }

        public int pop(){
            if(top == -1){
                return -1;
            }

            return st[top--];
        }

        public int size(){
            return top + 1;
        }

        public int empty(){
            if(top == -1){
                return 1;
            }

            return 0;
        }

        public int top(){
            if(top == -1){
                return -1;
            }

            return st[top];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        MyStack stack = new MyStack(N);
        for (int i = 0; i < N; i++) {
            String []s = br.readLine().split(" ");

            switch(s[0]){
                case "push": stack.push(Integer.parseInt(s[1])); break;
                case "pop": sb.append(stack.pop()).append("\n"); break;
                case "size": sb.append(stack.size()).append("\n"); break;
                case "empty": sb.append(stack.empty()).append("\n"); break;
                case "top": sb.append(stack.top()).append("\n"); break;
            }
        }
        System.out.println(sb);
    }
}
