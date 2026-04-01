package soma.second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 토마토
// bfs

/**
 * 기본적인 bfs문제인데, 3차원이다. z축만 고려해주면 된다.
 * 토마토가 익는 시간을 구하는 문제이므로 Point 클래스에 time 필드를 추가
 * 1. 현재 익은 토마토를 전부 q에 넣는다.
 * 2. q에서 토마토를 빼내어, x, y, z 축으로 상하좌우위아래 를 탐색하여 가능하다면 해당 토마토를 익게 만든다(0->1)
 * 3. 토마토를 익게 만들 때, 현재 토마토 기준 다음 토마토의 time은 (현재 토마토 시간 + 1) 이된다.
 * 4. bfs가 종료되고, 안익은 토마토(값이 0) 의 존재로 -1 리턴 혹은 days 리턴
 */
public class BOJ_7569 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String []s = br.readLine().split(" ");

        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int H = Integer.parseInt(s[2]);
        int [][][]map = new int[H][M][N];

        for(int i=0; i<H; i++){
            for(int j=0; j<M; j++){
                s = br.readLine().split(" ");
                for(int k=0; k<N; k++){
                    map[i][j][k] = Integer.parseInt(s[k]);
                }
            }
        }

        int result = solution(H,M,N,map);
        System.out.println(result);
    }

    static class Point{
        int z;
        int x;
        int y;
        int time;

        public Point(int z, int x, int y, int time){
            this.z = z;
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    static List<Point> tomato;
    static int [][] direction = {{1,0,0},{-1,0,0},{0,1,0},{0,-1,0},{0,0,1},{0,0,-1}};
    static int days;
    private static int solution(int h, int m, int n, int[][][] map) {
        tomato = new ArrayList<>();
        for(int i=0; i<h; i++){
            for(int j=0; j<m; j++){
                for(int k=0; k<n; k++){
                    if(map[i][j][k] == 1){
                        tomato.add(new Point(i,j,k,0));
                    }
                }
            }
        }

        days = 0;
        int [][][]resultMap = bfs(h,m,n,map);
        if(check(h,m,n,resultMap)){
            return days;
        }

        return -1;
    }

    private static int [][][] bfs(int h, int m, int n, int[][][] map) {
        Queue<Point> q = new LinkedList<>(tomato);

        while(!q.isEmpty()){
            Point now = q.poll();

            days = Math.max(days, now.time);

            for(int i=0; i<direction.length; i++){
                int nz = now.z + direction[i][0];
                int nx = now.x + direction[i][1];
                int ny = now.y + direction[i][2];

                if(nz>=0 && nx>=0 && ny>=0 && nz<h && nx<m && ny<n && map[nz][nx][ny] == 0){
                    q.add(new Point(nz, nx, ny, now.time + 1));
                    map[nz][nx][ny] = 1;
                }
            }
        }

        return map;
    }

    private static boolean check(int z, int x, int y, int[][][] resultMap) {
        boolean isAllTomato = true;

        for(int i=0; i<z; i++){
            for(int j=0; j<x; j++){
                for (int k = 0; k<y; k++){
                    if(resultMap[i][j][k] == 0){
                        isAllTomato = false;
                        break;
                    }
                }
            }
        }

        return isAllTomato;
    }

}
