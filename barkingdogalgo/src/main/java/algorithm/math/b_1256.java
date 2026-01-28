package algorithm.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 답 보기 : o
// 메모리 :  kb
// 시간 :  ms
public class b_1256 {
    static char [] arr;
    static int count;
    static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(isOver(N,M,K)){
            System.out.println(-1);
            return;
        }

        arr = new char[N+M];

        for(int i = 0 ; i < N ; i++){
            arr[i] = 'a';
        }

        for(int i = N ; i < N+M ; i++){
            arr[i] = 'z';
        }


    }

    private static void find(int size){
        if(count == K){
            return;
        }

        for(int i = 0 ; i < size ; i++){

        }
    }


    private static boolean isOver(int n, int m, int k) {
        int size = n+m;
        int c = Math.min(n, m);

        int sum=1;
        int divide = 1;
        for(int i = size ; i > 0 ; i--){
            sum *= i;
        }

        for(int i = c ; i > 0 ; i--){
            divide *= i;
        }

        return sum/divide < k;
    }
}
