package study.week14;

import java.util.ArrayList;
import java.util.List;

// 양과 늑대
// 백트래킹

/**
 * 어려워서 ai 활용
 * ArrayList로 이진 트리를 구성하여, 해당 노드의 자식들을 간편하게 접근할 수 있도록 함.
 * backtrack 내부에선 currentIdx 를 기반으로 양인지, 늑대인지 구분하고 값을 증가시킨다.
 * 만약 늑대가 더 많아진다면 가지치기(return) 
 * 그 다음 result를 업데이트(양 개수) 
 * 다음 탐색은 현재 노드 기반 자식 노드들을 찾고, 찾은 자식들에 대해 백트래킹을 진행
 * 현재 가능한 방향으로만 backtrack 함수를 호출하기 때문에 visited 배열 불필요
 */
public class PGS_92343 {
    class Solution {

        static int result;
        static List<Integer>[] tree;

        public int solution(int[] info, int[][] edges) {
            result = 0;
            int n = info.length;
            tree = new ArrayList[n];

            for(int i=0; i<n; i++){
                tree[i] = new ArrayList<>();
            }

            for(int[] edge: edges){
                tree[edge[0]].add(edge[1]);
            }

            List<Integer> nextNodes = new ArrayList<>();
            nextNodes.add(0);

            backtrack(0, 0, 0, nextNodes, info);

            return result;
        }

        private void backtrack(int currIdx, int sheep, int wolf, List<Integer> nextNodes, int[] info) {
            if(info[currIdx] == 0){
                sheep++;
            }else{
                wolf++;
            }

            // 늑대가 양과 같거나 많아지면 탐색 종료
            if(wolf >= sheep)return;

            result = Math.max(result, sheep);

            // 다음으로 갈 수 있는 노드 목록 업데이트 (현재 노드는 제외, 현재 노드의 자식들은 추가)
            List<Integer> list = new ArrayList<>(nextNodes);
            // remove(Object o) 형식이여야, o 에 해당하는 "값" 을 찾아 지운다.
            list.remove(Integer.valueOf(currIdx));

            for(int child : tree[currIdx]){
                list.add(child);
            }

            for(int next : list){
                backtrack(next, sheep, wolf, list, info);
            }

        }
    }
}
