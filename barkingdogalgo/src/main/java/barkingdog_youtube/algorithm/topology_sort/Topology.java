package barkingdog_youtube.algorithm.topology_sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 위상 정렬
public class Topology{

    static List<ArrayList<Integer>> graph;
    static int [] degrees;
    static int N = 10;

    public static void main(String[] args) {
        StringBuilder sb= new StringBuilder();
        graph = new ArrayList<>();
        degrees = new int[N+1];

        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }

        makeGraph();

        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=N; i++){
            if(degrees[i] == 0)q.offer(i);
        }

        while(!q.isEmpty()){
            int now = q.poll();
            sb.append(now).append(" ");
            for(int nxt: graph.get(now)){
                degrees[nxt]--;
                if(degrees[nxt] == 0)q.offer(nxt);
            }
        }

        System.out.println(sb);
    }

    private static void makeGraph() {
        graph.get(1).add(5);
        degrees[5] += 1;
        graph.get(5).add(3);
        degrees[3] += 1;
        graph.get(3).add(8);
        degrees[8] += 1;
        graph.get(1).add(6);
        degrees[6] += 1;
        graph.get(2).add(10);
        degrees[10] += 1;
        graph.get(10).add(4);
        degrees[4] += 1;
        graph.get(2).add(9);
        degrees[9] += 1;
        graph.get(9).add(7);
        degrees[7] += 1;
    }
}
