package algorithm.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 답 보기 : x(조언을 받음)
// 메모리 : 310468 kb
// 시간 :  840 ms
public class b_1780 {
    static int [][] map;
    static int []count;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        count = new int[3];

        StringTokenizer st;

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursion(0,0,N);

        for(int i=0; i<3; i++){
            System.out.println(count[i]);
        }
    }

    static void recursion(int y, int x, int size) {
        if(size == 1){
            count[map[y][x]+1]++;
        }else{
            int pre = map[y][x];
            boolean check = false;
            for(int i=y; i<y+size; i++){
                for(int j=x; j<x+size; j++){
                    if(pre != map[i][j]){
                        check = true;
                        break;
                    }
                }
                if(check){
                    break;
                }
            }

            if(!check){
                count[pre+1]++;
                return;
            }else{
                int divide = size/3;
                for(int i=y; i<y+size; i += divide){
                    for(int j=x; j<x+size; j +=divide){
                        recursion(i,j,divide);
                    }
                }
            }
        }
    }
}
