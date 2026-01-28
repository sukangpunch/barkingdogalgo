package algorithm.floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 플로이드
public class b_11404 {

    static int N;
    static int M;
    static int [][] map;

    static final int MAX = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(i==j) map[i][j] = 0;
                else{
                    map[i][j] = MAX;
                }
            }
        }

        for(int i=0; i<M; i++){
            String [] s = br.readLine().split(" ");

            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            int cost = Integer.parseInt(s[2]);
            map[start][end] = Math.min(map[start][end], cost);
        }
        findAllVertexShortestWay();

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(map[i][j]== MAX){
                    sb.append(0).append(" ");
                }else{
                    sb.append(map[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void findAllVertexShortestWay() {
        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                if(map[i][k] == MAX) continue;
                for(int j=1; j<=N; j++){
                    if(map[k][j] == MAX)continue;

                    if(map[i][j] > map[i][k] + map[k][j]){
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }
    }
}
