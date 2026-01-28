package basic.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_1213 {

    private static int[] words = new int[26];
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        for(int i = 0; i < input.length(); i++){
            words[input.charAt(i) - 'A'] += 1;
        }

        while(true){
            int max = -1;
            for(int i = 0; i < words.length; i++){
                if(words[i] != 0 && i > max){
                    max = i;
                }
            }

            if(max == -1){
                break;
            }

            int mid;
            if(words[max] == 1){
                mid = sb.length()/2;
                sb.insert(mid, (char)('A' + max));
                words[max] -= 1;
            }else{
                sb.insert(0, (char)('A' + max));
                sb.insert(sb.length(), (char)('A' + max));
                words[max] -= 2;
            }
        }

        if(isPelin()){
            System.out.println(sb);
        }else{
            System.out.println("I'm Sorry Hansoo");
        }
    }

    private static boolean isPelin(){
        int size = sb.length();
        for(int i = 0; i < size/2; i++){
            if(sb.charAt(i) != sb.charAt(size -1 - i)){
                return false;
            }
        }
        return true;
    }
}
