package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

// 토마토
public class b_7576_learn {

    static class Point{
        int y;
        int x;
        int cnt;

        public Point(int y, int x, int cnt){
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }
    }

    static int N;
    static int M;
    static boolean [][] visited;
    static int [] dy = {0, 1, -1, 0};
    static int [] dx = {1, 0, 0, -1};
    static int result;
    static Queue<Point> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] s = br.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        visited = new boolean[M][N];
        q = new ArrayDeque<>();

        for(int i=0; i<M; i++){
            s = br.readLine().split(" ");
            for (int j =0; j<N; j++){
                int num = Integer.parseInt(s[j]);
                if(num == 1){
                    q.add(new Point(i, j, 0));
                    visited[i][j] = true;
                }else if(num == -1){
                    visited[i][j] = true;
                }
            }
        }

        result = -1;
        findMinDaysTomatoByBfs();

        for (int i=0; i<M; i++){
            for (int j=0; j<N; j++){
                if(!visited[i][j]){
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(result);

    }

    private static void findMinDaysTomatoByBfs() {
        while(!q.isEmpty()){
            Point now = q.poll();

            for(int i=0; i<4; i++){
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];

                result = Math.max(result, now.cnt);

                if(validatePoint(ny,nx) && !visited[ny][nx]){
                    q.add(new Point(ny, nx, now.cnt + 1));
                    visited[ny][nx] = true;
                }
            }
        }
    }

    private static boolean validatePoint(int y, int x){
        if(y>=0 && y<M && x >=0 && x<N) return true;
        else return false;
    }
}
