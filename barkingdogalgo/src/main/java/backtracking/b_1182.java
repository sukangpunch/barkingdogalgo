package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 답 보기 : x(부분수열의 개념 확인)
// 메모리 :  14120 kb
// 시간 : 112 ms
public class b_1182 {
    static int [] sequence;
    static int S;
    static int N;
    static int count;
    static int sum;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        sequence = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
        {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(0);
        System.out.println(result);
    }

    static void backtracking(int depth) {
        if(count != 0 && sum == S){
            result +=1;
        }

        for(int i= depth; i < N; i++){
            sum += sequence[i];
            count++;
            backtracking(i + 1);
            sum -= sequence[i];
            count--;
        }
    }
}
