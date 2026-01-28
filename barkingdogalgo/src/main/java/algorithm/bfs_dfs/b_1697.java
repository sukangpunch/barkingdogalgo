package algorithm.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 답 보기 : x
// 메모리 : 94416 kb
// 시간 : 340 ms
public class b_1697 {
    static boolean [] visited;
    static int N;
    static int K;
    static int max = 100001;
    static int time = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[max];
        bfs();
        System.out.println(time);
    }

    static void bfs(){
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        q1.add(N);
        while(!q1.isEmpty()){
            time++;
            int size = q1.size();
            for(int i=0; i<size; i++){
                q2.add(q1.poll());
            }
            while(!q2.isEmpty()){
                int cur = q2.poll();
                if(cur == K){
                    return;
                }
                visited[cur] = true;
                for(int i=0; i<3; i++){
                    if(i==0 && cur*2 <max &&!visited[cur*2]){
                        q1.add(cur*2);
                    }else if(i==1 && cur+1 < max && !visited[cur+1]){
                        q1.add(cur+1);
                    }else if(i==2 && cur-1>=0 &&!visited[cur-1]){
                        q1.add(cur-1);
                    }
                }
            }
        }

    }
}
