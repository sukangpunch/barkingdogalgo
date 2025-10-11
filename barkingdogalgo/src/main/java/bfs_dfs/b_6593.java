package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b_6593 {

    static class Node{
        int z;
        int y;
        int x;

        public Node(int z, int y, int x) {
            this.z = z;
            this.y = y;
            this.x = x;
        }
    }

    static int [][] direction = {{0,0,1},{0,0,-1}, {0,1,0},{0,-1,0}, {1,0,0}, {-1,0,0}};
    static boolean [][][] visited;
    static Node startNode;
    static Node endNode;
    static int count;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if(L == 0 && R == 0 && C == 0) {
                break;
            }

            visited = new boolean[L][R][C];

            for(int i = 0; i < L; i++){
                for(int j = 0; j < R; j++){
                    String input = br.readLine();
                    for(int k = 0; k < C; k++){
                        if(input.charAt(k) == 'S'){
                            startNode = new Node(i, j, k);
                            visited[i][j][k] = true;
                        }else if(input.charAt(k) == '#'){
                            visited[i][j][k] = true;
                        }else if(input.charAt(k) == 'E'){
                            endNode = new Node(i, j, k);
                        }
                    }
                }
                br.readLine();
            }

            if(!findWay(L,R,C)){
                sb.append("Trapped!").append("\n");
            }else{
                sb.append(String.format("Escaped in %d minute(s).", count)).append("\n");
            }
        }

        System.out.println(sb);
    }

    private static boolean findWay(int L, int R, int C) {
        Queue<Node> mainQ = new LinkedList<>();
        mainQ.offer(startNode);
        count = 0;

        while(!mainQ.isEmpty()){
            count++;
            Queue<Node> tempQ = new LinkedList<>();
            int size = mainQ.size();
            for(int i=0; i<size; i++){
                tempQ.offer(mainQ.poll());
            }

            while(!tempQ.isEmpty()){
                Node now = tempQ.poll();
                if(endNode.z == now.z && endNode.y == now.y && endNode.x == now.x){
                    count--; // 마지막 도착은 count 안함
                    return true;
                }

                for(int i=0; i<direction.length; i++){
                    int dz = now.z + direction[i][0];
                    int dy = now.y + direction[i][1];
                    int dx = now.x + direction[i][2];

                    if(dz>=0 && dz<L && dy>=0 && dy<R && dx>=0 && dx<C && !visited[dz][dy][dx]){
                        visited[dz][dy][dx] = true;
                        mainQ.offer(new Node(dz, dy, dx));
                    }
                }
            }
        }

        return false;
    }
}
