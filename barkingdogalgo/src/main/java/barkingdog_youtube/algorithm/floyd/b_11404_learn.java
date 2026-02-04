package barkingdog_youtube.algorithm.floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 플로이드
public class b_11404_learn {

    static int [][] graph;
    static int N;
    static int NO_EDGE = 987654321; // 플로이드 계산 도중 NO_EDGE + NO_EDGE 연산이 발생할 수 있어서 오버플로우가 나지 않는 값으로 정해야함
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        graph = new int[N+1][N+1];

        for(int[] row : graph){
            Arrays.fill(row, NO_EDGE);
        }

        for(int i=0; i<M; i++){
            String [] s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            int cost = Integer.parseInt(s[2]);
            graph[start][end] = Math.min(graph[start][end], cost);
        }

        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                if(k==i)continue;
                for(int j=1; j<=N; j++){
                    if(i==j){
                        graph[i][j] = 0;
                        continue;
                    }else if(j==k){
                        continue;
                    }
                    // 연산보다 대입이 느리므로 min 말고 조건 - 대입 형식으로 꼭 필요할때만 대입하게 하는게 더 빠르다.
                    // graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                    if(graph[i][j] > graph[i][k] + graph[k][j]){
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }

        for(int i=1; i<=N;i++){
            for(int j=1; j<=N; j++){
                sb.append(graph[i][j] == NO_EDGE ? 0 : graph[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
