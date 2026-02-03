package barkingdog_youtube.algorithm.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

// 물대기
public class b_1368_learn {

    static class Edge {
        int v1;
        int v2;
        int cost;

        public Edge(int v1, int v2, int cost){
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }

    }

    static int[] parents;
    static PriorityQueue<Edge> pq;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        parents = new int[N+2];
        for (int i=1; i<=N+1; i++){
            parents[i] = i;
        }

        pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.cost));

        for (int i = 1; i <= N; i++) {
            int w = Integer.parseInt(br.readLine());
            pq.offer(new Edge(i, N+1, w));
        }

        for(int i=1; i<=N; i++){
            String []s = br.readLine().split(" ");
            for(int j=1; j<=N; j++){
                if(i==j)continue;
                pq.offer(new Edge(i, j, Integer.parseInt(s[j-1])));
            }
        }

        int result = kruskal();

        System.out.println(result);
    }

    private static int kruskal() {
        int cnt = 0;
        int sum = 0;

        while(cnt < N){
            Edge now = pq.poll();

            if(find(now.v1) != find(now.v2)){
                sum += now.cost;
                cnt++;
                union(now.v1, now.v2);
            }
        }

        return sum;
    }

    private static int find(int x) {
        if(parents[x] == x){
            return x;
        }
        return find(parents[x]);
    }

    private static void union(int v1, int v2) {
        int v1p = find(v1);
        int v2p = find(v2);

        if(v1p <= v2p){
            parents[v2p] = v1p;
        }else{
            parents[v1p] = v2p;
        }
    }
}
