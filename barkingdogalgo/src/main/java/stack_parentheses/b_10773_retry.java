package stack_parentheses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 제로
public class b_10773_retry {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < K; i++) {
            int num = Integer.parseInt(br.readLine());

            if(num == 0 && !stack.isEmpty()) {
                stack.pop();
                continue;
            }

            stack.push(num);
        }

        int count = 0;
        for(int num : stack) {
            count += num;
        }

        System.out.println(count);
    }
}
