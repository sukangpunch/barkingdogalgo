package it_company_work_book.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 쉬운 최단거리
// bfs
/**
 * 기본적인 bfs 문제,
 * 출발 지점부터 시작하여, 갈 수 있는 곳을 전부 체크 후 q에 넣는다.
 * 이 때, q에 y,x,cost 값을 넣어서, 해당 위치에서의 cost값을 업데이트 해 나간다.
 * 해당 위치에서 뻗어나가는 곳은 해당 cost 기반으로 업데이트 하게 된다.
 * 갈 수 없는 곳은 map 에서 1인데, result 에서 0인 부분
 */
public class BOJ_14940 {

    static class Vertex{
        int y;
        int x;
        int cost;

        public Vertex(int y, int x, int cost){
            this.y = y;
            this.x = x;
            this.cost = cost;
        }
    }

    static int [][]map;
    static boolean[][] visited;
    static int [][] result;
    static int [][] direction = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String []s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        map = new int[N][M];
        visited = new boolean[N][M];
        result = new int[N][M];

        int startY = -1;
        int startX = -1;
        for(int i=0; i<N; i++){
            s = br.readLine().split(" ");
            for(int j=0; j<M; j++){
                int num = Integer.parseInt(s[j]);
                if(num == 2){
                    startY = i;
                    startX = j;
                }
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        bfs(startY, startX);

        for(int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                if(map[i][j] == 1 && result[i][j] == 0){
                    sb.append(-1).append(" ");
                }else{
                    sb.append(result[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void bfs(int startY, int startX) {
        visited[startY][startX] = true;
        result[startY][startX] = 0;
        Queue<Vertex> q = new LinkedList<>();
        q.offer(new Vertex(startY, startX, 0));

        while(!q.isEmpty()){
            Vertex now = q.poll();

            for(int i=0; i<4; i++){
                int dy = now.y + direction[i][0];
                int dx = now.x + direction[i][1];

                if(dy >= 0 && dx >=0 && dy < N && dx < M &&
                        !visited[dy][dx] && map[dy][dx] != 0){
                    visited[dy][dx] = true;
                    int cost = now.cost + 1;
                    q.offer(new Vertex(dy, dx, cost));
                    result[dy][dx] = cost;
                }
            }
        }
    }
}
