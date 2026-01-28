package algorithm.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 답 보기 : x
// 메모리 : 115420 kb
// 시간 :  596 ms
public class b_7569 {
    static class Node {
        private int z;
        private int y;
        private int x;

        public Node(int z, int y, int x) {
            this.z = z;
            this.y = y;
            this.x = x;
        }

        public Node() {
        }
    }

    static int[][] direction = {{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};
    static boolean[][][] visited;
    static Queue<Node> startNodes;
    static int days = -1;
    static int N;
    static int M;
    static int H;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        visited = new boolean[H][M][N];
        startNodes = new ArrayDeque<>();
        boolean AllTomatoRipen = true;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    int now = Integer.parseInt(st.nextToken());
                    if (now == 1) {
                        startNodes.add(new Node(i, j, k));
                        visited[i][j][k] = true;
                    } else if(now == -1){
                        visited[i][j][k] = true;
                    }else{
                        AllTomatoRipen = false;
                    }
                }
            }
        }

        // 모든 토마토가 익은 경우
        if (AllTomatoRipen) {
            System.out.println("0");
            return;
        }

        // 토마토 익히기 시작
        bfs();

        // 모든 토마토가 익지 않은 경우
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    if (!visited[i][j][k]) {
                        System.out.println("-1");
                        return;
                    }
                }
            }
        }

        System.out.println(days);
    }

    static void bfs() {

        while (!startNodes.isEmpty()) {
            days++;
            Queue<Node> dayOfNodes = new ArrayDeque<>();
            int size=  startNodes.size();
            for (int i = 0; i < size; i++) {
                dayOfNodes.offer(startNodes.poll());
            }

            while (!dayOfNodes.isEmpty()) {
                Node now = dayOfNodes.poll();
                for (int i = 0; i < direction.length; i++) {
                    int dz = now.z + direction[i][0];
                    int dy = now.y + direction[i][1];
                    int dx = now.x + direction[i][2];

                    if (dz >= 0 && dz < H && dy >= 0 && dy < M && dx >= 0 && dx < N && !visited[dz][dy][dx]) {
                        visited[dz][dy][dx] = true;
                        startNodes.add(new Node(dz, dy, dx));
                    }
                }
            }
        }
    }
}

