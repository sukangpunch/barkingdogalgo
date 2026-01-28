package data_structure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 괄호
public class b_9012_retry {

    static Stack<Character> st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            st = new Stack<>();

            String input = br.readLine();

            String result = test(input);
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

    private static String test(String input) {
        for(int j = 0; j < input.length(); j++) {
            if(input.charAt(j) == '(') {
                st.push(input.charAt(j));
                continue;
            }

            if(input.charAt(j) == ')') {
                if(st.isEmpty() || st.peek() != '(') {
                    return "NO";
                }
                st.pop();
            }
        }

        return st.isEmpty() ? "YES" : "NO";
    }
}
