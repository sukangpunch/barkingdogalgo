package study.week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 목장 건설하기
// 시간초과...
public class BOJ_14925_timeout {

    static int M;
    static int N;
    static int [][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] s = br.readLine().split(" ");

        M = Integer.parseInt(s[0]);
        N = Integer.parseInt(s[1]);

        map = new int[M][N];

        for(int i=0; i<M; i++){
            s = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        int maxSize = Math.min(M,N);
        int maxResult = 0;

        for(int i=1; i<=maxSize; i++){
            int result = findMaxSize(i);
            if(result == -1){
                System.out.println(maxResult);
                return;
            }
            maxResult = Math.max(result, maxResult);
        }

        System.out.println(maxResult);
    }

    private static int findMaxSize(int size) {
        for(int i=0; i<=M-size; i++){
            for (int j=0; j<=N-size; j++){
                boolean check = false;
                for(int r = i; r<i+size; r++){
                    for (int c = j; c < j+size; c++){
                        if(map[r][c] != 0){
                            check = true;
                            break;
                        }
                    }
                    if(check)break;
                }
                if(!check) return size;
            }
        }
        return -1;
    }

}
