package heap_hash_binarytree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 답 보기 : x
// 메모리 : 26164 kb
// 시간 : 280 ms
public class b_1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        for(int i = 0; i < N; i++){
            set1.add(br.readLine());
        }

        for(int i = 0; i < M; i++){
            String input = br.readLine();
            if(set1.contains(input)){
                set2.add(input);
            }
        }

        sb.append(set2.size()).append("\n");
        set2.stream().sorted().forEach(s-> sb.append(s).append("\n"));

        System.out.println(sb);
    }
}
