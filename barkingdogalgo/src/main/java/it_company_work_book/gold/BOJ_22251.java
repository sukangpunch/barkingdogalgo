package it_company_work_book.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 빌런 호석
// 완전탐색
/**
 * 시간복잡도 : O(N * K)
 * 처음에 자리 수 마다 가능한 COUNT 경우의 수를 구하려고 했는데, AI가 완전탐색(1~ N까지 순서대로 가능성 체크) 로 푸는 것을 추천
 * 가능한 숫자 규격을 nums 배열에 저장
 * 1~ N까지 반복하면서, X(현재 층수) 가 i 가 되기 위한 반전 횟수를 구한다.
 * 1의 자리와 (1~9층), 2의 자리 (35층 등) 비교에도 앞자리가 0(nums[0])으로 생각하면 되기 때문에 가능
 * 반전 횟수가 P 미만이라면 count++ 해준다.
 */
public class BOJ_22251 {

    static boolean [][] nums = {
            {true,true,true,false,true,true,true},
            {false,false,true,false,false,false,true},
            {false,true,true,true,true,true,false},
            {false,true,true,true,false,true,true},
            {true,false,true,true,false,false,true},
            {true,true,false,true,false,true,true},
            {true,true,false,true,true,true,true},
            {false,true,true,false,false,false,true},
            {true,true,true,true,true,true,true},
            {true,true,true,true,false,true,true}
    };


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);
        int P = Integer.parseInt(s[2]);
        int X = Integer.parseInt(s[3]);

        int count = 0;

        // 1층부터 N층 까지 모든 경우의 수를 탐색 (완전 탐색)
        for (int i = 1; i <= N; i++) {
            if (i == X) continue; // 실제 층과 대상 층이 같으면 반전시킬 필요가 없으므로 패스

            int diffCount = 0; // 필요한 반전 횟수
            int targetFloor = i;
            int currentFloor = X;

            // K 자리를 하나씩 비교
            for (int k = 0; k < K; k++) {
                int targetDigit = targetFloor % 10;
                int currentDigit = currentFloor % 10;

                // 작성하신 check 메서드를 활용해 각 자리수의 차이를 더함
                diffCount += check(currentDigit, targetDigit);

                targetFloor /= 10;
                currentFloor /= 10;
            }

            // 반전 횟수가 P 이하라면 가능한 경우의 수
            if (diffCount <= P) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static int check(int target, int num) {
        int cnt = 0;

        for(int i=0; i<nums[target].length; i++){
            if(nums[target][i] != nums[num][i]){
                cnt++;
            }
        }

        return cnt;
    }
}
