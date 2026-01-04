package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

// 경로 찾기
public class b_11403 {

    static int [][] graph;
    static int [][] result;
    static int [][] visited;

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        result = new int[N][N];

        for(int i = 0; i < N; i++){
            String [] s = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                graph[i][j] = Integer.parseInt(s[j]);
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                visited = new int[N][N];
                boolean canWay = findAllWay(i, j);
                if(canWay){
                    result[i][j] = 1;
                }
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean findAllWay(int start, int end) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);

        while(!q.isEmpty()){
            int now = q.poll();

            for(int i=0; i<N; i++){
                if(graph[now][i] == 1 && visited[now][i] == 0){
                    if(end == i){
                        return true;
                    }

                    visited[now][i] = 1;
                    q.add(i);
                }
            }
        }

        return false;
    }

}
