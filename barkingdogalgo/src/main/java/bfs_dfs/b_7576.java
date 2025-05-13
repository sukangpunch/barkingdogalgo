package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 답 보기 : x(이전에 풀어봄)
// 메모리 :  165340 kb
// 시간 :  824 ms
public class b_7576 {

    static class Node{
        private int x;
        private int y;
        public Node(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    static int [][] map;
    static boolean[][] visited;
    static int N;
    static int M;
    static int [][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
    static Queue<Node> q1;
    static int cnt;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[M][N];
        map = new int[M][N];
        q1 = new LinkedList<>();

        boolean check = false;

        for(int i=0; i<M; i++){
            String[] line = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                if(line[j].equals("1")){
                    q1.add(new Node(i, j));
                    visited[i][j] = true;
                }else if(line[j].equals("0") && !check){
                    check = true;
                }
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        if(!check){
            System.out.println(0);
            return;
        }

        bfs();

        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(cnt);

    }

    static void bfs(){
        cnt = -1;
        Queue<Node> q2 = new LinkedList<>();
        while(!q1.isEmpty()){
            while (!q1.isEmpty()){
                q2.add(q1.poll());
            }
            cnt++;
            while(!q2.isEmpty()){
                Node now = q2.poll();
                visited[now.y][now.x] = true;
                for(int i=0; i<4; i++){
                    int dy = now.y + direction[i][0];
                    int dx = now.x + direction[i][1];

                    if(dx < 0 || dx>=N || dy<0 || dy>=M){
                        continue;
                    }

                    if(map[dy][dx] == 0 && !visited[dy][dx])
                        q1.add(new Node(dy,dx));
                        map[dy][dx] = 1;
                    }
                }
            }
        }

}
