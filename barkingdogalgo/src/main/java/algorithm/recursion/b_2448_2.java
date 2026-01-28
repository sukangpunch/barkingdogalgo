package algorithm.recursion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 *  구간 분리되는 형식 예
 *  N = 24일 때, 기준점운(한개씩 찍는 윗 삼각형)
 *  위: (23, 0, 12), 좌아래 : (11, 12, 12), 우아래(35, 12, 12)
 *  해당 점을 기준으로 또 3갈래로 재귀적으로 나뉘는 구조
 */

public class b_2448_2 {

    static int N;
    static char[][] stars;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        stars = new char[N][N*2-1];
        for(int i=0; i<N; i++){
            Arrays.fill(stars[i], ' ');
        }
        star(N-1, 0 ,N);
        for(int i=0; i<N; i++){
            for(int j=0; j<N*2-1; j++){
                sb.append(stars[i][j]);
            }
            sb.append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void star(int x, int y, int n) {
        if(n == 3){  // 삼각형 규격을 그리는 부분 n은 높이를 뜻한다.
            stars[y][x] = '*';
            stars[y+1][x-1] = '*';
            stars[y+1][x+1] = '*';
            stars[y+2][x-2] = '*';
            stars[y+2][x-1] = '*';
            stars[y+2][x] = '*';
            stars[y+2][x+1] = '*';
            stars[y+2][x+2] = '*';
        }else{      // 만약에 높이가 3 이상이라면 6, 12 ... 가 될것이고 6부터는 윗삼각형(1개) 아래삼각형(2개) 구조로 이루어진다.
            int size = n/2;
            star(x,y, size); // 윗 삼각형
            star(x-size, y+size, size); // 왼쪽 아래 삼각형
            star(x+size, y+size, size); // 오른쪽 아래 삼각형
        }
    }
}
