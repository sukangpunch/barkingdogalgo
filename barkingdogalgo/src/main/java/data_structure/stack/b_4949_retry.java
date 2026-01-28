package data_structure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 균형잡힌 세상
public class b_4949_retry {

    static Stack<Character> st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String line;
        while(true){
            st = new Stack<>();
            line = br.readLine();
            if(line.equals("."))break;

            line = line.substring(0, line.length()-1);

            sb.append(isIsBalanced(line, st)).append("\n");
        }

        System.out.println(sb);
    }

    private static String isIsBalanced(String line, Stack<Character> st) {
        for(int i=0; i< line.length(); i++){
            if(line.charAt(i) == '(' || line.charAt(i) == '['){
                st.push(line.charAt(i));
            }

            else if (line.charAt(i) == ')'){
                if(!st.isEmpty() && st.peek() == '('){
                    st.pop();
                }else{
                    return "no";
                }
            }

            else if(line.charAt(i) == ']'){
                if(!st.isEmpty() && st.peek() == '['){
                    st.pop();
                }else{
                    return "no";
                }
            }
        }

        return st.isEmpty() ? "yes" : "no";
    }
}
