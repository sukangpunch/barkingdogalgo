package algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 비숍
public class b_1799_retry {

    static int N;
    static int [][] board;
    static boolean[][] visited;
    static int [] dy = {-1, -1};
    static int [] dx = {-1, 1};

    static int black;
    static int white;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        visited = new boolean[N][N];

        for(int i= 0; i < N; i++){
            String [] s = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                board[i][j] = Integer.parseInt(s[j]);
            }
        }

        placeBishop(0,0, 0, true);
        placeBishop(0, 0, 1,false);

        System.out.println(black + white);
    }

    private static void placeBishop(int count, int y, int x, boolean isBlack) {
        if(y >= N){
            if(isBlack) black = Math.max(black, count);
            else white = Math.max(white, count);
            return ;
        }

        int ny = y;
        int nx = x + 2;

        if(nx >= N){
            ny++;
            nx = (x % 2 == 0) ? 1 : 0;
        }

        if(board[y][x] == 1 && canPlaceBishop(y, x)) { // 비숍을 놓고 다음으로 이동
            visited[y][x] = true;
            placeBishop(count + 1, ny, nx, isBlack);
            visited[y][x] = false;
        }

        placeBishop(count, ny, nx, isBlack); // 비숍을 놓지 않고 다음으로 이동
    }

    private static boolean canPlaceBishop(int y, int x) {
        for(int i = 0; i< 2; i++){
            int ny = y;
            int nx = x;
            while(true){
                nx += dx[i];
                ny += dy[i];
                if(nx < 0 || ny < 0 || nx >= N || ny >= N) break;
                if(visited[ny][nx]) return false;
            }
        }
        return true;
    }
}
