package barkingdog_youtube.algorithm.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

// 최소 스패닝 트리
public class b_1197_learn {

    static class Edge {
        int v1;
        int v2;
        int cost;

        public Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }
    }

    static PriorityQueue<Edge> edges;
    static int [] parents;
    static int V;
    static int E;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        V = Integer.parseInt(s[0]);
        E = Integer.parseInt(s[1]);
        edges = new PriorityQueue<>(Comparator.comparingInt(e -> e.cost));

        parents = new int[V+1];

        for(int i=1; i<=V; i++){
            parents[i] = i;
        }

        for (int i = 0; i < E; i++) {
            s = br.readLine().split(" ");
            int v1 = Integer.parseInt(s[0]);
            int v2 = Integer.parseInt(s[1]);
            int cost = Integer.parseInt(s[2]);

            edges.offer(new Edge(v1, v2, cost));
        }

        int result = kruskal();

        System.out.println(result);
    }

    private static int kruskal() {
        int sum = 0;
        int count = 0;

        while(count < V-1){
            Edge now = edges.poll();
            int start = now.v1;
            int end = now.v2;

            if(find(start) != find(end)){
                sum += now.cost;
                count++;
                union(start, end);
            }
        }

        return sum;
    }

    private static int find(int start) {
        if(parents[start] == start){
            return start;
        }
        return find(parents[start]);
    }

    private static void union(int start, int end) {
        int v1p = find(start);
        int v2p = find(end);
        if(v1p >= v2p){
            parents[v2p] = v1p;
        }else{
            parents[v1p] = v2p;
        }
    }
}
