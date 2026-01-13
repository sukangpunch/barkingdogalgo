package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

// 미로 탐색
public class b_2178_learn {

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
    static int endY;
    static int endX;
    static int [][] map;
    static boolean [][] visited;
    static int [] dy = {0, 1, -1, 0};
    static int [] dx = {1, 0, 0, -1};
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] s = br.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        endY = N-1;
        endX = M-1;
        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for (int j =0; j<M; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }

        result = 0;
        findWayToEscapeByBfs(0, 0);

        System.out.println(result);
    }

    private static void findWayToEscapeByBfs(int startY, int startX) {
        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(startY, startX, 1));
        visited[startY][startX] = true;

        while(!q.isEmpty()){
            Point now = q.poll();

            if(now.y == endY && now.x == endX){
                result = now.cnt;
                return;
            }

            for(int i=0; i<4; i++){
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];

                if(validatePoint(ny,nx) && !visited[ny][nx] && map[ny][nx] == 1){
                    q.add(new Point(ny, nx, now.cnt + 1));
                    visited[ny][nx] = true;
                }
            }
        }
    }

    private static boolean validatePoint(int y, int x){
        if(y>=0 && y<N && x >=0 && x<M) return true;
        else return false;
    }
}
