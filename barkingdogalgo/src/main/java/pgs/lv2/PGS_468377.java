package pgs.lv2;

// 힌트 스테이지

/**
 * 백트래킹 문제인데, hint 구매 여부 및, 힌트가 적용된 cost를 적용해야 하는 백트래킹 심화 문제인듯 하다.
 * 처음에는 원래 하던 것 처럼, hint 만큼 for문을 돌리면서 트리를 완성해 나가려고 했는데 잘 안되서 ai 활용
 * 기저 조건(depth 가 n일때, 현재 cost와 minCost 비교)
 * 가지치기1(현재 쌓아온 cost가 현시점 mincost보다 크면 바로 탈출)
 * 가지치기2(n-1 depth에서는 힌트를 구매할 수 없으므로 바로 재귀 호출 및  return)
 * 그리고 재귀 들어가기 전에 미리 현재 stage에서의 cost를 구해논다(힌트가 있다면 hint 적용된 값으로)
 * 반복문 없이 hint 구매 x버전 재귀와 hint 구매 O 버전 재귀를 나눈다.
 * hint 구매 o버전 재귀에서는 재귀 호출 앞 뒤로 hint 적용, hint 적용 해제 로직이 필수.
 */
public class PGS_468377 {
    class Solution {

        private int minCost;
        private int n;

        public int solution(int[][] cost, int[][] hint) {
            this.n = cost.length;
            this.minCost = Integer.MAX_VALUE;

            int[] myHints = new int[n];

            backtrack(0, 0, myHints, cost, hint);

            return this.minCost;
        }

        private void backtrack(int depth, int currentTotalCost, int[] myHints, int[][] cost, int[][] hint) {
            if(currentTotalCost >= this.minCost)return;

            if(depth == n){
                minCost = Math.min(minCost, currentTotalCost);
                return;
            }

            int hintsUsed = Math.min(myHints[depth], n-1);
            int stageClearCost = cost[depth][hintsUsed];
            int nextTotalCost = currentTotalCost + stageClearCost;

            if(depth == n-1){
                backtrack(depth + 1, nextTotalCost, myHints, cost, hint);
                return;
            }

            backtrack(depth + 1, nextTotalCost, myHints, cost, hint);

            int hintPrice = hint[depth][0];

            for(int i=1; i<hint[depth].length; i++){
                int targetStage = hint[depth][i] - 1;
                myHints[targetStage]++;
            }

            backtrack(depth + 1, nextTotalCost + hintPrice, myHints, cost, hint);

            for(int i=1; i<hint[depth].length; i++){
                int targetStage = hint[depth][i] - 1;
                myHints[targetStage]--;
            }
        }
    }
}
