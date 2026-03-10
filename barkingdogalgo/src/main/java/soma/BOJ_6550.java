package soma;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 부분 문자열
public class BOJ_6550 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input;
        while((input = br.readLine()) != null){
            String []spt = input.split(" ");

            String s = spt[0];
            String t = spt[1];

            int sIdx = 0;

            for(int i=0; i<t.length(); i++){
                if(s.charAt(sIdx) == t.charAt(i)){
                    sIdx++;
                }

                if(sIdx == s.length()){
                    break;
                }
            }

            if(sIdx == s.length()){
                sb.append("Yes").append("\n");
            }else{
                sb.append("No").append("\n");
            }
        }

        System.out.println(sb);
    }
}
