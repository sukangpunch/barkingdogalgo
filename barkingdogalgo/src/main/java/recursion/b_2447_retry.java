package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 별 찍기 - 10
public class b_2447_retry {

    static int N;
    static char [][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        map = new char[N][N];

        for(int i = 0; i < N; i++){
            Arrays.fill(map[i], ' ');
        }

        makeMap(0,0,N);

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void makeMap(int y, int x, int size) {

        if(y < 0 || y >= N || x < 0 || x >= N) {
            return;
        }

        if(size == 1){
            map[y][x] = '*';
            return;
        }

        int nextSize = size/3;
        makeMap(y, x, nextSize);
        makeMap(y, x + nextSize, nextSize);
        makeMap(y, x + 2*nextSize, nextSize);
        makeMap(y+nextSize, x, nextSize);
        makeMap(y + nextSize, x + 2*nextSize, nextSize);
        makeMap(y + 2 * nextSize, x, nextSize);
        makeMap(y + 2 * nextSize, x + nextSize, nextSize);
        makeMap(y + 2 * nextSize, x + 2*nextSize, nextSize);
    }

}
