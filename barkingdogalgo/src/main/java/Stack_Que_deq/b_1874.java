package Stack_Que_deq;

import java.io.*;
import java.util.Stack;

public class b_1874 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> st = new Stack<>();

        int idx = 1;
        boolean check = false;
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            while(true){
                if(st.isEmpty()){
                    st.push(idx++);
                    sb.append('+').append("\n");
                }

                if(st.peek() < num){
                    st.push(idx++);
                    sb.append('+').append("\n");
                }

                if(st.peek() == num){
                    st.pop();
                    sb.append('-').append("\n");
                    break;
                }

                if(st.peek() > num){
                    check = true;
                    break;
                }
            }
            if(check){
                break;
            }
        }

        if(check){
            bw.write("NO");
        }else{
            bw.write(sb.toString());
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
