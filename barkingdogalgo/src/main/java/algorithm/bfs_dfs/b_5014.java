package algorithm.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

// 스타트링크
public class b_5014 {

    static boolean [] visited;
    static int F;
    static int S;
    static int G;
    static int U;
    static int D;
    static int [] direction;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] s = br.readLine().split(" ");
        F = Integer.parseInt(s[0]);
        S = Integer.parseInt(s[1]);
        G = Integer.parseInt(s[2]);
        U = Integer.parseInt(s[3]);
        D = Integer.parseInt(s[4]);

        visited = new boolean[F+1];
        direction = new int[]{U, -D};

        int result = bfs();
        if(result == -1) {
            System.out.println("use the stairs");
        }else{
            System.out.println(result);
        }

    }

    static int bfs(){
        Queue<Integer> q = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        q2.add(S);
        int cnt = -1;

        while(!q2.isEmpty()){
            cnt++;
            int size = q2.size();
            for(int i = 0; i < size; i++){
                q.add(q2.poll());
            }

            while(!q.isEmpty()){
                int now = q.poll();

                if(now == G){
                    return cnt;
                }

                for(int i=0; i<2; i++){
                    int d = now + direction[i];

                    if(d>=1 && d<=F && !visited[d]){
                        visited[d] = true;
                        q2.add(d);
                    }
                }
            }
        }
        return -1;
    }
}
