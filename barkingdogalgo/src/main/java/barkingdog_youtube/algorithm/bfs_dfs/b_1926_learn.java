package barkingdog_youtube.algorithm.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

// 그림
public class b_1926_learn {

    static class Point{
        int y;
        int x;

        public Point(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    static int N;
    static int M;
    static int [][] map;
    static boolean [][] visited;
    static int [] dy = {0, 1, -1, 0};
    static int [] dx = {1, 0, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] s = br.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        int pictureCount = 0;
        int maxPictureSize = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!visited[i][j] && map[i][j] == 1){
                    pictureCount++;
                    int pictureSize = findPaintingWithBfs(i, j);
                    maxPictureSize = Math.max(maxPictureSize, pictureSize);
                }
            }
        }
        sb.append(pictureCount).append("\n");
        sb.append(maxPictureSize).append("\n");

        System.out.println(sb);
    }

    private static int findPaintingWithBfs(int y, int x) {
        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(y, x));
        visited[y][x] = true;

        int pictureSize = 0;
        pictureSize++;

        while(!q.isEmpty()){
            Point now = q.poll();

            for(int i=0; i<4; i++){
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];

                if(validatePoint(ny, nx) && map[ny][nx] == 1 &&!visited[ny][nx]){
                    q.add(new Point(ny, nx));
                    visited[ny][nx] = true;
                    pictureSize++;
                }
            }
        }
        return pictureSize;
    }

    private static boolean validatePoint(int y, int x){
        if(y>=0 && y<N && x >=0 && x<M) return true;
        else return false;
    }
}
