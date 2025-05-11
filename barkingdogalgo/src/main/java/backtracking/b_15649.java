package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_15649 {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static boolean [] check;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        check = new boolean[N+1];
        arr = new int[M];

        backtracking(0);

        System.out.println(sb);
    }

    static void backtracking(int depth) {
        if(depth == M){
            for(int i = 0; i < M; i++){
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1; i<=N; i++){
            if(!check[i]){
                check[i] = true;
                arr[depth] = i;
                backtracking(depth + 1);
                check[i] = false;
            }
        }
    }
}