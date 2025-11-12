package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 벽 부수고 이동하기
// 시간초과
public class b_2206 {

    static class Node {
        int y;
        int x;
        boolean broke;
        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int N;
    static int M;
    static int [][]graph;
    static boolean [][]visited;
    static int result;
    static int [][] direction = {{0,1},{1,0},{0,-1},{-1,0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        visited = new boolean[N][M];

        if(N == 1 && M == 1){
            System.out.println(1);
            return;
        }

        for(int i=0;i<N;i++){
            String input = br.readLine();
            for(int j=0;j<M;j++){
                graph[i][j] = input.charAt(j) - '0';
            }
        }
        result = Integer.MAX_VALUE;
        findWay(0, 0);

        if(result == Integer.MAX_VALUE){
            result = -1;
        }

        System.out.println(result);
    }

    static void findWay(int y, int x){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(y, x));
        visited[y][x] = true;
        Queue<Node> nowQ = new LinkedList<>();

        int count = 0;

        while(!q.isEmpty()){
            count++;
            int size = q.size();
            for(int i=0;i<size;i++){
                nowQ.add(q.poll());
            }

            while(!nowQ.isEmpty()){
                Node now = nowQ.poll();
                for(int i = 0; i<direction.length; i++){
                    int dy = now.y + direction[i][0];
                    int dx = now.x + direction[i][1];
                    if(dy == N-1 && dx == M-1){
                        count++;
                        result = Math.min(count, result);
                    }
                    if(dy >=0 && dy < N && dx>=0 && dx < M && !visited[dy][dx]){
                        if(graph[dy][dx]==0){
                            visited[dy][dx] = true;
                            q.add(new Node(dy,dx));
                            continue;
                        }

                        if(graph[dy][dx]==1){
                            int newResult = findWay2(dy, dx, count);
                            if(newResult != -1){
                                result = Math.min(newResult, result);
                            }
                        }
                    }

                }
            }
        }
    }

    static int findWay2(int y, int x, int newCount){
        boolean[][] newVisited = new boolean[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                newVisited[i][j] = visited[i][j];
            }
        }
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(y, x));
        newVisited[y][x] = true;
        Queue<Node> nowQ = new LinkedList<>();
        while(!q.isEmpty()){
            newCount++;
            int size = q.size();
            for(int i=0;i<size;i++){
                nowQ.add(q.poll());
            }

            while(!nowQ.isEmpty()){
                Node now = nowQ.poll();
                for(int i = 0; i<direction.length; i++){
                    int dy = now.y + direction[i][0];
                    int dx = now.x + direction[i][1];
                    if(dy == N-1 && dx == M-1){
                        newCount++;
                        return newCount;
                    }
                    if(dy>=0 && dy < N && dx>=0 && dx < M && !newVisited[dy][dx] && graph[dy][dx]==0){
                        newVisited[dy][dx] = true;
                        q.add(new Node(dy,dx));
                    }
                }
            }
        }
        return -1;
    }
}
