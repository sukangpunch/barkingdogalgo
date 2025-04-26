package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class b_1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().strip();
        int N = Integer.parseInt(br.readLine());

        Stack<Character> stackL = new Stack<>();
        Stack<Character> stackR = new Stack<>();

        for(int i=0; i<input.length(); i++){
            stackL.add(input.charAt(i));
        }


        for(int i = 0; i < N; i++) {
            String []command = br.readLine().split(" ");

            switch(command[0]) {
                case "P" : stackL.push(command[1].charAt(0)); break;
                case "B" : if(!stackL.isEmpty())stackL.pop(); break;
                case "L" : if(!stackL.isEmpty())stackR.push(stackL.pop()); break;
                case "D" : if(!stackR.isEmpty())stackL.push(stackR.pop()); break;
            }
        }

        StringBuilder sb = new StringBuilder(); // 이거 차이로 갈렸다.

        for(char c : stackL){
            sb.append(c);
        }

        while(!stackR.isEmpty()){
            sb.append(stackR.pop());
        }

        System.out.println(sb);
    }
}
