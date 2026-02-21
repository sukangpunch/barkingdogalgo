package it_company_work_book.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 겹치는 건 싫어
// 투포인터

/**
 * 알고리즘을 확인하고 쉽게 풀 수 있었다.
 * 투포인터를 활용해서 right 인덱스를 증가시키며 수열의 길이를 측정한다
 * 이 때, count 배열에 쌓인 cnt 값이 k를 넘어가게 된다면, left 를 늘린다.
 * left 를 늘리며, range 에 벗어난 요소들에 대해 count값과 maxLength 를 줄이는 것을 반복
 * 만약 count 값이 줄어서 새로운 값을 수열에 추가할 수 있으면 다시 right 증가 maxLength, count 증가
 * 최종result에 담긴 결과물이 최장 길이 수열
 */
public class BOJ_20922 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String []s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);

        s = br.readLine().split(" ");
        int []sequence = new int[N];

        int max = 0;
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(s[i]);
            sequence[i] = num;
            if(num > max){
                max = num;
            }
        }

        int left = 0;
        int right = 0;
        int maxLength = 0;
        int result = 0;
        int []count = new int[max+1];
        while(left <= right && right < N){
            if(count[sequence[right]] < K){
                count[sequence[right]]++;
                right++;
                maxLength++;
                if(maxLength > result){
                    result = maxLength;
                }
            }else{
                count[sequence[left]]--;
                left++;
                maxLength--;
            }
        }

        System.out.println(result);
    }
}
