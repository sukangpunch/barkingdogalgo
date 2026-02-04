package barkingdog_youtube.algorithm.floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// 플로이드 2
public class b_11780_learn {

    static int[][] graph;
    static int[][] next;
    static int NO_EDGE = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        graph = new int[N + 1][N + 1];
        next = new int[N + 1][N + 1];

        for (int[] nxt : graph) {
            Arrays.fill(nxt, NO_EDGE);
        }

        for (int i = 0; i < M; i++) {
            String[] s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            int cost = Integer.parseInt(s[2]);

            graph[start][end] = Math.min(graph[start][end], cost);
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(graph[i][j] != NO_EDGE){
                    next[i][j] = j;
                }
            }
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                if (k == i) {continue;}
                for (int j = 1; j <=N; j++) {
                    if (i == j) {
                        graph[i][j] = 0;
                        continue;
                    } else if (j == k) {
                        continue;
                    }

                    if(graph[i][j] > graph[i][k] + graph[k][j]){
                        graph[i][j] = graph[i][k] + graph[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                sb.append(graph[i][j] == NO_EDGE ? 0 : graph[i][j]).append(" ");
            }
            sb.append("\n");
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(i==j || graph[i][j] == NO_EDGE){
                    sb.append(0).append("\n");
                    continue;
                }

                Queue<Integer> queue = new LinkedList<>();
                int tmp = i;
                while(tmp != j){
                    queue.offer(tmp);
                    tmp = next[tmp][j];
                }
                queue.offer(j);
                sb.append(queue.size()).append(" ");
                while(!queue.isEmpty()){
                    sb.append(queue.poll()).append(" ");
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}
