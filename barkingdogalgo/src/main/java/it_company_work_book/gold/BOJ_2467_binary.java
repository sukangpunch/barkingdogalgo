package it_company_work_book.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 용액
// 이분탐색, 투포인터
// 시간복잡도 O(NlogN)

/**
 * 하나의 값 i를 고정하고 그 오른쪽 구간을 탐색 하는 이분탐색
 * 중복 계산을 막기 위해 i를 검색할 때 left 는 i+1 로 가야한다.
 * left, right 를 기반으로 mid 값을 구해서, mid 값이 i의 오른쪽 값이 된다.
 * 이 계산을 반복해서 i(left) 를 기준으로 최적의 (right) 값을 이분탐색으로 찾을 수 있다.
 */
public class BOJ_2467_binary {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] solvent = new int[N];

        String[] s = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            solvent[i] = Integer.parseInt(s[i]);
        }

        int result = Integer.MAX_VALUE;
        int resultLeft = 0;
        int resultRight = N - 1;

        for(int i=0; i<N-1; i++){
            int left = i+1;
            int right = N - 1;

            while(left<=right){
                int mid = (left + right)/2;
                int sum = solvent[i] + solvent[mid];

                if(Math.abs(sum) < Math.abs(result)){
                    result = sum;
                    resultLeft = i;
                    resultRight = mid;
                }

                if(sum > 0){
                    right = mid -1;
                }
                else if(sum < 0){
                    left = mid+1;
                }else{
                    System.out.println(solvent[i] + " " + solvent[mid]);
                    return;
                }
            }
        }

        System.out.println(solvent[resultLeft] + " " + solvent[resultRight]);
    }
}
