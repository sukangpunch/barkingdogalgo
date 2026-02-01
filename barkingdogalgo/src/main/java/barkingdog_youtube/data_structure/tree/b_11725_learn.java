package barkingdog_youtube.data_structure.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 트리의 부모 찾기
public class b_11725_learn {

    static int N;
    static List<ArrayList<Integer>> list;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        parent = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            String[] s = br.readLine().split(" ");
            int v1 = Integer.parseInt(s[0]);
            int v2 = Integer.parseInt(s[1]);
            list.get(v1).add(v2);
            list.get(v2).add(v1);
        }

        bfs(1);

        for (int i = 2; i <= N; i++) {
            sb.append(parent[i]).append("\n");
        }

        System.out.println(sb);
    }

    private static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            int now = q.poll();

            for (int nxt: list.get(now)){
                if(parent[now] == nxt)continue;
                parent[nxt] = now;
                q.add(nxt);
            }
        }
    }

    private static void dfs(int start) {
        for (int nxt : list.get(start)) {
            if (parent[start] == nxt) {
                continue;
            }
            parent[nxt] = start;
            dfs(nxt);
        }
    }
}
