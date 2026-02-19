package it_company_work_book.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// BFS와 DFS
// bfs, dfs

/**
 * 기본적인 dfs, bfs 구현 방법
 * visited 를 사용하지 않는 방법도 존재하는데, 나는 visited 활용하는 방식이 더 좋은듯 하다.
 */
public class BOJ_1260 {

    static int [][] graph;
    static boolean []visited;
    static StringBuilder sb = new StringBuilder();
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String []s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int startV = Integer.parseInt(s[2]);

        graph = new int[N+1][N+1];
        for(int i=0; i<M; i++){
            s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            graph[start][end] = 1;
            graph[end][start] = 1;
        }

        visited = new boolean[N+1];
        dfs(startV);
        sb.append("\n");
        visited = new boolean[N+1];
        bfs(startV);
        System.out.println(sb);
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.offer(start);
        while(!q.isEmpty()){
            int now = q.poll();
            sb.append(now).append(" ");

            for(int i=1; i<=N; i++){
                if(graph[now][i] == 1 && !visited[i]){
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }

    private static void dfs(int start) {
        visited[start] = true;
        sb.append(start).append(" ");
        for(int i=1; i<=N; i++){
            if(graph[start][i] == 1 && !visited[i]){
                dfs(i);
            }
        }
    }
}
