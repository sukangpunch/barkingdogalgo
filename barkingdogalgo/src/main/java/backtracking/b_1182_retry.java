package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 부분 수열의 합
public class b_1182_retry {

    static int N;
    static int M;
    static int [] arr;
    static int result;
    static int count;
    static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String []s = br.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        arr = new int[N];

        s = br.readLine().split(" ");

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        findSequenceSum(0);
        System.out.println(result);
    }

    private static void findSequenceSum(int depth) {
        if(count != 0 && sum == M){
            result++;
        }

        for(int i=depth; i<N; i++){
            sum += arr[i];
            count +=1;
            findSequenceSum(i + 1);
            sum -= arr[i];
            count -= 1;
        }
    }

}
