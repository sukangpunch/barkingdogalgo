package data_structure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 괄호의 값
public class b_2504_retry {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        Stack<Character> st = new Stack<>();
        Stack<Long> nums = new Stack<>();

        long result = 0;
        for(int i=0; i<input.length(); i++){
            char c = input.charAt(i);

            if(c=='(' || c == '['){
                st.push(c);
            }

            else if(c==')'){
                if(st.isEmpty()){
                    System.out.println(0);
                    return;
                }

                long num = 0;
                while(!st.isEmpty()){
                    char now = st.peek();
                    if(now == '@'){
                        num += nums.pop();
                        st.pop();
                    }else{
                        break;
                    }
                }

                if(st.isEmpty()){
                    System.out.println(0);
                    return;
                }

                st.pop();
                num = num == 0 ? 2 : num*2;
                nums.push(num);
                st.push('@');
            }

            else if(c==']'){
                if(st.isEmpty()){
                    System.out.println(0);
                    return;
                }

                long num = 0;
                while(!st.isEmpty()){
                    char now = st.peek();
                    if(now == '@'){
                        num += nums.pop();
                        st.pop();
                    }else{
                        break;
                    }
                }

                if(st.isEmpty()){
                    System.out.println(0);
                    return;
                }

                st.pop();
                num = num == 0 ? 3 : num*3;
                nums.push(num);
                st.push('@');
            }
        }

        int size = st.size();
        for(int i=0; i< size; i++){
            char now = st.pop();
            if(now == '@'){
                result += nums.pop();
            }else{
                System.out.println(0);
                return;
            }
        }

        System.out.println(result);
        br.close();
    }

}
