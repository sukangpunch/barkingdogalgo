package barkingdog_youtube.algorithm.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

// 최단 경로
public class b_1753_learn {

    static class Node{
        int v;
        int cost;

        public Node(int v, int cost){
            this.v = v;
            this.cost = cost;
        }
    }

    static int [] distance;
    static final int NO_EDGE = 987654321;
    static List<ArrayList<Node>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String []s = br.readLine().split(" ");
        int V = Integer.parseInt(s[0]);
        int E = Integer.parseInt(s[1]);
        int start = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for(int i=0; i<=V; i++){
            graph.add(new ArrayList<>());
        }

        distance = new int[V+1];
        for(int i=1; i<=V; i++){
            distance[i] = NO_EDGE;
        }

        for(int i=0; i<E; i++){
            s = br.readLine().split(" ");
            int startV = Integer.parseInt(s[0]);
            int endV = Integer.parseInt(s[1]);
            int cost = Integer.parseInt(s[2]);
            graph.get(startV).add(new Node(endV, cost));
        }

        dijkstra(start);

        for(int i=1; i<=V; i++){
            if(distance[i] == NO_EDGE){
                sb.append("INF").append("\n");
            }else{
                sb.append(distance[i]).append("\n");
            }
        }

        System.out.println(sb);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n->n.cost));
        distance[start] = 0;
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()){
            Node now = pq.poll();

            // 우선순위 큐에서 꺼낸 시점의 distance 값이 최종 최단 거리임을 보장
            // 즉, distance 값과 pq에서 나온 정점의 cost가 다르다면 최단으로 업데이트가 안된것이고,
            // 이미 최종 값이 정해진 정점임을 알 수 있다.
            if(distance[now.v] != now.cost)continue;
            for(Node nxt: graph.get(now.v)){
                if(distance[nxt.v] > distance[now.v] + nxt.cost){
                    distance[nxt.v] = distance[now.v] + nxt.cost;
                    pq.offer(new Node(nxt.v, distance[nxt.v]));
                }
            }
        }
    }
}
