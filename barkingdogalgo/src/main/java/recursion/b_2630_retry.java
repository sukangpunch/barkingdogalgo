package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 색종이 만들기
public class b_2630_retry {

    static int N;
    static int [][] map;
    static int blue;
    static int white;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i=0; i<N; i++){
            String [] s = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        blue = 0;
        white = 0;
        cutPaper(0, 0, N);

        System.out.println(white);
        System.out.println(blue);
    }

    private static void cutPaper(int y, int x, int n) {
        if(n==1){
            if(map[y][x]==0){
                white++;
                return;
            }

            if(map[y][x]==1){
                blue++;
                return;
            }
        }

        int first = map[y][x];
        boolean onePaper = true;
        for(int i=y; i<y+n; i++){
            for(int j=x; j<x+n; j++){
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
            if(first == 0){
                white++;
                return;
            }

            if(first==1){
                blue++;
                return;
            }
        }

        int size = n/2;
        cutPaper(y, x, size);
        cutPaper(y, x + size, size);
        cutPaper(y+size, x, size);
        cutPaper(y+size, x+size, size);
    }
}
