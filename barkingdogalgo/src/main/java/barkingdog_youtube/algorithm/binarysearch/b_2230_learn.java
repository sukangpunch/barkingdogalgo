package barkingdog_youtube.algorithm.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 수 고르기 - 이진탐색을 해결
public class b_2230_learn {

    static long [] arr;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        long min = Integer.MAX_VALUE;
        for(int i=0; i<N; i++){
            long result = binarySearch(arr[i] + M);
            min = Math.min(min, result - arr[i]);
        }

        System.out.println(min);
    }

    private static long binarySearch(long target) {
        int st = 0;
        int en = N-1;
        boolean check = false;

        while(st <= en){
            int mid = (st+en)/2;
            if(arr[mid] < target){
                st = mid+1;
            }else if(arr[mid] >= target){
                en = mid-1;
                check = true;
            }
        }

        if(!check){
            return Integer.MAX_VALUE;
        }

        // check == true 일 때는 target 이상인 값이 존재 -> arr[st] 가 답(무조건 st가 en 을 1 역전하는 이후 종료)
        // check == false 일때는 target 이상인 값이 없음 -> Integer.MAX 반환
        // lower_bound 동작 
        return arr[st];
    }

}
