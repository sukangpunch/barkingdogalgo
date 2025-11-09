package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 괄호의 값
public class b_2504_solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();
        Stack<Character> st = new Stack<>();

        int result = 0;
        int value = 1;

        for(int i = 0; i < N.length(); i++) {
            if(N.charAt(i) == '(') {
                st.push(N.charAt(i));
                value *=2;
            }else if(N.charAt(i) == '[') {
                st.push(N.charAt(i));
                value *= 3;
            }else if(N.charAt(i) == ')') {
                if(st.isEmpty() || st.peek() != '(') {
                    result = 0;
                    break;
                }else if(N.charAt(i-1) == '(') {
                    result += value;
                }
                st.pop();
                value /= 2;
            }else if(N.charAt(i) == ']') {
                if(st.isEmpty() || st.peek() != '[') {
                    result = 0;
                    break;
                }else if(N.charAt(i-1) == '[') {
                    result += value;
                }

                st.pop();
                value /= 3;
            }
        }
        if(!st.isEmpty()) System.out.println(0);
        else System.out.println(result);

        br.close();
    }
}
