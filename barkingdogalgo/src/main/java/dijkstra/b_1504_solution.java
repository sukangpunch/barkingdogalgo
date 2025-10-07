package dijkstra;

import java.io.*;
import java.util.*;

public class b_1504_solution {
    static class Node{
        int end;
        int cost;

        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }

    static int N, E;
    static ArrayList<ArrayList<Node>> nodes;
    static int[] dist;
    static boolean [] visited;
    static final int INF = 200000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        nodes = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            nodes.add(new ArrayList<>());
        }

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            nodes.get(start).add(new Node(end, cost));
            nodes.get(end).add(new Node(start, cost));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int result1 = 0;
        result1 += dijkstra(1, v1);
        result1 += dijkstra(v1, v2);
        result1 += dijkstra(v2, N);

        int result2 = 0;
        result2 += dijkstra(1, v2);
        result2 += dijkstra(v2, v1);
        result2 += dijkstra(v1, N);

        int realResult = result1 >= INF && result2 >= INF ? -1 : Math.min(result1, result2);
        bw.write(realResult + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    public static int dijkstra(int start, int end) {
        dist = new int[N + 1];
        visited = new boolean[N + 1];
        Arrays.fill(dist, INF);
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.cost));
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int curVertex = curNode.end;

            if(!visited[curVertex]){
                visited[curVertex] = true;

                for(Node node : nodes.get(curVertex)){
                    if(!visited[node.end] && dist[curVertex] + node.cost < dist[node.end]){
                        dist[node.end] = dist[curVertex] + node.cost;
                        pq.add(new Node(node.end, dist[node.end]));
                    }
                }
            }
        }

        return dist[end];
    }
}
