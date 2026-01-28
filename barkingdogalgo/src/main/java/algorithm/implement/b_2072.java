package algorithm.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 오목
public class b_2072 {

    static int result;
    static int [][]white;
    static int [][]black;
    static int [][] direction = {{0,-1}, {-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1}};
    static final int SIZE = 19;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        white = new int[SIZE+1][SIZE+1];
        black = new int[SIZE+1][SIZE+1];
        if(N < 9){
            System.out.println(-1);
            return;
        }

        for(int i=1; i<=N; i++){
            String []s = br.readLine().split(" ");
            int y = Integer.parseInt(s[0]);
            int x = Integer.parseInt(s[1]);
            if(i%2 == 0){
                white[y][x] = i;
                if(i>8 && checkIsEnd(y,x,true)){
                    result = white[y][x];
                    break;
                }
            }else{
                black[y][x] = i;
                if(i>8 && checkIsEnd(y,x,false)){
                    result = black[y][x];
                    break;
                }
            }
        }

        if(result == 0){
            System.out.println(-1);
        }else{
            System.out.println(result);
        }
    }

    private static boolean checkIsEnd(int y, int x, boolean isWhite) {
        if(isWhite){
            for(int i=0; i<4; i++){
                int way1 = findOneWay(y,x,i, white);
                int way2 = findOneWay(y,x,i + 4, white);

                if(way1+way2+1 == 5){
                    return true;
                }
            }
        }else{
            for(int i=0; i<4; i++){
                int way1 = findOneWay(y,x,i, black);
                int way2 = findOneWay(y,x,i + 4, black);

                if(way1+way2+1 == 5){
                    return true;
                }
            }
        }

        return false;
    }

    private static int findOneWay(int y, int x, int i, int [][] map) {
        int count = 0;
        while(true){
            y += direction[i][0];
            x += direction[i][1];

            if(y<1 || y>SIZE || x<1 || x>SIZE || map[y][x] == 0){
                break;
            }

            count++;
        }

        return count;
    }
}
