package algorithm.dijkstra;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


// 답 보기 : o
// 메모리 :  kb
// 시간 :  ms
public class b_11779 {

    static class Node{
        int city;
        int cost;

        public Node(int city, int cost) {
            this.city = city;
            this.cost = cost;
        }
    }

    static int n;
    static int m;
    static List<ArrayList<Node>> nodes;
    static int[] distance;
    static boolean[] visited;
    static int [] preCity;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        nodes = new ArrayList<>();

        for(int i=0; i<=n; i++){
            nodes.add(new ArrayList<>());
        }

        preCity = new int[n+1];
        distance = new int[n+1];
        visited = new boolean[n+1];

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            nodes.get(start).add(new Node(end, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        preCity[start] = -1;
        dijkstra(start);
        printResult(end);
    }

    static void dijkstra(int start) {
        Arrays.fill(distance, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.cost));
        pq.offer(new Node(start, 0));
        distance[start] = 0;

        while(!pq.isEmpty()){
            Node now = pq.poll();

            if(visited[now.city])continue;

            visited[now.city] = true;

            for(Node next: nodes.get(now.city)){
                if(distance[next.city] > distance[now.city] + next.cost){}{
                    distance[next.city] = distance[now.city] + next.cost;
                    preCity[next.city] = now.city;
                    pq.offer(new Node(next.city, distance[next.city]));
                }
            }
        }
    }

    private static void printResult(int end) {
        Deque<Integer> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        sb.append(distance[end]).append("\n");

        int idx = end;
        while(idx != -1){
            dq.offer(idx);
            idx = preCity[idx];
        }

        sb.append(dq.size()).append("\n");
        while(!dq.isEmpty()){
            idx = dq.pollLast();
            sb.append(idx).append(" ");
        }

        System.out.println(sb);
    }
}
