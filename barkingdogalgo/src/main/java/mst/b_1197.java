package mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class b_1197 {
    static class Node{
        int start;
        int end;
        int cost;

        public Node(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

    static int [] parents;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        parents = new int[V+1];

        for(int i = 1; i <= V; i++){
            parents[i] = i;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.cost - n2.cost);

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            pq.add(new Node(A,B,C));
        }


        int result = 0;
        for(int i=0; i<E; i++){
            Node now = pq.poll();
            int nowStart = now.start;
            int nowEnd = now.end;
            int nowCost = now.cost;

            if(find(nowStart) != find(nowEnd)){
                result += nowCost;
                union(nowStart, nowEnd);
            }
        }

        System.out.println(result);
    }

    static void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        parents[Math.max(rootA,rootB)] = Math.min(rootA,rootB);
    }

    static int find(int x){
        if(x != parents[x]){
            parents[x] = find(parents[x]);
        }
        return parents[x];
    }

}
