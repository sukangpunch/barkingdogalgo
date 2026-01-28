package algorithm.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 유기농 배추
public class b_1012_retry {

    static boolean[][] visited;
    static int [][] graph;
    static int N;
    static int M;
    static int [][] direction = {{0,1},{1,0},{0,-1},{-1,0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            visited = new boolean[N][M];
            graph = new int[N][M];

            for(int j = 0; j<K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                graph[y][x] = 1;
            }

            int count = calculateCabbageBugCount();
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    private static int calculateCabbageBugCount() {
        int count = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(graph[i][j] == 1 && !visited[i][j]){
                    measureField(i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private static void measureField(int y, int x) {
        Queue<int []> cabbages = new LinkedList<>();
        cabbages.add(new int [] {y, x});
        visited[y][x] = true;

        while(!cabbages.isEmpty()){
            int [] cabbage = cabbages.poll();
            for(int i=0; i< direction.length; i++){
                int dy = cabbage[0] + direction[i][0];
                int dx = cabbage[1] + direction[i][1];

                if(dy >= 0 && dy < N && dx >= 0 && dx < M && graph[dy][dx] == 1 && !visited[dy][dx]){
                    visited[dy][dx] = true;
                    cabbages.add(new int [] {dy,dx});
                }
            }
        }
    }

}
