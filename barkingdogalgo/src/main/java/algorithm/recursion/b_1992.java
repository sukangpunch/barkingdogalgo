package algorithm.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 답 보기 : x
// 메모리 : 14116 kb
// 시간 :  112 ms
public class b_1992 {
    static int [][] screen;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        screen = new int[N][N];
        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < N; j++){
                screen[i][j] = line.charAt(j) - '0';
            }
        }
        recursion(0, 0, N);
        System.out.println(sb);
    }

    static void recursion(int y, int x, int N){
        int pre = screen[y][x];
        boolean check = false;
        for(int i=y; i<y+N; i++){
            for(int j=x; j<x+N; j++){
                if(screen[i][j] != pre){
                    check = true;
                    break;
                }
            }
            if(check){
                break;
            }
        }

        if(!check){
            sb.append(screen[y][x]);
            return;
        }else{
            sb.append("(");
        }

        int divide = N/2;
        recursion(y, x, divide);
        recursion(y, x + divide, divide);
        recursion(y + divide, x, divide);
        recursion(y + divide, x + divide, divide);
        sb.append(")");
    }
}
