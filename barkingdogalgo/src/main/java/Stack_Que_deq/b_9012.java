package Stack_Que_deq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class b_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            boolean check = true;
            Stack<Character> st = new Stack<>();

            String s = br.readLine();
            for(int j = 0; j < s.length(); j++){
                char c = s.charAt(j);
                if(c == '('){
                    st.push(c);
                }else if(c == ')'){
                    if(st.isEmpty() || st.peek() != '('){
                        check = false;
                        break;
                    }else if(st.peek() == '('){
                        st.pop();
                    }
                }
            }
            if(!st.isEmpty()){check = false;}

            sb.append(check ? "YES" : "NO").append("\n");
        }
        System.out.println(sb);
    }
}
