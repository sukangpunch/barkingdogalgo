package algorithm.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 주사위 굴리기 2
public class b_23288 {

    static int N, M, K;
    static int [][] map;
    static int [] dice;
    static int [] dx = {1, 0, -1, 0};
    static int [] dy = {0, 1, 0, -1};
    static int nowDir;
    static int X;
    static int Y;
    static int result;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);

        map = new int[N][M];
        dice = new int[6];
        X = 0;
        Y = 0;
        result = 0;

        for (int i = 0; i < 6; i++) {
            dice[i] = i+1;
        }

        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        for(int i=0; i<K; i++){
            simulationDice2(nowDir);
        }

        System.out.println(result);
    }

    private static void simulationDice2(int direction) {
        int nx = X + dx[direction];
        int ny = Y + dy[direction];

        if(nx < 0 || ny < 0 || ny >= N || nx >= M){
            direction = (direction + 2) % 4;
            nx = X + dx[direction];
            ny = Y + dy[direction];
        }
        moveDice(direction);

        int score = calScore(ny, nx);
        result += score;

        if(dice[5] > map[ny][nx]){
            nowDir = (direction + 1) % 4;
        }else if(dice[5] < map[ny][nx]){
            nowDir = (4 + direction - 1) % 4;
        }else{
            nowDir = direction;
        }

        X = nx;
        Y = ny;
    }

    private static int calScore(int y, int x) {
        count++;
        boolean [][] visited = new boolean[N][M];
        int count = 1;
        int num = map[y][x];

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x});
        visited[y][x] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int i=0; i<4; i++){
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];
                if(ny >= 0 && ny < N && nx >= 0 && nx < M && !visited[ny][nx]){
                    if(num == map[ny][nx]){
                        count++;
                        q.add(new int[]{ny, nx});
                        visited[ny][nx] = true;
                    }
                }
            }
        }

        return count * num;
    }

    private static void moveDice(int direction) {
        int tmp = dice[5];

        switch(direction){
            case 0:
                dice[5] = dice[2];
                dice[2] = dice[0];
                dice[0] = dice[3];
                dice[3] = tmp;
                break;
            case 1:
                dice[5] = dice[4];
                dice[4] = dice[0];
                dice[0] = dice[1];
                dice[1] = tmp;
                break;
            case 2:
                dice[5] = dice[3];
                dice[3] = dice[0];
                dice[0] = dice[2];
                dice[2] = tmp;
                break;
            default:
                dice[5] = dice[1];
                dice[1] = dice[0];
                dice[0] = dice[4];
                dice[4] = tmp;
                break;
        }
    }

}
