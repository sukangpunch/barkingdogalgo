package algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 답 보기 : x
// 메모리 :  213968 kb
// 시간 : 568 ms
public class b_15651 {

    static int N;
    static int M;
    static ArrayList<Integer> sequence;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sequence = new ArrayList<>();
        int count = 0;
        backtracking(count);
        System.out.println(sb);
    }

    private static void backtracking(int count) {
        if(count == M) {
            for(int i=0; i<M; i++){
                sb.append(sequence.get(i)).append(' ');
            }
            sb.append("\n");
            return;
        }

        for(int i=1; i<=N; i++){
            sequence.add(i);
            backtracking(count+1);
            sequence.remove(sequence.size()-1);
        }

    }
}
