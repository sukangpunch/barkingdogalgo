package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.*;

public class b_1504 {

    static int N;
    static int E;
    static int [][] map;
    static long [] distance;
    static boolean [] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = parseInt(st.nextToken());
        E = parseInt(st.nextToken());

        map = new int[N+1][N+1];

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                map[i][j] = MAX_VALUE;
            }
        }

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int a = parseInt(st.nextToken());
            int b = parseInt(st.nextToken());
            int c = parseInt(st.nextToken());
            map[a][b] = c;
            map[b][a] = c;
        }

        st = new StringTokenizer(br.readLine());
        int mustVertex1 = parseInt(st.nextToken());
        int mustVertex2 = parseInt(st.nextToken());

        long result1 =0;
        result1 += findShortestPath(1, mustVertex1);
        result1 += findShortestPath(mustVertex1, mustVertex2);
        result1 += findShortestPath(mustVertex2, N);

        long result2 =0;
        result2 += findShortestPath(1, mustVertex2);
        result2 += findShortestPath(mustVertex2, mustVertex1);
        result2 += findShortestPath(mustVertex1, N);

        long result = ((result1 >= MAX_VALUE) && (result2 >= MAX_VALUE)) ? -1 : Math.min(result1, result2);
        System.out.println(result);

    }

    private static long findShortestPath(int v, int target) {
        distance = new long[N+1];
        visited = new boolean[N+1];
        Arrays.fill(distance, MAX_VALUE);
        distance[v] = 0;
        visited[v] = true;

        for(int i=1; i<=N; i++){
            if(!visited[i] && map[v][i] != MAX_VALUE){
                distance[i] = map[v][i];
            }
        }

        for(int i=1; i<=N-1; i++){
            long min = MAX_VALUE;
            int min_index = -1;

            for(int j=1; j<=N; j++){
                if(!visited[j]){
                    if(distance[j] < min){
                        min = distance[j];
                        min_index = j;
                    }
                }
            }

            if(min_index == -1){
                break;
            }

            visited[min_index] = true;
            for(int j=1; j <= N; j++){
                if(!visited[j] && map[min_index][j] != MAX_VALUE){
                    if(distance[min_index] + map[min_index][j] < distance[j]){
                        distance[j] = distance[min_index] + map[min_index][j];
                    }
                }
            }
        }

        return distance[target];
    }
}
