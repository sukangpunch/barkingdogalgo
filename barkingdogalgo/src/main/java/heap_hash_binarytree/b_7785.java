package heap_hash_binarytree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 답 보기 : x
// 메모리 : 51192 kb
// 시간 : 672 ms
public class b_7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        Set<String> set = new HashSet<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String man = st.nextToken();
            String state = st.nextToken();
            if(state.equals("enter")) {
                set.add(man);
            }else{
                set.remove(man);
            }
        }

        set.stream().sorted(Collections.reverseOrder()).forEach(s->sb.append(s).append("\n"));
        System.out.println(sb);
    }
}
