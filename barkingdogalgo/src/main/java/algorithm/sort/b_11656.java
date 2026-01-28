package algorithm.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 접미사 배열
public class b_11656 {
    static class Suffix implements Comparable<Suffix> {
        String suffix;

        public Suffix(String suffix) {
            this.suffix = suffix;
        }

        @Override
        public int compareTo(Suffix other) {
            return suffix.compareTo(other.suffix); // 만약 사전순으로 this 가 작으면 음수 리턴(오름차순)
        }
    }

    static List<Suffix> suffixs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input=  br.readLine();
        suffixs = new ArrayList<>();

        for(int i=0; i<input.length(); i++){
            suffixs.add(new Suffix(input.substring(i)));
        }

        Collections.sort(suffixs);

        for(Suffix s : suffixs){
            sb.append(s.suffix).append("\n");
        }

        System.out.println(sb);
    }
}
