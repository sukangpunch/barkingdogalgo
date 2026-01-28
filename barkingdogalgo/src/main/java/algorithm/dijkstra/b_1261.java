package algorithm.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 알고스팟
public class b_1261 {

    static class Point implements Comparable<Point>{
        int y;
        int x;
        int cnt;

        Point(int y, int x, int cnt){
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Point o) {
            return cnt - o.cnt;
        }
    }

    static int N;
    static int M;
    static int [][] map;
    static boolean [][] visited;
    static int [][] direction = {{0,1}, {0,-1}, {1,0}, {-1,0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String []s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        map = new int[M][N];
        visited = new boolean[M][N];

        for(int i=0; i<M; i++){
            String str = br.readLine();
            for(int j=0; j<N; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }

        int minBreak = findMinBreak();
        System.out.println(minBreak);
    }

    private static int findMinBreak() {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.offer(new Point(0, 0, 0));
        visited[0][0] = true;

        while(!pq.isEmpty()){
            Point now = pq.poll();

            if(now.y == M-1 && now.x == N-1){
                return now.cnt;
            }

            for(int i=0; i<4; i++){
                int dy = now.y + direction[i][0];
                int dx = now.x + direction[i][1];

                if(dy < 0 || dy >= M || dx < 0 || dx >= N){
                    continue;
                }

                if(map[dy][dx] == 0 && !visited[dy][dx]){
                    visited[dy][dx] = true;
                    pq.offer(new Point(dy, dx, now.cnt));
                }

                if(map[dy][dx] == 1 && !visited[dy][dx]){
                    visited[dy][dx] = true;
                    pq.offer((new Point(dy,dx, now.cnt + 1)));
                }
            }
        }
        return 0;
    }
}
