package it_company_work_book.gold;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 용액
// 이분탐색, 투포인터
// 시간복잡도 O(N)
/**
 * 투 포인터로 해결
 * 이미 정렬되어있는 배열를 받는다.
 * left(0), right(N-1) 로 두개의 포인터를 생성
 * 두 인덱스에 해당하는 용액의 합이 result 보다 작으면 업데이트
 * 만약 sum 의 값이 0보다 크면? 양수(혹은 제일 큰 값)의 크기를 줄여야 하므로 right--
 * sum 의 값이 0보다 작으면? 음수(혹은 제일 작은 값) 의 크기를 줄여야 하므로 left--
 * 0과 같으면 break, left가 right 보다 크거나 같으면 break
 */
public class BOJ_2467 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] solvent = new int[N];

        String[] s = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            solvent[i] = Integer.parseInt(s[i]);
        }

        int left = 0;
        int right = N - 1;
        int result = Integer.MAX_VALUE;

        int resultLeft = 0;
        int resultRight = N - 1;

        while (left < right) {
            int sum = solvent[left] + solvent[right];
            if (Math.abs(sum) < Math.abs(result)) {
                result = sum;
                resultLeft = left;
                resultRight = right;
            }

            if(sum > 0){
                right--;
            }else if(sum < 0){
                left++;
            }else{
                break;
            }
        }

        System.out.println(solvent[resultLeft] + " " + solvent[resultRight]);
    }
}
