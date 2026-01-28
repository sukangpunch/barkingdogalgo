package algorithm.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 괄호의 값
public class b_2504 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] parent = br.readLine().toCharArray();
        Stack<Character> st = new Stack<>();
        int temp = 1;
        int result = 0;
        int size = parent.length;

        for(int i=0; i<size; i++){
            char now = parent[i];

            if(now == '(' || now == '['){
                st.push(now);
                temp *= now=='(' ? 2 : 3;
            }
            else if(now == ')'){
                if(st.empty() || st.peek() != '('){
                    result = 0;
                    break;
                }

                if(parent[i-1] == '('){
                    result += temp;
                }
                temp /=2;
                st.pop();
            }
            else if(now == ']'){
                if(st.empty() || st.peek() != '['){
                    result = 0;
                    break;
                }

                if(parent[i-1] == '['){
                    result += temp;
                }
                temp /=3;
                st.pop();
            }
        }
        if(!st.empty()){
            result = 0;
        }

        System.out.println(result);
    }
}
