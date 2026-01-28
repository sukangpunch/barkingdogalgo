package algorithm.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;


// 답 보기 : x
// 메모리 : 14656 kb
// 시간 :  116 ms
public class b_10026 {
    static class Node{
        private int x;
        private int y;
        private char color;

        public Node(int y , int x, char color){
            this.y = y;
            this.x = x;
            this.color = color;
        }
    }
    static int N;
    static char [][]map;
    static char [][]map2;
    static boolean[][] visited;
    static int [][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        map2 = new char[N][N];
        for(int i=0; i<N; i++){
            String line = br.readLine();
            for(int j=0; j<N; j++){
                char c = line.charAt(j);
                map[i][j] = c;
                if(c == 'R' || c=='G'){
                    map2[i][j] = 'R';
                }else{
                    map2[i][j] = c;
                }
            }
        }

        for(int k=0; k<2;k++){
            visited = new boolean[N][N];
            for(int i=0; i<N; i++){
                for (int j=0; j<N; j++){
                    if(!visited[i][j]){
                        if(k==0){
                            bfs(i, j);
                        }else{
                            bfs2(i, j);
                        }
                    }
                }
            }
            System.out.println(count);
            count = 0;
        }
    }

    static void bfs(int y, int x){
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(y, x, map[y][x]));
        visited[y][x] = true;

        while(!queue.isEmpty()){
            Node now = queue.poll();

            for(int i=0; i<4; i++){
                int dy = now.y + direction[i][0];
                int dx = now.x + direction[i][1];

                if(dy >=0 && dy < N && dx >= 0 && dx < N && now.color == map[dy][dx] && !visited[dy][dx]){
                    queue.add(new Node(dy, dx, map[now.y][now.x]));
                    visited[dy][dx] = true;
                }
            }
        }
        count++;
    }

    static void bfs2(int y, int x){
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(y, x, map2[y][x]));
        visited[y][x] = true;

        while(!queue.isEmpty()){
            Node now = queue.poll();

            for(int i=0; i<4; i++){
                int dy = now.y + direction[i][0];
                int dx = now.x + direction[i][1];

                if(dy >=0 && dy < N && dx >= 0 && dx < N && now.color == map2[dy][dx] && !visited[dy][dx]){
                    queue.add(new Node(dy, dx, map2[now.y][now.x]));
                    visited[dy][dx] = true;
                }
            }
        }
        count++;
    }
}
