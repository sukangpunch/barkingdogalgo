package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 방 번호
public class b_1475_retry {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();
        int [] counts = new int[10];

        for(int i=0; i<N.length(); i++){
            counts[Integer.parseInt(String.valueOf(N.charAt(i)))]++;
        }

        int max = 0;
        for(int i=0; i<=9; i++){
            int nowCount = counts[i];

            if(i==6 || i==9){
                double plusSixAndNine = Math.ceil((double) (counts[6] + counts[9]) /2);
                nowCount = (int) plusSixAndNine;
            }

            if(nowCount > max){
                max = nowCount;
            }
        }

        System.out.println(max);
    }

}
