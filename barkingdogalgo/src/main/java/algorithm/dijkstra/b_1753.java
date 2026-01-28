package algorithm.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// 다익스트라
public class b_1753 {

    static class Node{
        int end;
        int weight;

        public Node(int end, int weight){
            this.end = end;
            this.weight = weight;
        }
    }

    static int V;
    static int E;
    static int start;
    static int [] distance;
    static boolean [] visited;
    static List<Node>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String [] s = br.readLine().split(" ");
        V = Integer.parseInt(s[0]);
        E = Integer.parseInt(s[1]);
        start = Integer.parseInt(br.readLine());

        distance = new int[V+1];
        visited = new boolean[V+1];
        list = new List[V+1];

        for(int i=1; i<=V; i++){
            list[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }

        for(int i=0; i<E; i++){
            s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            int cost = Integer.parseInt(s[2]);

            list[start].add(new Node(end, cost));
        }

        findShortestWay();

        for(int i=1; i<=V; i++){
            if(distance[i] == Integer.MAX_VALUE) {
                sb.append("INF").append("\n");
            }else{
                sb.append(distance[i]).append("\n");
            }
        }
        
        System.out.println(sb);
    }

    // 우선순위 큐를 통해, 가장 가까운 정점부터 확정
    // 즉, now 가 (start, 0) 일 때, 인접 방향을 초기화 하기 때문에, 따로 초기화할 필요 없다.
    private static void findShortestWay() {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        pq.add(new Node(start, 0));
        distance[start] = 0;

        while(!pq.isEmpty()){
            Node now = pq.poll();

            if(visited[now.end])continue;
            visited[now.end] = true;

            for(Node next : list[now.end]){
                if(visited[next.end]) continue;
                int newDist = distance[now.end] + next.weight;
                if(newDist < distance[next.end]){
                    distance[next.end] = newDist;
                    pq.add(new Node(next.end, newDist));
                }
            }
        }
    }

}
