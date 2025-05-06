package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 답 보기 : gpt 사용
// 메모리 : 45544
// 시간 : 392ms
public class b_1926_solution{

    static int[][] pictures;
    static boolean[][] visited;
    static int cnt = 0;
    static int N;
    static int M;
    static int [][] four = {{0,1},{1,0},{0,-1},{-1,0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()); // StringTokenizer 활용, String.split(" ")는 내부적으로 정규식을 쓰기 때문에 느리다.
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        pictures = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());  // split 정규식 대신 StringTokenizer
            for(int j = 0; j < M; j++){
                pictures[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(pictures[i][j] == 1 && !visited[i][j]){
                    int size = bfs(i,j);
                    max=Math.max(max,size);  // 가독성 개선
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        System.out.println(max);
    }

    static int bfs(int y, int x){
        int size = 1;                      // 직관적이게 지역변수 활용 및 size 리턴
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y,x});
        visited[y][x] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int ny = cur[0];
            int nx = cur[1];

            for(int k = 0; k < four.length; k++){ // 매 루프마다 객체 할당이 비효율적, four[k] 로 직접 접근
                int dy = ny + four[k][0];
                int dx = nx + four[k][1];

                if(dy<0 || dy>=N || dx<0 || dx>=M){
                    continue;
                }

                if(!visited[dy][dx] && pictures[dy][dx] == 1){
                    q.offer(new int[]{dy, dx});
                    visited[dy][dx] = true;
                    size++;
                }
            }
        }
        return size;
    }
}
