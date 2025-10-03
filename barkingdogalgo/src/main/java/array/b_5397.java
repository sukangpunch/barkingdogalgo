package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class b_5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();
            for(Character c : input.toCharArray()){
                switch(c){
                    case '<': if(!left.isEmpty()) right.push(left.pop()); break;
                    case '>': if(!right.isEmpty()) left.push(right.pop()); break;
                    case '-': if(!left.isEmpty()) left.pop(); break;
                    default: left.push(c); break;
                }
            }

            StringBuilder sb = new StringBuilder();
            while(!left.isEmpty())right.push(left.pop());
            while(!right.isEmpty())sb.append(right.pop());
            System.out.println(sb);
        }
    }
}
