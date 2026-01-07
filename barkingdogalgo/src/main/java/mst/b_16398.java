package mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 행성 연결
public class b_16398 {

    static class Flow{
        int start;
        int end;
        int cost;

        public Flow(int start, int end, int cost){
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

    static PriorityQueue<Flow> pq;
    static int [] parents;
    static long result;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        parents = new int[N+1];
        for(int i=1; i<=N; i++){
            parents[i] = i;
        }

        pq = new PriorityQueue<>((n1, n2) -> n1.cost - n2.cost);
        result = 0;

        for(int i=1; i<=N; i++){
            String [] s = br.readLine().split(" ");

            for(int j=1; j<=N; j++){
                if(i==j){
                    continue;
                }
                int start = i;
                int end = j;
                int cost = Integer.parseInt(s[j-1]);
                pq.offer(new Flow(start, end, cost));
            }
        }

        findMinimumFlow();

        System.out.println(result);
    }

    private static void findMinimumFlow() {
        int edgeCount = 0;

        while(!pq.isEmpty()){
            Flow now = pq.poll();
            if(find(now.start) != find(now.end)){
                union(now.start, now.end);
                result += now.cost;
                edgeCount++;

                if(edgeCount == N-1){
                    return;
                }
            }
        }
    }

    private static int find(int v){
        if(parents[v] == v){
            return v;
        }

        parents[v] = find(parents[v]);
        return parents[v];
    }

    private static void union(int v1, int v2){
        int p1 = find(v1);
        int p2 = find(v2);

        if(p1 < p2){
            parents[p2] = p1;
        }else{
            parents[p1] = p2;
        }
    }
}
