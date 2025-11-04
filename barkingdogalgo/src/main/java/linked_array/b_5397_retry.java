package linked_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 키로거
public class b_5397_retry {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        for(int i = 0; i < testCase; i++){
            String str = br.readLine();
            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();

            for(int j = 0; j < str.length(); j++){
                char ch = str.charAt(j);
                switch(ch){
                    case '<': if(!left.isEmpty()) right.push(left.pop()); break;
                    case '>': if(!right.isEmpty()) left.push(right.pop()); break;
                    case '-': if(!left.isEmpty()) left.pop(); break;
                    default: left.push(ch); break;
                }
            }

            for(char ch : left){
                sb.append(ch);
            }

            while(!right.isEmpty()){
                sb.append(right.pop());
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
