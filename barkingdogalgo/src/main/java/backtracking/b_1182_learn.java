package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_1182_learn {

    static int N;
    static int S;
    static int [] arr;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        S = Integer.parseInt(s[1]);
        arr = new int[N];

        s = br.readLine().split(" ");
        for(int i =0; i<N; i++){
            arr[i] = Integer.parseInt(s[i]);
        }

        backtrack(0, 0);

        if(S == 0){ // 공집합 제외
            count--;
        }
        System.out.println(count);
    }

    private static void backtrack(int depth, int total) {
        if(depth == N){
            if(total == S)count++;
            return;
        }

        // 조합을 만들 때, 현재 숫자를 선택하거나 선택하지 않거나를 분기한다.
        // 함수 하나당 가지가 하나씩 생긴다고 생각
        // 이렇게 하는 이유는 꼭 M 개를 선택해야하는 문제가 아니고 조합의 합이 조건이기 때문
        backtrack(depth+1, total);
        backtrack(depth+1, total + arr[depth]);
    }

}
