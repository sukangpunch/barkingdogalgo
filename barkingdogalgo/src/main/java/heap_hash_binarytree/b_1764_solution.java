package heap_hash_binarytree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

// 답 보기 : gtp 추천
// 메모리 : 26284 kb
// 시간 : 264 ms
public class b_1764_solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new TreeSet<>();

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
        set2.forEach(s-> sb.append(s).append("\n"));

        System.out.println(sb);
    }
}
