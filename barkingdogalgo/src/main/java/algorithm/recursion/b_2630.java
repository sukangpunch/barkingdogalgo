package algorithm.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 답 보기 : x
// 메모리 : 16296 kb
// 시간 : 132 ms
public class b_2630 {
    static int countW;
    static int countB;
    static int [][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i=0; i<N; i++){
            String[] inputs = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        recursion(0,0,N);
        System.out.println(countW);
        System.out.println(countB);
    }

    static void recursion(int x, int y, int size) {
        int pre = -1;
        boolean check = false;
        for(int i=y; i<y+size;i++){
            for(int j=x; j<x+size;j++){
                if(i==y && j==x) {
                    pre = map[i][j];
                    continue;
                }

                if(map[i][j] != pre) {
                    check = true;
                    break;
                }
            }
            if(check) {
                break;
            }
        }

        if(check) {
            recursion(x, y, size/2);
            recursion(x, y + size/2, size/2);
            recursion(x + size/2, y, size/2);
            recursion(x + size/2, y + size/2, size/2);
        }else{
            if(pre == 0){
                countW++;
            }else{
                countB++;
            }
        }

    }
}
