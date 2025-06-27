package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 답 보기 : x
// 메모리 : 66868 kb
// 시간 : 692 ms
public class b_5427 {
    static class Node {
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static Node startNode;
    static List<Node> fireNodes;
    static char[][] graph;
    static boolean[][] visited;
    static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int w;
    static int h;
    static int count;
    static boolean isPossible;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            graph = new char[h][w];
            visited = new boolean[h][w];
            fireNodes = new ArrayList<>();
            count = 1;
            isPossible = false;

            for (int i = 0; i < h; i++) {
                String line = br.readLine();
                for (int j = 0; j < w; j++) {
                    if (line.charAt(j) == '@') {
                        startNode = new Node(i, j);
                        visited[i][j] = true;
                    } else if (line.charAt(j) == '*') {
                        fireNodes.add(new Node(i, j));
                        visited[i][j] = true;
                    } else if (line.charAt(j) == '#') {
                        visited[i][j] = true;
                    }
                    graph[i][j] = line.charAt(j);
                }
            }
            if(startNode.x == 0 || startNode.y == 0 || startNode.x == w - 1 || startNode.y == h - 1){
                isPossible = true;
            }else{
                bfs();
            }

            if(isPossible){
                sb.append(count).append("\n");
            }else {
                sb.append("IMPOSSIBLE").append('\n');
            }
        }
        System.out.println(sb);
    }

    static void bfs() {
        Queue<Node> myStartQ = new ArrayDeque<>();
        Queue<Node> myOnetimeQ = new ArrayDeque<>();
        myStartQ.add(startNode);

        Queue<Node> fireStartQ = new ArrayDeque<>();
        Queue<Node> fireOnetimeQ = new ArrayDeque<>();
        fireStartQ.addAll(fireNodes);

        while (!myStartQ.isEmpty()) {
            count++;
            int fireSize = fireStartQ.size();
            for (int i = 0; i < fireSize; i++) {
                fireOnetimeQ.add(fireStartQ.poll());
            }

            while (!fireOnetimeQ.isEmpty()) {
                Node nowFire = fireOnetimeQ.poll();

                for (int i = 0; i < 4; i++) {
                    int dy = nowFire.y + direction[i][0];
                    int dx = nowFire.x + direction[i][1];

                    if (dy >= 0 && dy < h && dx >= 0 && dx < w && !visited[dy][dx]) {
                        fireStartQ.add(new Node(dy, dx));
                        visited[dy][dx] = true;
                    }
                }
            }

            int mySize = myStartQ.size();
            for (int i = 0; i < mySize; i++) {
                myOnetimeQ.add(myStartQ.poll());
            }
            while (!myOnetimeQ.isEmpty()) {
                Node nowMy = myOnetimeQ.poll();
                for (int i = 0; i < 4; i++) {
                    int dy = nowMy.y + direction[i][0];
                    int dx = nowMy.x + direction[i][1];

                    if (dy >= 0 && dy < h && dx >= 0 && dx < w && !visited[dy][dx]) {
                        if (dy == 0 || dx == 0 || dy == h - 1 || dx == w - 1) {
                            isPossible = true;
                            return;
                        }
                        myStartQ.add(new Node(dy, dx));
                        visited[dy][dx] = true;
                    }
                }
            }
        }
    }
}
