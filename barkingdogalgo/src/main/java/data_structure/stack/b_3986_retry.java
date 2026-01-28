package data_structure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 좋은 단어
public class b_3986_retry {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int count=0;
        for(int i=0; i < N; i++){
            Stack<Character> stack = new Stack<>();
            String input = br.readLine();

            for(int j=0; j < input.length(); j++){
                if(stack.isEmpty()){
                    stack.push(input.charAt(j));
                    continue;
                }

                if(stack.peek() == input.charAt(j)){
                    stack.pop();
                    continue;
                }

                if(stack.peek() != input.charAt(j)){
                    stack.push(input.charAt(j));
                }
            }

            if(stack.isEmpty()){
                count++;
            }
        }
        System.out.println(count);
    }
}
