package stack_parentheses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 스택 수열
public class b_1874_retry {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        int top = 0;
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(br.readLine());
            while(true){
                if(stack.isEmpty() || stack.peek() < num){
                    top++;
                    stack.push(top);
                    sb.append('+').append('\n');
                    continue;
                }

                if(stack.peek() == num){
                    stack.pop();
                    sb.append('-').append('\n');
                    break;
                }

                if(stack.peek() > num){
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println(sb);
    }

}
