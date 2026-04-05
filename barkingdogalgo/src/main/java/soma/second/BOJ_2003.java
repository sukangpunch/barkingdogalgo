package soma.second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 수들의 합
// 투 포인터

/**
 * sum 에 연속적인 합산 결과를 더하되, sum이 m보다 크거나 같으면 left값을 빼고 left증가, 작다면 right증가 후 right값 추가
 * sum < m 인데 right가 n과 같아지면 더이상 sum을 증가시킬 방법 없으므로 break
 */
public class BOJ_2003 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] s = br.readLine().split(" ");

        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        s = br.readLine().split(" ");
        int []arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(s[i]);
        }

        int result = solution(N, M, arr);
        System.out.println(result);
    }

    private static int solution(int n, int m, int[] arr) {

        int left = 0;
        int right = 0;
        int sum = 0;
        int result = 0;

        while(left<=right){
            if(sum >= m){
                sum -=arr[left++];
            }else if(right == n){
                break;
            } else{
                sum += arr[right++];
            }

            if(sum == m){
                result++;
            }
        }

        return result;
    }
}
