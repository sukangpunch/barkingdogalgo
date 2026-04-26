package pgs.lv2;

import java.util.Arrays;


// 완전범죄

/**
 * 처음에 백트래킹으로만 해결 하려다가 시간 초과로 해결하지 못했음. dp(메모제이션) 을 추가로 가지치기로 활용
 * O(2^N) -> O(N*N) 
 * dfs(백트래킹) 으로 B가 훔치는 경우, A가 훔치는 경우 순서로 탐색을 진행(A가 최소값이 되어야 하기 떄문)
 * 탐색 종료 조건은 다음과 같다.
 * 1. A의 합과 B의 합은 각 n과 m보다 작아야 한다.
 * 2. sumA가 result보다 작거나 같으면 탐색 종료
 * 3. depth가 info(훔쳐야할 물건 수) 만큼이면 result 값 업데이트 비교
 * 4. 만약 동일한 depth와 sumA의 값인데 sumB가 크다면 탐색할 필요 x (어짜피 다른 depth일때의 값과 다음 depth의 값은 상관이 없기 때문)
 */
public class PGS_389480 {
    class Solution {

        static int result;
        static int[][] memo;

        public int solution(int[][] info, int n, int m) {
            result = Integer.MAX_VALUE;
            memo = new int[info.length][n+1];

            for(int i=0; i<info.length; i++){
                Arrays.fill(memo[i], Integer.MAX_VALUE);
            }

            dfs(0, 0, 0, info, n, m);

            return result == Integer.MAX_VALUE ? -1 : result;
        }

        static void dfs(int depth, int sumA, int sumB, int[][]info, int n, int m){
            if(sumA >= n || sumB >= m){
                return;
            }

            if(sumA >= result){
                return;
            }

            if(depth == info.length){
                result = Math.min(result, sumA);
                return;
            }

            if(memo[depth][sumA] <= sumB){
                return;
            }

            memo[depth][sumA] = sumB;

            dfs(depth + 1, sumA, sumB + info[depth][1], info, n, m);
            dfs(depth + 1, sumA + info[depth][0], sumB, info, n, m);
        }
    }
}
