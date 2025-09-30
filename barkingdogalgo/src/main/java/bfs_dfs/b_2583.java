package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class b_2583 {
    static int countRec = 0;
    static int recCountSize = 0;
    static List<Integer> recSizes;
    static int [][] direct = {{0,1},{1,0},{0,-1},{-1,0}};
    static int [][] map;
    static int M;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String []input = br.readLine().split(" ");
        if (validation(input)) return;

        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);
        int K = Integer.parseInt(input[2]);

        map = new int[M][N];
        recSizes = new ArrayList<>();

        for(int i=0; i<K; i++){
            input = br.readLine().split(" ");
            int lux = Integer.parseInt(input[0]);
            int luy = Integer.parseInt(input[1]);
            int rtx = Integer.parseInt(input[2]);
            int rty = Integer.parseInt(input[3]);

            for(int j = luy; j< rty; j++){
                for(int k = lux; k < rtx; k++){
                    map[j][k] = 1;
                }
            }
        }

        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] == 0){
                    countRec++;
                    recCountSize++;
                    map[i][j] = 1;
                    dfs(i, j);
                    recSizes.add(recCountSize);
                    recCountSize = 0;
                }
            }
        }

        Collections.sort(recSizes);

        sb.append(countRec).append("\n");

        for(int i=0; i<recSizes.size(); i++){
            sb.append(recSizes.get(i)).append(" ");
        }

        System.out.println(sb);
    }

    private static void dfs(int x, int y) {

        for (int[] nums : direct) {
            int dx = x + nums[0];
            int dy = y + nums[1];

            if (dx >= 0 && dx < M && dy >= 0 && dy < N) {
                if (map[dx][dy] == 0) {
                    recCountSize++;
                    map[dx][dy] = 1;
                    dfs(dx, dy);
                }
            }
        }

    }

    private static boolean validation(String[] input) {
        if(input.length != 3){
            System.out.println("Error");
            return true;
        }
        return false;
    }
}
