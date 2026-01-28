package algorithm.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 주사위 굴리기
public class b_14499_retry {

    static int [] dice;
    static int [][] map;
    static int [][] direction ={{0,1}, {0,-1}, {-1,0},{1,0}};
    static int N;
    static int M;
    static int X;
    static int Y;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String []s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        X = Integer.parseInt(s[2]);
        Y = Integer.parseInt(s[3]);
        int K = Integer.parseInt(s[4]);

        map = new int[N][M];
        dice = new int[6];

        for(int i=0; i<N; i++){
            s = br.readLine().split(" ");
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        s = br.readLine().split(" ");
        for(int i=0; i<K; i++){
            int dir = Integer.parseInt(s[i]);
            simulationDice(dir -1);
        }

        System.out.println(sb);
    }

    private static void simulationDice(int dir) {
        int dx = X + direction[dir][0];
        int dy = Y + direction[dir][1];

        if(dx < 0 || dx >= N || dy < 0 || dy >= M){
            return;
        }

        rotationDice(dir);

        sb.append(dice[0]).append("\n");

        X = dx;
        Y = dy;

        if(map[X][Y] == 0){
            map[X][Y] = dice[5];
        }else{
            dice[5] = map[X][Y];
            map[X][Y] = 0;
        }

    }

    private static void rotationDice(int dir) {

        int tmp = dice[5];
        switch (dir){
            case 0:
                dice[5] = dice[2];
                dice[2] = dice[0];
                dice[0] = dice[3];
                dice[3] = tmp;
                break;

            case 1:
                dice[5] = dice[3];
                dice[3] = dice[0];
                dice[0] = dice[2];
                dice[2] = tmp;
                break;

            case 2:
                dice[5] = dice[4];
                dice[4] = dice[0];
                dice[0] = dice[1];
                dice[1] = tmp;
                break;

            case 3:
                dice[5] = dice[1];
                dice[1] = dice[0];
                dice[0] = dice[4];
                dice[4] = tmp;
                break;
        }
    }
}
