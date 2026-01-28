package basic.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_9996 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String pattern = br.readLine();
        String start = pattern.substring(0, pattern.indexOf("*"));
        String end = pattern.substring(pattern.indexOf("*") + 1, pattern.length());
        for(int i=0; i<N; i++){
            String input = br.readLine();
            if(input.length() < start.length() + end.length()){
                sb.append("NE").append("\n");
                continue;
            }
            if(input.startsWith(start) && input.endsWith(end)){
                sb.append("DA").append("\n");
            }else{
                sb.append("NE").append("\n");
            }
        }
        System.out.println(sb);
    }
}
