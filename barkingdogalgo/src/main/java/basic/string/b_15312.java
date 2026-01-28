package basic.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_15312 {
    public static int [] strokes =  {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String A = br.readLine();
        String B = br.readLine();
        int N = A.length() + B.length() -1;
        int M = A.length() + B.length();

        int [][] result = new int[N][M];
        int idx = 0;
        for(int i = 0; i < A.length(); i++){
            result[0][idx] = strokes[A.charAt(i) - 'A'];
            idx++;
            result[0][idx] = strokes[B.charAt(i) - 'A'];
            idx++;
        }

        for(int i=1; i<result.length; i++){
            for(int j=0; j < result[i].length - i; j++){
                result[i][j] = (result[i-1][j] + result[i-1][j+1])%10;
            }
        }

        System.out.println(result[N-1][0] + "" + result[N-1][1]);
    }
}
