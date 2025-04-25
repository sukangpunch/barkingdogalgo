package StringBasic;

import java.io.IOException;
import java.util.Scanner;

public class b_6581 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int lineSize = 0;
        int lineCount = 0;

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if(lineCount != 0){
                if(lineSize >= 80){
                    sb.append("\n");
                    lineSize = 0;
                }else{
                    if(sb.lastIndexOf("\n") != sb.length() - 2){
                        sb.append(" ");
                        lineSize++;
                    }
                }
            }

            lineCount++;

            for(int i = 0; i < line.length(); i++){
                if(line.substring(i).equals("<br>")){
                    sb.append("\n");
                    i += 3;
                    lineSize = 0;
                }else if(line.substring(i).equals("<hr>")){
                    if(sb.lastIndexOf("\n") == sb.length()-2){
                        sb.append("=".repeat(80)).append("\n");
                    }
                    else{
                        sb.append("\n").append("=".repeat(80)).append("\n");
                    }
                    lineSize = 0;
                    i += 3;
                }else if(line.charAt(i) == ' '){
                    int size = wordSize(line, i, ' ');
                    sb.append(' ');
                    i += size-1;
                    lineSize++;
                }else{
                    int size = wordSize(line, i, line.charAt(i));
                    if(size + lineSize > 80){
                        lineSize = 0;
                        sb.append("\n").append(line, i, i + size);
                        lineSize += size;
                        i += size-1;
                    }else{
                        sb.append(line, i, i + size);
                        lineSize += size;
                        i += size-1;
                    }
                }
            }
        }

        System.out.println(sb);

        sc.close();
    }

    private static int wordSize(String line, int index, char c) {

        int count = 0;
        if(c == ' '){
            for(int j = index; j < line.length(); j++){
                if(line.charAt(j) != c){
                    break;
                }else{
                    count++;
                }
            }
        }
        else{
            for(int j = index; j < line.length(); j++){
                if(line.charAt(j) == ' '){
                    break;
                }else{
                    count++;
                }
            }
        }
        return count;
    }
}
