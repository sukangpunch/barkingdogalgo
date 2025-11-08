package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 쇠막대기
public class b_10799_retry {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        Stack<Character> stack = new Stack<>();

        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == '(') {
                stack.push(input.charAt(i));
                continue;
            }

            if(input.charAt(i) == ')') {
                stack.pop();

                if(input.charAt(i-1) == '(') {
                    count += stack.size();
                }else{
                    count++;
                }

            }
        }

        System.out.println(count);
    }

}
