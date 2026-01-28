package algorithm.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 답 보기 : o(gpt 에게 질문)
// 메모리 : 15872 kb
// 시간 :  136 ms
public class b_1012 {
    static class Node{
        private int y;
        private int x;
        public Node(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    static int [][] direction = {{0,1},{1,0},{-1,0},{0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int z = 0; z < T; z++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int [][]map = new int[N][M];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                map[Y][X] = 1;
            }

            int count =0;
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(map[i][j]==1){
                        countBug(map,i,j,N,M);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    private static void countBug(int [][]map, int y, int x,int n, int m) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(y,x));
        map[y][x] = -1;

        while (!q.isEmpty()) {
            Node now = q.poll();
            for (int k = 0; k < 4; k++) {
                int dy = now.y + direction[k][0];
                int dx = now.x + direction[k][1];

                if (dy >= 0 && dy < n && dx >= 0 && dx < m) {
                    if (map[dy][dx] == 1) {
                        q.add(new Node(dy,dx));
                        map[dy][dx] = -1;
                    }
                }
            }
        }
    }
}
