package algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 답 보기 : o(질문게시판)
// 메모리 : 25344 kb
// 시간 :  292 ms
public class b_16120 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Stack<Character> stack = new Stack<>();

        boolean flag = false;
        for(int i=0; i<input.length(); i++) {
            if(input.charAt(i) == 'P') {
                stack.push(input.charAt(i));
            }else{
                if(stack.isEmpty()){
                    flag = true;
                    break;
                }
                i++;
                if(i == input.length() || input.charAt(i) != 'P'){
                    flag = true;
                    break;
                }
                stack.pop();
            }

            if(stack.isEmpty()){
                flag=true;
                break;
            }
        }
        if(stack.size() >1){
            flag = true;
        }

        if(!flag){
            System.out.println("PPAP");
        }else{
            System.out.println("NP");
        }
    }
}
