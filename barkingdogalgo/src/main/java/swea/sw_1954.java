package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 달팽이 숫자
public class sw_1954 {

    static int [][] snail;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t=1;t<=T;t++){
            int N = Integer.parseInt(br.readLine());

            snail = new int[N][N];

            makeSnail(N, 0, 0, 1);
            sb.append("#").append(t).append("\n");

            for(int i = 0;i<N;i++){
                for(int j = 0;j<N;j++){
                    sb.append(snail[i][j]).append(" ");
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }

    private static void makeSnail(int n, int y, int x, int num) {

        if(n < 1){
            return;
        }

        if(n == 1){
            snail[y][x] = num;
            return;
        }

        for(int i = x; i < x+n-1; i++){
            snail[y][i] = num;
            num++;
        }

        for(int i = y; i < y+n-1; i++){
            snail[i][x+n-1] = num;
            num++;
        }

        for(int i = n-1+x; i > x ; i--){
            snail[y+n-1][i] = num;
            num++;
        }

        for(int i = n-1+y; i > y; i--){
            snail[i][x] = num;
            num++;
        }

        makeSnail(n-2, y+1, x+1, num);
    }

}
