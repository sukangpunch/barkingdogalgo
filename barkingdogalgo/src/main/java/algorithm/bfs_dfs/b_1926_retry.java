package algorithm.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 그림
public class b_1926_retry {

    static class Node{
        int y;
        int x;

        public Node(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    static int n;
    static int m;
    static int [][] graph;
    static boolean[][] visited;
    static int[][] direction = {{0,1},{1,0},{0,-1},{-1,0}};
    static int count;
    static int pictureSize;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int [n][m];
        visited = new boolean[n][m];
        count = 0;
        pictureSize = 0;

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(!visited[i][j] && graph[i][j] == 1) {
                    count++;
                    int result = bfsPicture(i, j);
                    if(pictureSize < result) {
                        pictureSize = result;
                    }
                }
            }
        }

        System.out.println(count);
        System.out.println(pictureSize);

        br.close();
    }

    private static int bfsPicture(int y, int x) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(y, x));
        visited[y][x] = true;
        int size=0;

        while(!q.isEmpty()) {
            Node now = q.poll();
            size++;

            for(int i=0; i<direction.length; i++) {
                int dy = now.y + direction[i][0];
                int dx = now.x + direction[i][1];

                if(dy >= 0 && dy < n && dx >= 0 && dx < m && !visited[dy][dx] && graph[dy][dx] == 1) {
                    q.add(new Node(dy, dx));
                    visited[dy][dx] = true;
                }
            }
        }

        return size;
    }
}
