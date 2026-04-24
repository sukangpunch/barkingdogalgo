package pgs.lv2;

// 리프 노드 수 최대화

/**
 *  어려워서 바로 ai
 *  dfs 로 자식을 2개 만드는 경우와 3개 만드는 경우로 depth 마다 분기하며 진행
 *  cur 을 통해, 현 depth 에서 유효한 node 상태를 나타냄
 *  used 를 통해 현 depth 에서 총 사용한 node 상태를 나타냄
 *  split을 통해, 현 depth에서 자식을 분기할 수 있는 node 들을 나타냄
 *  leaf 를 통해, 현 depth에서 leaf 들을 구함(자식 분기 불가능한 애들)
 *  nextSplit(split * child(2개 or 3개)) 을 통해, 현 시점 분배 가능한 노드들이 자식을 균등하게 생성할 수 있는지 확인, 없으면 종료
 *  nextNodes 를 통해 다음 depth에서 활성화 되어야 할 node 개수 구함
 *  remain 을 통해 현 시점 허용할 수 있는 분배 노드들 개수 구함(루트 + 분배 노드 합은 dl 보다 작아야함)
 *  nextCur 을 통해, 실제로 다음 레벨에서 배치할 수 있는 노드의 수를 구함(최대치는 nextNode, 분배 노드 수가 부족하다면 remain)
 *  nextLeaf 을 통해, 자원이 부족해서 자식으로 태어나지 못한 수만큼 곱한다. 즉, 분배노드가 되지 못한 노드들이 leafNode 가 된다.
 *  이를 dfs 로 탐색하면 최종적으로 result에는 최댓값이 남게 됨
 */
public class PGS_468372 {
    class Solution {

        static int result;

        public int solution(int dist_limit, int split_limit) {
            result = 1;
            dfs(1, 1, 1, 0, dist_limit, split_limit);
            return result;
        }

        // cur : 현재 탐ㅁ색 중인 depth 에 있는 활성 노드 수. 해당 노드들이 자식들을 낳는다.
        // used : 트리의 루트부터 지금까지 총 사용된 노드의 수
        // split : 현재까지의 누적 분기 계수. (부모가 자식을 몇 개 낳았는지 계속 곱해 나간다.)
        // leaf : 자원이 부족해서 더 이상 자식을 낳지 못하고 확정된 말단.
        static void dfs(long cur, long used, long split, long leaf, int dl, int sl){
            // 사용된 노드가 한도를 초과하면 즉시 종료
            // 아니라면, 현재까지 확정된 리프노드 + 현재 레벨에 살아있는 노드 로 최댓값 비교
            if(used > dl) return;
            result = (int)Math.max(result, leaf + cur);

            // depth 별로 2갈래, 3갈래 로 분기
            for(int child = 2; child <= 3; child++){

                long nextSplit = split * child;
                if(nextSplit > sl) continue;

                // 이론상 생성되어야 할 다음 레벨의 노드 수
                long nextNodes = cur * child;

                // 현재 남아있는 허용 노드 수
                long remain = dl - used;

                // 실제로 다음레벨에 배치할 수 있는 노드 수.
                long nextCur = (int)Math.min(nextNodes, remain);

                // 자원이 부족해서 자식으로 태어나지 못한노드 수
                long nextLeaf = leaf + (nextNodes - nextCur);

                dfs(nextCur, used + nextCur, nextSplit, nextLeaf, dl, sl);
            }
        }
    }
}
