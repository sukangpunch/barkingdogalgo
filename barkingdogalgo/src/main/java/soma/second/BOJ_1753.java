package soma.second;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// 최단경로
// 다익스트라

/**
 * 다익스트라 기본적인 문제
 * List<ArrayList<Node>> 를 활용하여 특정 정점에서 이동할 수 있는 다른 정점들을  List로 받는다.
 * 또한 PriorityQueue를 활용하여, 이동할 수 있는 다른 정점, 혹은 같은 정점이어도 가중치가 적은 것 부터 처리
 * 그리고 distance 배열은 항상 시작점 제외 max값으로 채워야한다.
 * if(distance[now.v] != now.cost) 로 가지치기 하는 이유는, now 는 최소값을 업데이트하고 이동한 정점인데 값이 다르다는 것은 최저경로로 온 now값이 아니기 떄문
 * 한 정점으로 여러 길이 존재하기 떄문에 그 중에서 최소를 찾아야함(PriorityQueue + distance 에는 항상 최소만 업데이트)
 * PriorityQueue 는 타입 클래스에 직접 Comparable로 정렬 조건을 셋팅하던가 Comparator.comparingInt(n->n.cost) 처럼 람다로 정렬 조건을 지정해줘야함
 */
public class BOJ_1753 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int V = Integer.parseInt(s[0]);
        int E = Integer.parseInt(s[1]);
        int K = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            s = br.readLine().split(" ");
            int u = Integer.parseInt(s[0]);
            int v = Integer.parseInt(s[1]);
            int w = Integer.parseInt(s[2]);
            graph.get(u).add(new Node(v, w));
        }

        int[] result = solution(V, E, K);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < result.length; i++) {
            if (result[i] == MAX) {
                sb.append("INF").append("\n");
            } else {
                sb.append(result[i]).append("\n");
            }
        }

        System.out.println(sb);
    }

    static class Node implements Comparable<Node> {

        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node n) {
            return this.cost - n.cost;
        }
    }

    static int[] distance;
    static final int MAX = 987654321;
    static List<ArrayList<Node>> graph;

    private static int[] solution(int V, int E, int K) {
        distance = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            distance[i] = MAX;
        }

        dijkstra(K);

        return distance;
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        distance[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (distance[now.v] != now.cost) {
                continue;
            }
            for (Node next : graph.get(now.v)) {
                if (distance[next.v] > distance[now.v] + next.cost) {
                    distance[next.v] = distance[now.v] + next.cost;
                    pq.offer(new Node(next.v, distance[next.v]));
                }
            }
        }
    }
}
