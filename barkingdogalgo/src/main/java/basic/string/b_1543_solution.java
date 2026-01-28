package basic.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_1543_solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String document = br.readLine();
        String word = br.readLine();

        int cnt = 0;
        while (document.contains(word)){
            document = document.substring(document.indexOf(word) + word.length(), document.length());
            cnt++;
        }
        System.out.println(cnt);
    }
}
