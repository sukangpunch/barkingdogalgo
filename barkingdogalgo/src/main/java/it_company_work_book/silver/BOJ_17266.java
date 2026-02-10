package it_company_work_book.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 굴다리
// 구현, 이분탐색

/**
 * 이렇게 범위 내에서 최대, 최소값 등을 구할 때 이분탐색을 고려 해보자
 * 0~N 범위의 값을 지정하고(가로등 높이) 해당 높이 일 때, 모든 인덱스를 커버하는지 체크
 * 모든 범위가 체크 된다면 result에 넣고 start 가 end 보다 커질떄까지 반복하면
 * 모든 범위 체크 되는 최소 높이를 구할 수 있다.
 */
public class BOJ_17266 {

    static int [] light;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int M = Integer.parseInt(br.readLine());
        String [] s = br.readLine().split(" ");
        light = new int[M];

        for(int i=0; i<M; i++){
            light[i] = Integer.parseInt(s[i]);
        }

        int start = 0;
        int end = N;
        int result = 0;
        while(start <= end){
            int mid = (start + end) / 2;

            if(check(mid)){
                result = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        System.out.println(result);
    }

    private static boolean check(int mid){
        int prev = 0;

        for(int i=0; i<light.length; i++){
            if(light[i] - mid <= prev){
                prev = light[i] + mid;
            }else{
                return false;
            }
        }

        if(N - prev > 0){
            return false;
        }else{
            return true;
        }
    }
}
