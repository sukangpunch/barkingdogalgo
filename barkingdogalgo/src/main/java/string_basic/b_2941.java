package string_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class b_2941 {
    private static List<String> croatia = List.of("c=","c-","dz=","d-","lj","nj","s=","z=");

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String words = br.readLine();
        int listSize = croatia.size();
        int wordsSize = words.length();
        int cnt = 0;
        int totalSize = 0;
        for(int i = 0; i<wordsSize; i++){
            for(int j = 0; j < listSize; j++){
                String croatiaWord = croatia.get(j);
                int size = croatiaWord.length();
                if(i + size > wordsSize)continue;
                if(words.substring(i, i+size).equals(croatiaWord)){
                    cnt++;
                    totalSize += size;
                    i = i + size - 1;
                    break;
                }
            }
        }

        System.out.println(cnt + words.length() - totalSize);
    }
}
