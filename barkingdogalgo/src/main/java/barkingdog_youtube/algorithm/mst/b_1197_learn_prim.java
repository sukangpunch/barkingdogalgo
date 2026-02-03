package barkingdog_youtube.algorithm.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import org.w3c.dom.Node;

// 최소 스패닝 트리
// 프림 알고리즘 버전
public class b_1197_learn_prim {
    static class Edge {
        int v;
        int cost;

        public Edge(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    static List<ArrayList<Edge>> graph;
    static boolean [] visited;
    static int V;
    static int E;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        V = Integer.parseInt(s[0]);
        E = Integer.parseInt(s[1]);
        visited = new boolean[V+1];
        graph = new ArrayList<>();
        for(int i=0; i<=V; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<E; i++){
            s = br.readLine().split(" ");
            int v1 = Integer.parseInt(s[0]);
            int v2 = Integer.parseInt(s[1]);
            int cost = Integer.parseInt(s[2]);

            graph.get(v1).add(new Edge(v2, cost));
            graph.get(v2).add(new Edge(v1, cost));
        }

        int result = prim(1);
        System.out.println(result);
    }

    private static int prim(int start) {
        int sum = 0;
        int count = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.cost));
        visited[start] = true;
        for(Edge nxt : graph.get(start)){
            pq.offer(nxt);
        }

        while(count < V-1){
            Edge now = pq.poll();
            int v = now.v;

            if(visited[v])continue;
            sum += now.cost;
            visited[v] = true;
            count++;

            for(Edge e : graph.get(v)){
                if (!visited[e.v]){
                    pq.offer(e);
                }
            }
        }

        return sum;
    }
}
