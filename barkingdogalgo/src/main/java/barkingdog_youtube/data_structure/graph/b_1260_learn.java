package barkingdog_youtube.data_structure.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// DFS와 BFS
public class b_1260_learn {

    static int [][] graph;
    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();
    static boolean []visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
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
        dfs_no_re(startV);
        sb.append("\n");
        bfs(startV);

        System.out.println(sb);
    }

    private static void bfs(int start) {
        visited = new boolean[N+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        sb.append(start).append(" ");

        while(!q.isEmpty()){
            int now = q.poll();

            for(int i=1; i<=N; i++){
                if(graph[now][i] ==1 && !visited[i]){
                    visited[i] = true;
                    q.add(i);
                    sb.append(i).append(" ");
                }
            }
        }
        sb.append("\n");
    }

    private static void dfs_no_re(int start){
        Stack<Integer> st = new Stack<>();
        st.add(start);

        while(!st.isEmpty()){
            int now = st.pop();
            if(visited[now])continue;

            visited[now] = true;
            sb.append(now).append(" ");

            for(int i=N; i>0; i--){ // dfs 특성상 스택에 큰 index 부터 넣어야함(순서 관련해서)
                if(graph[now][i] == 1 && !visited[i]){
                    st.push(i);
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
