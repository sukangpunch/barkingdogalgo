package barkingdog_youtube.algorithm.topology_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 줄세우기
public class b_2252_learn {

    static List<ArrayList<Integer>> graph;
    static int [] degrees;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String []s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        graph = new ArrayList<>();
        degrees = new int[N+1];

        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            s = br.readLine().split(" ");
            int start =  Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            graph.get(start).add(end);
            degrees[end]++;
        }

        Queue<Integer> q =  new LinkedList<>();
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
}
