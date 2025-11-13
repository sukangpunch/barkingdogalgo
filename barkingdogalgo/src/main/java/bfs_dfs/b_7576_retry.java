package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


// 토마토
public class b_7576_retry {
    static class Point{
        int y;
        int x;
        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int N;
    static int M;
    static boolean[][] visited;
    static ArrayList<Point> start;
    static int [][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] str = br.readLine().split(" ");

        M = Integer.parseInt(str[0]);
        N = Integer.parseInt(str[1]);

        start = new ArrayList<>();
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            String[] input = br.readLine().split(" ");
            for(int j=0; j<M; j++){
                int num = Integer.parseInt(input[j]);
                if(num == 1){
                    start.add(new Point(i, j));
                }
                else if(num == -1){
                    visited[i][j] = true;
                }
            }
        }

        calculateTomatoes();

        if(checkTomatoes()){
            System.out.println(count-1);
        }else{
            System.out.println(-1);
        }
    }

    private static boolean checkTomatoes() {
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!visited[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    private static void calculateTomatoes() {
        Queue<Point> q = new LinkedList<>();
        for(Point p : start){
            visited[p.y][p.x] = true;
            q.offer(p);
        }

        Queue<Point> qNow = new LinkedList<>();

        while(!q.isEmpty()){
            count++;
            int size = q.size();
            for(int i=0; i<size; i++){
                qNow.offer(q.poll());
            }

            while(!qNow.isEmpty()){
                Point now = qNow.poll();

                for(int i=0; i<direction.length; i++){
                    int dy = now.y + direction[i][0];
                    int dx = now.x + direction[i][1];

                    if(dy>= 0 && dy < N && dx>= 0 && dx < M && !visited[dy][dx]){
                        q.offer(new Point(dy,dx));
                        visited[dy][dx] = true;
                    }
                }
            }
        }
    }
}
