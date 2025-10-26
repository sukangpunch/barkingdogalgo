package mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class b_1368 {

    static class Edge implements Comparable<Edge>{
        int v;
        int cost;

        Edge(int v, int cost){
            this.v = v;
            this.cost = cost;
        }

        // 오름차순 정렬
        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    static int N;
    static int [] costOfWell;
    static int [][] costOfFetching;
    static int minimumCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        costOfWell = new int[N];
        costOfFetching = new int[N][N];

        for(int i = 0; i < N; i++){
            costOfWell[i] = Integer.parseInt(br.readLine());
        }

        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                int num = Integer.parseInt(st.nextToken());
                costOfFetching[i][j] = num;
            }
        }

        minimumCount = Integer.MAX_VALUE;
        wateringTheFiled();

        System.out.println(minimumCount);
    }

    private static void wateringTheFiled() {
        for(int i = 0; i < N; i++){
            boolean[] visited = new boolean[N];
            minimumCount = Math.min(minimumCount, mst(i, visited, 0));
        }
    }

    private static int mst(int start, boolean[] visited, int count) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, costOfWell[start]));
        int [] best = new int[N];
        Arrays.fill(best, Integer.MAX_VALUE);

        while(!pq.isEmpty()){
            Edge edge = pq.poll();
            int v = edge.v;
            int cost = edge.cost;

            if(visited[v]) continue;

            visited[v] = true;
            count += cost;

            for(int i = 0; i < N; i++){
                if(!visited[i]){
                    int newCost = Math.min(costOfWell[i], costOfFetching[v][i]);
                    if(newCost < best[i]){
                        best[i] = newCost;
                        pq.add(new Edge(i, newCost));
                    }
                }
            }

        }

        return count;
    }

}
