package pgs.lv2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


// 바이러스 파이프

/**
 * dfs(백트래킹) 으로 A,B,C 중 여는 파이프의 조합 기반으로 BFS 를 돌려서 최대 Infection 의 수를 구하는 문제.
 * 연결 그래프를 만들어서 계산에 활용. start Node에 대한 visited를 true 로 체크한다.
 * 최대 k번 열었을 때, 이므로 매 번 infection의 최댓값을 체크, 이 값이 n이거나, step이 k 이면 return(가지치기).
 * 이후, type1 ~ type3 즉 A,B,C 중 열 파이프를 선택하고 DFS 재귀 진행, 매 번 simulate(bfs) 진행
 * simulation 을 진행 할 때는, visited 배열 기반으로 현재 감염된 Node 들을 알 수 있고, open 한 Type 도 넘겨주어 bfs로 감염을 진행.
 * 감염 이후의 배열을 리턴하여, dfs 로 넘겨가며 visited 배열을 조합별로 따로 관리할 수 있음.
 * 
 */
public class PGS_468373 {
    class Solution {

        static class Node{
            int v;
            int pipe;

            public Node(int v, int pipe){
                this.v = v;
                this.pipe = pipe;
            }
        }

        static List<Node>[] graph;
        static int result;
        static int N;

        public int solution(int n, int infection, int[][] edges, int k) {
            result = 0;
            N = n;
            graph = new ArrayList[n + 1];

            for(int i=0; i<=n; i++){
                graph[i] = new ArrayList<>();
            }

            for(int i=0; i<edges.length; i++){
                int start = edges[i][0];
                int end = edges[i][1];
                int pipe = edges[i][2];

                graph[start].add(new Node(end, pipe));
                graph[end].add(new Node(start, pipe));
            }

            boolean [] visited = new boolean[n+1];
            visited[infection] = true;

            dfs(0, k, visited, -1);

            return result;
        }

        static void dfs(int step, int k, boolean[] visited, int lastType){
            int currentInfectedCount = 0;

            for(int i=1; i<=N; i++){
                if(visited[i])currentInfectedCount++;
            }

            result = Math.max(result, currentInfectedCount);

            if(currentInfectedCount == N || step == k){
                return;
            }

            for(int type = 1; type<=3; type++){
                if(type == lastType) continue;

                boolean[] nextInfected = simulation(visited, type);

                dfs(step + 1, k, nextInfected, type);
            }
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

                for(Node node : graph[now]){
                    if(node.pipe == openType && !nextInfected[node.v]){
                        nextInfected[node.v] = true;
                        q.add(node.v);
                    }
                }
            }

            return nextInfected;
        }
    }
}
