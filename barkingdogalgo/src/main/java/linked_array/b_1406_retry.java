package linked_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 에디터
public class b_1406_retry {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        for(int i=0; i<str.length(); i++){
            left.push(str.charAt(i));
        }

        int M = Integer.parseInt(br.readLine());

        for(int i = 0; i < M; i++){
            String[] input = br.readLine().split(" ");

            switch(input[0]){
                case "L": if(!left.isEmpty()) right.push(left.pop()); break;
                case "D": if(!right.isEmpty()) left.push(right.pop()); break;
                case "B": if(!left.isEmpty()) left.pop(); break;
                case "P": left.push(input[1].charAt(0)); break;
            }
        }

        for(char word : left){
            sb.append(word);
        }

        while(!right.isEmpty()){
            sb.append(right.pop());
        }

        System.out.println(sb);
    }

}
