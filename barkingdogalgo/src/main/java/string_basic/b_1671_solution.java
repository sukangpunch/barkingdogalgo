package string_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_1671_solution {
    public static boolean []position;
    public static StringBuilder sb;
    public static String str;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        int size = str.length();
        position = new boolean[size];
        sb = new StringBuilder();

        makeStr(0, size - 1);
        System.out.println(sb);
        br.close();
    }

    private static void makeStr(int left, int right) {
        if(left > right){
            return;
        }

        int min = left;
        for(int i = left+1; i <=right; i++){
            if(str.charAt(min) > str.charAt(i)){
                min = i;
            }
        }
        position[min] = true;

        for(int i=0; i<str.length(); i++){
            if(position[i]){
                sb.append(str.charAt(i));
            }
        }
        sb.append("\n");

        makeStr(min+1, right);
        makeStr(left, min -1);
    }
}
