package algorithm.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 숨바꼭질3
public class b_13549_retry {
    static class Node{
        int num;
        int count;

        public Node(int num, int count){
            this.num = num;
            this.count = count;
        }
    }

    static int N;
    static int K;
    static boolean [] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        K = Integer.parseInt(str[1]);
        visited = new boolean[100001];

        int result = findCatchWay();
        System.out.println(result);
    }

    private static int findCatchWay() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(N, 0));
        visited[N] = true;

        while(!q.isEmpty()) {
            Node cur = q.poll();

            if(cur.num == K) {
                return cur.count;
            }

            int jump = cur.num * 2;
            int back = cur.num - 1;
            int front = cur.num + 1;

            if(0 <= jump && jump <= 100000 && !visited[jump]) {
                q.offer(new Node(jump, cur.count));
                visited[jump] = true;
            }

            if(0 <= front && front <= 100000 && !visited[front]) {
                q.offer(new Node(front, cur.count + 1));
                visited[front] = true;
            }

            if(0 <= back && back <= 100000 && !visited[back]) {
                q.offer(new Node(back, cur.count + 1));
                visited[back] = true;
            }
        }
        return 0;
    }

}
