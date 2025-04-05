package StringBasic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String document = br.readLine();
        String word = br.readLine();

        int docSize = document.length();
        int wordSize = word.length();
        int cnt = 0;

        for(int i=0; i<docSize; i++){
            int compareSize = wordSize + i - 1;
            if(compareSize > docSize - 1)break;

            String compare = document.substring(i, compareSize+1);
            if(compare.equals(word)){
                cnt++;
                i = compareSize;
            }
        }

        System.out.println(cnt);
    }
}
