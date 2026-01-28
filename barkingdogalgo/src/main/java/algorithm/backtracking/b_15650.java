package algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 답 보기 : x
// 메모리 :  14288 kb
// 시간 : 104 ms
public class b_15650 {
    static boolean [] visited;
    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];

        int count = 0;
        Stack<Integer> stack = new Stack<>();
        backtracking(stack,1, count);

        System.out.println(sb);
    }

    static void backtracking(Stack<Integer> stack, int idx, int count) {
        if(count == M){
            for(int i=0; i<M; i++){
                sb.append(stack.get(i)).append(" ");
            }
            sb.append("\n");
        }

        for(int i=idx; i<=N; i++){
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            stack.push(i);
            count += 1;
            idx += 1;
            backtracking(stack, idx, count);
            count--;
            visited[i] = false;
            stack.pop();
        }
    }
}
