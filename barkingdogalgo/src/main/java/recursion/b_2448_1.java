package recursion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class b_2448_1 {

    static String[] star;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        star = new String[N];
        star[0] = "  *  ";
        star[1] = " * * ";
        star[2] = "*****";

        for(int i=1; 3 * Math.pow(2,i) <=N; i++){
            writeStar(i);
        }

        for(int i=0; i<N; i++){
            bw.write(star[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void writeStar(int i) {
        int bottom = (int)(3 * Math.pow(2, i));
        int middle = bottom/2;

        for(int j=middle; j<bottom; j++){
            star[j] = star[j-middle] + " " + star[j-middle];
        }
        String blank = " ".repeat(middle);
        for(int j=0; j < middle; j++){
            star[j] = blank + star[j] + blank;
        }
    }

}
