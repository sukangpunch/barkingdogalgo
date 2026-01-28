package algorithm.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 마라톤 1
public class b_10655_wrong {

    static int N;
    static int [][] checkPoint;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        checkPoint = new int[N][2];

        for(int i=0; i<N; i++){
            String [] s = br.readLine().split(" ");
            checkPoint[i][0] = Integer.parseInt(s[0]);
            checkPoint[i][1] = Integer.parseInt(s[1]);
        }

        result = Integer.MAX_VALUE;
        findMinWay();

        System.out.println(result);
    }

    private static void findMinWay() {

        for(int t = 1; t < N-1 ; t++){
            int nowResult = 0;
            int preX = checkPoint[0][0];
            int preY = checkPoint[0][1];

            for(int i=1; i<N; i++){
                if(t == i)continue;
                int nowX = checkPoint[i][0];
                int nowY = checkPoint[i][1];
                nowResult += Math.abs(nowX - preX) + Math.abs(nowY - preY);

                preX = nowX;
                preY = nowY;
            }

            result = Math.min(result, nowResult);
        }
    }
}
