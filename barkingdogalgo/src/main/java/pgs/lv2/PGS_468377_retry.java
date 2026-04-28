package pgs.lv2;

// 힌트 스테이지

/**
 * 재풀이, 코드 또 봄 ㅋㅋ
 * dfs(백트래킹) 으로 해결 가능
 * 각 stage(depth) 마다 hint를 구매 할지 말지(2갈래길) 와 힌트가 존재한다면 힌트가 적용된 cost로 마지막 스테이지까지 연산한 결과 중 최소인 값을 구하면 됌
 * 각 스테이지마다 보유증인 Hint를 저장할 myHint 배열 선언
 * depth == n 일때 기저 조건, 더해온 값과 현재 result값을 비교 후 작은 값으로 업데이트
 * 일단 현재 상태에서 기본적인 값을 구해놓는다. 보유증인 Hint가 적용된 cost를 먼저 구함
 * 해당 값 기반으로 depth 가 n-1 일때 기저 조건(마지막 스테이지는 힌트를 구매할 수 없음) 때는 hint 구매 없이 dfs
 * 그 다음, hint를 구매하지 않을 때, hint를 구매할 때의 두 갈래길로 분기한다.
 * hint 구매하지 않을 때는, hint 가격 및 hint 추가 없이 dfs
 * hint를 구매 할 때는, 해당 stage(depth) 의 hint 가격 및 myHints에 대상 stage에 맞게 hint를  추가하고 dfs
 * hint를 구매 하고 다시 backtrack 할때는 구매한 hint의 흔적을 없애야 하기 때문에 제거하는 반복문을 통해 보상
 */
public class PGS_468377_retry {
    class Solution {

        static int result;
        static int n;
        public int solution(int[][] cost, int[][] hint) {
            n = cost.length;
            result = Integer.MAX_VALUE;

            int[] myHints = new int[n];

            backtrack(0, 0, myHints, cost, hint);
            return result;
        }

        private void backtrack(int depth, int currentTotalCost, int []myHints, int[][]cost, int[][]hint){
            if(depth == n){
                result = Math.min(result, currentTotalCost);
                return;
            }

            int nowHintUsed = Math.min(myHints[depth], n-1);
            int nowStageCost = cost[depth][nowHintUsed];
            int nextDepthCost = currentTotalCost + nowStageCost;

            if(depth == n-1){
                backtrack(depth + 1, nextDepthCost, myHints, cost, hint);
                return;
            }

            backtrack(depth + 1, nextDepthCost, myHints, cost, hint);

            int nowHintPrice = hint[depth][0];
            for(int i=1; i< hint[depth].length; i++){
                int targetStage = hint[depth][i] - 1;
                myHints[targetStage]++;
            }

            backtrack(depth + 1, nextDepthCost + nowHintPrice, myHints, cost, hint);

            for(int i=1; i<hint[depth].length; i++){
                int targetStage = hint[depth][i] -1;
                myHints[targetStage]--;
            }
        }
    }
}
