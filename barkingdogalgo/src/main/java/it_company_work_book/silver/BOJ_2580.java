package it_company_work_book.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 스도쿠
// 구현, 백트래킹
/**
 * 답 확인
 * 백트래킹 문제임은 알았는데, 구현 못했음
 * 인덱스 0, 0 ~ 8,8 까지 재귀로 구현한다.
 * 세로, 가로, 3x3 을 확인하고 가능하면 다음스텝, 불가능하면 빽
 * 8,8 까지 순회 했다면, 알맞게 채운 것이므로 종료
 */
public class BOJ_2580 {

    static int [][] map;
    static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new int[9][9];

        for(int i=0; i<9; i++){
            String []s = br.readLine().split(" ");
            for(int j=0; j<9; j++){
                int num = Integer.parseInt(s[j]);
                map[i][j] = num;
            }
        }

        backtrack(0,0);
    }

    private static void backtrack(int y, int x) {
        if(x == 9){
            backtrack(y+1, 0);
            return;
        }

        if(y == 9){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<9; i++){
                for(int j=0; j<9; j++){
                    sb.append(map[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }

        if(map[y][x] == 0){
            for(int i=1; i<=9; i++){
                if(check(y, x, i)){
                    map[y][x] = i;
                    backtrack(y, x+1);
                }
            }
            map[y][x] = 0;
            return;
        }

        backtrack(y, x+1);
    }

    private static boolean check(int y, int x, int value) {

        for(int i=0; i<9; i++){
            if(map[y][i] == value){
                return false;
            }
        }

        for(int i=0; i<9; i++){
            if(map[i][x] == value){
                return false;
            }
        }

        // 같은 네모를 보기 위함
        int tmpY = (y/3) * 3;
        int tmpX = (x/3) * 3;

        for(int i = tmpY; i<tmpY+3; i++){
            for(int j=tmpX; j<tmpX+3; j++){
                if(map[i][j] == value){
                    return false;
                }
            }
        }

        return true;
    }
}
