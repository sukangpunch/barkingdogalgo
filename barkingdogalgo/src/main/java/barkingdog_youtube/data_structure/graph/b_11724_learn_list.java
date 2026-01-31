package barkingdog_youtube.data_structure.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 연결 요소의 개수
// 인접 행열은 모든 요소를 단 한번씩만 보는데, 인접 리스트로 하면, 중복된 정점을 stack 에 저장할 수 있다
public class b_11724_learn_list {

    static List<ArrayList<Integer>> list;
    static boolean [] visited;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        list = new ArrayList<>();
        visited = new boolean[N+1];

        for(int i = 0; i<=N; i++){
            list.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            s = br.readLine().split(" ");
            int u = Integer.parseInt(s[0]);
            int v = Integer.parseInt(s[1]);
            list.get(u).add(v);
            list.get(v).add(u);
        }

        for(int i=1; i<=N; i++){
            if(!visited[i]){
                dfs(i);
            }
        }

        System.out.println(result);
    }

    private static void dfs(int start) {
        result++;
        Stack<Integer> st = new Stack<>();
        visited[start] = true;
        st.push(start);

        while(!st.isEmpty()){
            int now = st.pop();

            for(int nxt: list.get(now)){ // 인접 리스트에서는 push 때 방문 처리 해야함
                if(!visited[nxt]){
                    st.push(nxt);
                    visited[nxt] = true;
                }
            }
        }
    }
}
