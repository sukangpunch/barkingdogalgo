package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 단어 정렬
public class b_1181 {

    static List<String> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        list = new ArrayList<>();

        Set<String> set = new HashSet<>();

        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            set.add(s);
        }

        list.addAll(set);

        list.sort(Comparator.comparing(String::length)
                          .thenComparing(String::compareTo));

        for(String m : list){
            sb.append(m).append("\n");
        }

        System.out.println(sb);
    }
}
