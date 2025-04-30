package Array;

import java.io.*;
import java.util.Stack;

public class b_5397_solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            String line = br.readLine();
            Stack<Character> pwdStack = new Stack<>();
            Stack<Character> deleteStack = new Stack<>();
            for(int j=0; j<line.length(); j++){
                char pos = line.charAt(j);
                if(pos == '<'){
                    if(!pwdStack.isEmpty()) deleteStack.push(pwdStack.pop());
                }else if(pos == '>'){
                    if(!deleteStack.isEmpty()) pwdStack.push(deleteStack.pop());
                }else if(pos == '-'){
                    if(!pwdStack.isEmpty()) pwdStack.pop();
                }else{
                    pwdStack.push(line.charAt(j));
                }
            }

            while(!deleteStack.isEmpty()){
                pwdStack.push(deleteStack.pop());
            }

            // Stack 내부는 Vector 로 구현되어있어 .get() 은 비파괴적 접근이라 원소를 다시 쓸 필요 없이 출력
            for(int k=0; k<pwdStack.size(); k++){
                bw.write(pwdStack.get(k)); // System.out.println() 보다 한번에 BufferedWriter 로 모아서 flush
            } 
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
