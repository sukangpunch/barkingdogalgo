package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 비숍
public class b_1799 {

    static int N;
    static int [][] board;
    static boolean[][] visited;
    static int [] dx = {-1, -1};
    static int [] dy = {-1, 1};

    static int black = 0;
    static int white = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String [] s = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(s[j]);
            }
        }

        // 흑칸 백트래킹
        placeBishop(0, 0, 0, true);

        // 백 칸 백트래킹
        placeBishop(0, 1, 0, false);

        System.out.println(black + white);
    }

    private static void placeBishop(int x, int y, int count, boolean isBlack) {
        if(x >= N){
            if(isBlack) black = Math.max(black, count);
            else white = Math.max(white, count);
            return;
        }

        int nx = x;
        int ny = y+2; // 같은 색깔만 고려 (칸을 건너뛴다)
        if(ny >= N){ // 다음 줄로 넘어간다
            nx++;
            ny = (y % 2 == 0) ? 1 : 0; // 홀수 칸 또는 짝수 칸 시작, 이전 행이 0부터 시작했으면 다음 행은 1부터
        }

        // 비숍을 놓을 수 있으면 놓고 다음 단계로
        if(board[x][y] == 1 && canPlaceBishop(x,y)){
            visited[x][y] = true;
            placeBishop(nx, ny, count + 1, isBlack);
            visited[x][y] = false;
        }

        placeBishop(nx, ny, count, isBlack);
    }

    static boolean canPlaceBishop(int x, int y) {
        for(int i = 0; i < 2; i++){
            int nx = x;
            int ny = y;
            while(true){
                nx += dx[i];
                ny += dy[i];
                if(nx < 0 || ny < 0 || nx >= N || ny >= N)break;
                if(visited[nx][ny]) return false;
            }
        }
        return true;
    }

}
