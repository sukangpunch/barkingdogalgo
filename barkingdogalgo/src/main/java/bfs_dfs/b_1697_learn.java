package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

// 숨바꼭질
public class b_1697_learn {

    static class Point{
        int x;
        int cnt;

        public Point(int x, int cnt){
            this.x = x;
            this.cnt = cnt;
        }
    }

    static int result;
    static int [] map;
    static boolean [] visited;
    static int [] dx = {2, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] s = br.readLine().split(" ");

        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);

        map = new int[200000];
        visited = new boolean[200000];

        findKid(N, K);

        System.out.println(result);
    }

    private static void findKid(int subin, int kid) {
        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(subin, 0));

        while(!q.isEmpty()){
            Point now = q.poll();

            if(now.x == kid){
                result = now.cnt;
                return;
            }

            for(int i=0; i<3; i++){
                if(dx[i] == 2){
                    int nx = now.x * 2;

                    if(nx<200000 && nx>=0 && !visited[nx]){
                        q.add(new Point(nx, now.cnt+1));
                        visited[nx] = true;
                    }
                }else{
                    int nx = now.x + dx[i];
                    if(nx<200000 && nx>=0 && !visited[nx]){
                        q.add(new Point(nx, now.cnt+1));
                        visited[nx] = true;
                    }
                }
            }
        }
    }
}
