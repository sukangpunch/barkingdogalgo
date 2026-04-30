package pgs.lv2;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 바이러스 파이프
/**
 * 재풀이
 * 연결리스트로 graph 생성
 * dfs(depth, k, []visited, lastType)
 * visited 를 통해, 현재 감염된 node 들 체킹
 * currentInfectionCount가 N이거나 depth가 K면 종료
 * A~C 의 파이프를 여는 dfs 탐색
 * A를 열었는데 또 A를 여는 경우는 최선일 수 없기에 조건으로 종료
 * simulate를 통해 bfs로 파이프를 열었을 때, 감염 노드들 업데이트
 */
public class PGS_468373_retry {

    class Solution {
        static class Edge{
            int v;
            int type;

            public Edge(int v, int type){
                this.v = v;
                this.type = type;
            }
        }

        static List<Edge>[] graph;
        static int result;
        static int N;

        public int solution(int n, int infection, int[][] edges, int k) {
            result = 0;
            N = n;
            graph = new ArrayList[n+1];

            for(int i=0; i<=n; i++){
                graph[i] = new ArrayList<>();
            }

            for(int i=0; i<edges.length; i++){
                int start = edges[i][0];
                int end = edges[i][1];
                int type = edges[i][2];

                graph[start].add(new Edge(end, type));
                graph[end].add(new Edge(start, type));
            }

            boolean [] visited = new boolean[n+1];
            visited[infection] = true;
            dfs(0, k, visited, -1);

            return result;
        }

        static boolean[] simulation(boolean[] currentInfected, int openType){
            boolean [] nextInfected = currentInfected.clone();
            Queue<Integer> q = new LinkedList<>();

            for(int i=0; i<=N; i++){
                if(nextInfected[i]){
                    q.add(i);
                }
            }

            while(!q.isEmpty()){
                int now = q.poll();

                for(Edge edge : graph[now]){
                    if(edge.type == openType && !nextInfected[edge.v]){
                        nextInfected[edge.v] = true;
                        q.add(edge.v);
                    }
                }
            }

            return nextInfected;
        }

        static void dfs(int depth, int k, boolean[] visited, int lastType){
            int currentInfectionCount = 0;

            for(int i=1; i<=N; i++){
                if(visited[i])currentInfectionCount++;
            }

            result = Math.max(result, currentInfectionCount);

            if(currentInfectionCount == N || depth == k){
                return;
            }

            for(int type = 1; type<=3; type++){
                if(type == lastType)continue;

                boolean[] nextInfected = simulation(visited, type);

                dfs(depth + 1, k, nextInfected, type);
            }
        }
    }
}
