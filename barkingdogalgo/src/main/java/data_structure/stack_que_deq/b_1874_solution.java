package data_structure.stack_que_deq;

import java.io.*;
import java.util.Stack;

public class b_1874_solution {
    static Stack<Integer> st = new Stack<>();
    static int tmp = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int C = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<C; i++){
            int N = Integer.parseInt(br.readLine());
            for(;tmp <= N; tmp++){
                st.push(tmp);
                sb.append("+\n");
            }
            if(st.peek() == N){
                st.pop();
                sb.append("-\n");
            }else{
                System.out.print("NO");
                return;
            }
        }
        System.out.println(sb);
    }


}
