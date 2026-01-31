package barkingdog_youtube.data_structure.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 연결 요소의 개수
// 인접리스트로 했을 때 시간초과 왜?
public class b_11724_learn {

    static int N;
    static int [][] graph;
    static boolean [] visited;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        graph = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int i=0; i<M; i++){
            s = br.readLine().split(" ");
            int u = Integer.parseInt(s[0]);
            int v = Integer.parseInt(s[1]);
            graph[u][v] = 1;
            graph[v][u] = 1;
        }

        for(int i=1; i<=N; i++){
            if(!visited[i]){
                dfs(i);
            }
        }

        System.out.println(result);
    }

    private static void dfs(int start) {
        result += 1;
        Stack<Integer> st = new Stack<>();
        st.add(start);
        visited[start] = true;

        while(!st.isEmpty()){
            int now = st.pop();

            for(int i=1; i<=N; i++){
                if(graph[now][i] != 0 && !visited[i]){
                    st.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
