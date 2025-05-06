package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 답 보기 :x
// 메모리 : 49788
// 시간 : 384ms
public class b_1926 {

    static int[][] pictures;
    static boolean[][] visited;
    static int cnt = 0;
    static int size;
    static int N;
    static int M;
    static int [][] four = {{0,1},{1,0},{0,-1},{-1,0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String []nums = br.readLine().split(" ");
        N = Integer.parseInt(nums[0]);
        M = Integer.parseInt(nums[1]);

        pictures = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            String []line = br.readLine().split(" ");
            for(int j = 0; j < M; j++){
                pictures[i][j] = Integer.parseInt(line[j]);
            }
        }

        int max = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(pictures[i][j] == 1 && !visited[i][j]){
                    size = 0;
                    cnt++;
                    bfs(i,j);
                    if(max<size){
                        max = size;
                    }
                }
            }
        }
        System.out.println(cnt);
        System.out.println(max);
    }

    static void bfs(int y, int x){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y,x});
        visited[y][x] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int ny = cur[0];
            int nx = cur[1];
            size++;

            for(int k = 0; k < four.length; k++){
                int[] next = four[k];
                int dy = ny + next[0];
                int dx = nx + next[1];

                if(dy<0 || dy>=N || dx<0 || dx>=M){
                    continue;
                }

                if(!visited[dy][dx] && pictures[dy][dx] == 1){
                    q.offer(new int[]{dy, dx});
                    visited[dy][dx] = true;
                }
            }
        }
    }
}
