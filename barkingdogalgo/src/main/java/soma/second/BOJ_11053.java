package soma.second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 가장 긴 증가하는 부분 수열
// dp

/**
 * 저번에 푼 기억이 있어 어렵지 않았다
 * dp 를 활용하여, 0~n 까지 돌고(i) 내부적으로 0~i까지 돌면서(j)
 * 만약 j에 해당하는 값이 i의 값보다 작을 떄, 해당 dp값 +1 이 현재 dp[i] 보다 크면 업데이트 하는 방식으로 반복
 * 최종적으로 전체 dp 배열에서 가장 최대 값을 구하면, 그게 최장 길이 수열이다.
 */
public class BOJ_11053 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String []s = br.readLine().split(" ");
        int [] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(s[i]);
        }

        int result = solution(N, arr);
        System.out.println(result);
    }

    private static int solution(int n, int[] arr) {

        int []dp = new int[n];
        for(int i=0; i<n; i++){
            dp[i] = 1;
            for(int j=0; j<i; j++){
                if(arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 0;
        for(int i=0; i<n; i++){
            if(dp[i] > max){
                max = dp[i];
            }
        }

        return max;
    }
}
