package StringBasic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_9996_fail {
    static class PatternString{
        private String start;
        private String end;
        private String middle;
        private int status;

        public PatternString(String start, String end, int status){
            this.start = start;
            this.end = end;
            this.status = status;
        }

        public PatternString(String start, String middle, String end, int status){
            this.start = start;
            this.middle = middle;
            this.end = end;
            this.status = status;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String pattern = br.readLine();
        PatternString patternString = startPoint(pattern);

        for(int i=0; i<N; i++){
            String input = br.readLine();
            if(patternString.status == 1){
                if(input.endsWith(patternString.end)){
                    sb.append("DA" + "\n");
                }else{
                    sb.append("NE" + "\n");
                }
            }else if(patternString.status == 0){
                if(input.startsWith(patternString.start)){
                    sb.append("DA" + "\n");
                }else{
                    sb.append("NE" + "\n");
                }
            }else{
                if(input.startsWith(patternString.start) && input.endsWith(patternString.end)){
                    sb.append("DA" + "\n");
                }else{
                    sb.append("NE" + "\n");
                }
            }
        }
        System.out.println(sb);
    }

    private static PatternString startPoint(String pattern) {
        if(pattern.charAt(0) == '*'){
            String start = "*";
            String end = pattern.substring(1,pattern.length());
            return new PatternString(start, end,1);
        }
        else if(pattern.charAt(pattern.length()-1) == '*'){
            String start = pattern.substring(0, pattern.length()-1);
            String end = "*";
            return new PatternString(start, end,0);
        }else{
            String start = pattern.substring(0, pattern.indexOf("*"));
            String middle = "*";
            String end = pattern.substring(pattern.indexOf("*") + 1, pattern.length());
            return new PatternString(start,middle,end,-1);
        }
    }
}
