package soma.second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 집합의 표현
// union-find

/**
 * 경로 압축: parent[x] = find(parent[x]) 를 통해 재귀적으로 루트를 찾음과 동시에 모든 노드가 직접 루트를 가리키도록 만듭니다.
 * 이 처리가 없으면 트리가 한쪽으로 길어져 시간 복잡도가 $O(N)$까지 늘어날 수 있지만, 처리를 하면 거의 $O(1)$에 가깝게 동작
 */
public class BOJ_1717 {

    static int []parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String []s = br.readLine().split(" ");

        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        parent = new int[N+1];
        for(int i=0; i<=N; i++){
            parent[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            s = br.readLine().split(" ");
            int type = Integer.parseInt(s[0]);
            int a = Integer.parseInt(s[1]);
            int b = Integer.parseInt(s[2]);

            if(type == 0){
                union(a, b);
            }else{
                if(find(a) == find(b)){
                    sb.append("YES\n");
                }else{
                    sb.append("NO\n");
                }
            }
        }
        System.out.println(sb);
    }

    private static int find(int x){
        if(parent[x] == x){
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    private static void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);

        if(rootA != rootB){
            parent[rootB] = rootA;
        }
    }
}
