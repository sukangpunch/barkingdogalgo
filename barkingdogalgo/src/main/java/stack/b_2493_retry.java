package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 탑
public class b_2493_retry {
    static class Top{
        int top;
        int order;

        public Top(int top, int order) {
            this.top = top;
            this.order = order;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Top> stack = new Stack<>();

        for(int i=1; i<=N; i++) {
            int top = Integer.parseInt(st.nextToken());

            while(true){
                if(stack.isEmpty()){
                    sb.append(0).append(" ");
                    stack.push(new Top(top, i));
                    break;
                }

                if(stack.peek().top >= top){
                    sb.append(stack.peek().order).append(" ");
                    stack.push(new Top(top, i));
                    break;
                }

                if(stack.peek().top < top){
                    stack.pop();
                }
            }
        }

        System.out.println(sb);
    }
}
