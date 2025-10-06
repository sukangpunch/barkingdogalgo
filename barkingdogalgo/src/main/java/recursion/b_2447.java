package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_2447 {

    static char [][] starts;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        starts = new char[N][N];

        makeStarMap(0,0,N,false);

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                sb.append(starts[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void makeStarMap(int y, int x, int n, boolean blank){

        if(blank) {
            for(int i = y; i < y+n; i++){
                for(int j = x; j < x+n; j++){
                    starts[i][j] = ' ';
                }
            }
            return;
        }

        if(n == 1){
            starts[y][x] = '*';
            return;
        }

        int size = n/3;
        int count = 0;
        for(int i = y; i< y+n; i += size){
            for(int j = x; j< x+n; j += size){
                count++;
                if(count == 5){
                    makeStarMap(i,j,size, true);
                }else{
                    makeStarMap(i,j,size,false);
                }
            }
        }
    }

}
