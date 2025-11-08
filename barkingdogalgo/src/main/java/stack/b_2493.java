package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class b_2493 {
    static class Pair{
        private int index;
        private int height;
        public Pair(int index, int height){
            this.index = index;
            this.height = height;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String []line = br.readLine().split(" ");
        Stack<Pair> st = new Stack<>();
        int [] arr = new int[N];

        for(int i = 1; i <= N; i++){
            int k = Integer.parseInt(line[i-1]);
            st.push(new Pair(i, k));
            if(i==1){
                arr[i-1] = 0;
            }else{
                Pair now = st.pop();
                while(!st.isEmpty()){
                    if(st.peek().height < now.height){
                        st.pop();
                    }else{
                        break;
                    }
                }
                if(st.isEmpty()){
                    arr[i-1] = 0;
                    st.push(now);
                }else{
                    arr[i-1] = st.peek().index;
                    st.push(now);
                }
            }
        }
        for(int height: arr){
            sb.append(height).append(" ");
        }
        System.out.println(sb);
    }
}
