package basic.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_16719 {
    static StringBuilder sb = new StringBuilder();
    static String word;
    static boolean [] appear;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        word = br.readLine();
        appear = new boolean[word.length()];

        Zoac(0, word.length()-1);
        br.close();
        System.out.println(sb);
    }

    private static void Zoac(int left, int right) {
        if(left > right){return;}

        int min = left;
        for(int i=left; i<=right; i++){
            if(word.charAt(min) > word.charAt(i)){
                min = i;
            }
        }
        appear[min]= true;
        for(int i=0; i<word.length(); i++){
            if(appear[i]){
                sb.append(word.charAt(i));
            }
        }
        sb.append("\n");
        Zoac(min+1, right);
        Zoac(left, min - 1);
    }
}
