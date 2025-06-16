package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 답 보기 : x
// 메모리 :  19760 kb
// 시간 : 156 ms
public class b_15652 {
    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        backtracking(0,0);
        System.out.println(sb);
    }

    static void backtracking(int pre, int count) {
        if(count == M){
            for(Integer i : stack){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1; i <= N; i++){
            if(pre <= i){
                stack.push(i);
                backtracking(i, count+1);
                stack.pop();
            }
        }
    }
}
