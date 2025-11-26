package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 별찍기 - 11
public class b_2448_retry {
    static int N;
    static char [][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        map = new char[N][N*2-1];
        for(int i = 0; i < N; i++){
            Arrays.fill(map[i], ' ');
        }

        makeStarTree(0, N-1, N);

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N*2-1; j++){
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void makeStarTree(int y, int x, int n) {
        if(n == 3){
            map[y][x] = '*';
            map[y+1][x-1] = '*';
            map[y+1][x+1] = '*';
            map[y+2][x-2] = '*';
            map[y+2][x-1] = '*';
            map[y+2][x] = '*';
            map[y+2][x+1] = '*';
            map[y+2][x+2] = '*';
        }else{
            int size = n/2;
            makeStarTree(y,x, size);
            makeStarTree(y+size, x-size, size);
            makeStarTree(y+size, x+size, size);

        }
   }
}
