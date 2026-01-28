package algorithm.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 답 보기 :x
// 메모리 : 14684 kb
// 시간 : 116ms
public class b_2178 {
    static class Node{
        private int x;
        private int y;
        private int cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    static int [][] direction = {{0,1},{1,0},{0,-1},{-1,0}};
    static int [][] map;
    static boolean[][] visited;
    static int N;
    static int M;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        result = 0;
        bfs();
        System.out.println(result);
    }

    static void bfs(){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0, 1));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            int x = now.x;
            int y = now.y;
            int cnt = now.cnt;

            for(int i=0; i<4; i++) {
                int dx = x + direction[i][1];
                int dy = y + direction[i][0];

                if(dy<0 || dy>=N || dx<0 || dx>=M){
                    continue;
                }

                if(!visited[dy][dx] && map[dy][dx] == 1){
                    if(dy == N-1 && dx == M-1){
                        result = cnt+1;
                    }
                    queue.offer(new Node(dx, dy, cnt+1));
                    visited[dy][dx] = true;
                }
            }
        }
    }
}
