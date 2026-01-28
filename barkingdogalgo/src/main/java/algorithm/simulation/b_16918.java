package algorithm.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 봄버맨
public class b_16918 {

    static int [][] map;
    static int [][] bombs;
    static int R;
    static int C;
    static int N;


    static int [][] direction = {{0,1},{1,0},{0,-1},{-1,0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String [] s = br.readLine().split(" ");

        R = Integer.parseInt(s[0]);
        C = Integer.parseInt(s[1]);
        N = Integer.parseInt(s[2]);

        map = new int[R][C];
        bombs = new int[R][C];

        for(int i = 0; i < R; i++) {
            String line = br.readLine();
            for(int j = 0; j < C; j++) {
                if(line.charAt(j) == '.') {
                    map[i][j] = 0;
                }else if(line.charAt(j) == 'O') {
                    map[i][j] = 1;
                    bombs[i][j] = 2;
                }
            }
        }

        gameStart();

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(map[i][j] == 0) {
                    sb.append('.');
                }else if(map[i][j] == 1) {
                    sb.append('O');
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void gameStart() {
        for(int i = 1; i < N; i++) {
            if(i % 2 != 0){
                plantBomb();
            }else{
                explodeBomb();
            }
            updateTime();
        }
    }

    private static void updateTime() {
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(bombs[i][j] >= 1){
                    bombs[i][j] += 1;
                }
            }
        }
    }

    private static void explodeBomb() {

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(bombs[i][j] >= 3){
                    int y = i;
                    int x = j;
                    map[y][x] = 0;
                    bombs[y][x] = 0;

                    for(int k = 0; k < direction.length; k++) {
                        int dy = y + direction[k][0];
                        int dx = x + direction[k][1];
                        if(dy >= 0 && dy < R && dx >= 0 && dx < C) {
                            map[dy][dx] = 0;
                            if(bombs[dy][dx] < 3){
                                map[dy][dx] = 0;
                            }
                        }
                    }
                }
            }
        }
    }

    private static void plantBomb() {
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(map[i][j] == 0) {
                    map[i][j] = 1;
                    bombs[i][j] = 1;
                }
            }
        }
    }

}
