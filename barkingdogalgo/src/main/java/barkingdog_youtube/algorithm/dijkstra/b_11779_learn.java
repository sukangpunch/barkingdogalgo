package barkingdog_youtube.algorithm.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

// 최소 비용 구하기 2
public class b_11779_learn {

    static class Node{
        int v;
        int cost;

        public Node(int v, int cost){
            this.v = v;
            this.cost = cost;
        }
    }

    static List<ArrayList<Node>> graph;
    static int [] distance;
    static final int NO_EDGE = 987654321;
    static int [] pre;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }

        distance = new int[N+1];
        for(int i=1; i<=N; i++){
            distance[i] = NO_EDGE;
        }

        pre = new int[N+1];

        for(int i=0; i<M; i++){
            String []s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            int cost = Integer.parseInt(s[2]);
            graph.get(start).add(new Node(end, cost));
        }

        String [] s = br.readLine().split(" ");
        int start =  Integer.parseInt(s[0]);
        int end = Integer.parseInt(s[1]);

        dijkstra(start);
        sb.append(distance[end]).append("\n");
        Stack<Integer> st = new Stack<>();
        st.push(end);
        int tmp = pre[end];
        int cnt = 1;
        while(true){
            cnt++;
            st.push(tmp);
            tmp = pre[tmp];
            if(tmp == 0)break;
        }

        sb.append(cnt).append("\n");
        while(!st.isEmpty()){
            sb.append(st.pop()).append(" ");
        }

        System.out.println(sb);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt((n) -> n.cost));
        distance[start] = 0;
        pq.offer(new Node(start, distance[start]));

        while(!pq.isEmpty()){
            Node now = pq.poll();

            if(distance[now.v] != now.cost)continue;
            for(Node nxt: graph.get(now.v)){
                if(distance[nxt.v] > distance[now.v] + nxt.cost){
                    distance[nxt.v] = distance[now.v] + nxt.cost;
                    pq.offer(new Node(nxt.v, distance[nxt.v]));
                    pre[nxt.v] = now.v;
                }
            }
        }
    }
}
