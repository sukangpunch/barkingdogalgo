package it_company_work_book.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

// 택배 배송
// 다익스트라
/**
 * 시간복잡도 : O(NLogN)
 * 전형적인 다익스트라 문제
 * List 구조를 활용해서  start : [(end, cost), (end, cost), (end, cost)] 형식으로 그래프를 받는다.
 * distance 배열을 통해, 1번에서 N 까지 가는데 정점 별 최저 값을 업데이트 한다.
 * 우선순위 큐와 visited 배열을 통해 이미 방문한 지점이 가장 최저 값임을 책임지고, 두 번 방문하지 않게 한다.
 * n 정점에서 갈 수 있는 정점을을 전부 우선순위 큐에 담고, 적은 cost 별로 뽑아서 반복,
 * distance의 값보다 현재 정점의 distance + 현재 정점에서 다음 정점으로 가는 cost의 합이 작다면 다음 정점 distance 업데이트
 */
public class BOJ_5972 {

    static class Cow implements Comparable<Cow>{
        int v;
        int cost;

        public Cow(int v, int cost){
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Cow o) {
            return this.cost - o.cost;
        }
    }

    static List<ArrayList<Cow>> node;
    static boolean [] visited;
    static int [] distance;

    static final int MAX = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        visited = new boolean[N+1];
        distance = new int[N+1];
        node = new ArrayList<>();
        for(int i=0; i<=N; i++) {
            node.add(new ArrayList<>());
        }

        for(int i=0;i <M; i++){
            s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            int cost = Integer.parseInt(s[2]);

            node.get(start).add(new Cow(end, cost));
            node.get(end).add(new Cow(start, cost));
        }

        dijkstra();
        System.out.println(distance[N]);
    }

    private static void dijkstra() {
        Arrays.fill(distance, MAX);
        PriorityQueue<Cow> pq = new PriorityQueue<>();
        pq.add(new Cow(1,0));
        distance[1] = 0;

        while(!pq.isEmpty()){
            Cow now = pq.poll();

            if(visited[now.v]){
                continue;
            }

            visited[now.v] = true;

            for(Cow next: node.get(now.v)){
                if(distance[next.v] > distance[now.v] + next.cost){
                    distance[next.v] = distance[now.v] + next.cost;
                    pq.offer(new Cow(next.v, distance[next.v]));
                }
            }
        }
    }
}
