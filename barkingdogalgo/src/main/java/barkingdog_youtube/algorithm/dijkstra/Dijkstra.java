package barkingdog_youtube.algorithm.dijkstra;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 다익스트라 구현
// 다익스트라를 이렇게 쓸 순 없다(너무 느림)
public class Dijkstra {

    static boolean[] visited;
    static int[] distance;
    static int[][] graph;
    static final int NO_EDGE = 987654321;
    static int N;

    public static void main(String[] args) {
        N = 6;
        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        distance = new int[N + 1];

        for (int[] arr : graph) {
            Arrays.fill(arr, NO_EDGE);
        }

        for (int i=1; i<=N; i++){
            distance[i] = NO_EDGE;
        }

        graph[1][2] = 3;
        graph[1][3] = 2;
        graph[1][4] = 5;
        graph[2][3] = 2;
        graph[2][5] = 8;
        graph[3][4] = 2;
        graph[4][5] = 6;
        graph[5][6] = 1;

        dijkstra(1);

        for (int i=1; i<=N; i++){
            System.out.print(distance[i] + " ");
        }
    }

    private static void dijkstra(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        distance[start] = 0;

        while (!q.isEmpty()) {
            int now = q.poll();
            visited[now] = true;

            for (int i = 1; i <= N; i++) {
                if(graph[now][i] == NO_EDGE || visited[i]){
                    continue;
                }
                distance[i] = Math.min(distance[i], distance[now] + graph[now][i]);
                q.offer(i);
            }
        }
    }
}
