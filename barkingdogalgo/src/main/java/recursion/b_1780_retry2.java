package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_1780_retry2 {

    static int N;
    static int [][] map;
    static int minus;
    static int zero;
    static int one;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for(int i = 0; i < N; i++){
            String [] line = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        minus = 0;
        zero = 0;
        one = 0;

        cutPaper(0, 0, N);

        System.out.println(minus);
        System.out.println(zero);
        System.out.println(one);
    }

    private static void cutPaper(int y, int x, int n) {
        if(n == 1){
            if(map[y][x] == -1){
                minus++;
                return;
            }

            if(map[y][x] == 0){
                zero++;
                return;
            }

            if(map[y][x] == 1){
                one++;
                return;
            }
        }

        int first = map[y][x];
        boolean onePaper = true;
        for(int i = y; i < y+n; i++){
            for(int j = x; j < x+n; j++){
                if(map[i][j] != first){
                    onePaper = false;
                    break;
                }
            }
            if(!onePaper){
                break;
            }
        }

        if(onePaper){
            if(first == -1){
                minus++;
                return;
            }

            if(first == 0){
                zero++;
                return;
            }

            if(first == 1){
                one++;
                return;
            }
        }

        int size = n/3;
        cutPaper(y, x, size);
        cutPaper(y, x+size, size);
        cutPaper(y, x + 2*size, size);
        cutPaper(y + size, x, size);
        cutPaper(y + size, x+size, size);
        cutPaper(y + size, x + 2 *size, size);
        cutPaper(y + 2*size, x, size);
        cutPaper(y + 2*size, x+size, size);
        cutPaper(y + 2*size, x+ 2 * size, size);
    }

}
