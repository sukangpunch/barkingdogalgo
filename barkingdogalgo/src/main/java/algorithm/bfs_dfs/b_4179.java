package algorithm.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 답 보기 : x (질문게시판 반례 확인)
// 메모리 : 104912 kb
// 시간 : 700 ms
public class b_4179 {

    static class Node{
        private int x;
        private int y;

        public Node(int y, int x){
            this.y = y;
            this.x = x;
        }
    }


    static int[][] manMap;
    static int[][] fireMap;
    static Node man;
    static List<Node> fire;
    static int [][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
    static int count;
    static int R;
    static int C;
    static boolean escape;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        manMap = new int[R][C];
        fireMap = new int[R][C];
        fire = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                if(input.charAt(j) == 'J'){
                    man = new Node(i, j);
                }else if(input.charAt(j) == 'F'){
                    fire.add(new Node(i, j));
                }else if(input.charAt(j) == '#'){
                    manMap[i][j] = 1;
                    fireMap[i][j] = 1;
                }
            }
        }
        bfs();
        if(escape){
            System.out.println(count);
        }else{
            System.out.println("IMPOSSIBLE");
        }
    }

    static void bfs(){
        Queue<Node> jiHun1 = new LinkedList<>();
        Queue<Node> jiHun2 = new LinkedList<>();

        Queue<Node> fire1 = new LinkedList<>();
        Queue<Node> fire2 = new LinkedList<>();

        jiHun1.add(man);
        fire1.addAll(fire);

        while(!jiHun1.isEmpty()){
            int size = jiHun1.size();
            for(int i = 0; i < size; i++){
                jiHun2.add(jiHun1.poll());
            }

            count++;
            size = fire1.size();
            for(int i = 0; i < size; i++){
                fire2.add(fire1.poll());
            }

            while(!fire2.isEmpty()){
                Node now = fire2.poll();
                fireMap[now.y][now.x] = 1;
                for(int[] direction : directions) {
                    int dy = now.y + direction[0];
                    int dx = now.x + direction[1];

                    if (dy >= 0 && dy < R && dx >= 0 && dx < C && fireMap[dy][dx] == 0) {
                        fire1.add(new Node(dy, dx));
                        fireMap[dy][dx]= 1;
                    }
                }
            }

            while(!jiHun2.isEmpty()){
                Node now = jiHun2.poll();
                if(manMap[now.y][now.x] == 1){
                    continue;
                }
                if(now.y == R-1 || now.x == C-1 || now.y==0 || now.x==0){
                    escape = true;
                    return;
                }
                manMap[now.y][now.x] = 1;
                for(int[] direction : directions){
                    int dy = now.y + direction[0];
                    int dx = now.x + direction[1];

                    if(fireMap[dy][dx] == 1 || manMap[dy][dx] == 1){
                        continue;
                    }

                    if(dy>=0 && dy<R && dx>=0 && dx<C){
                        if(dx == C-1 || dy == R-1 || dx==0 || dy==0){
                            count++;
                            escape = true;
                            return;
                        }
                        jiHun1.add(new Node(dy,dx));
                    }
                }
            }
        }
    }
}
