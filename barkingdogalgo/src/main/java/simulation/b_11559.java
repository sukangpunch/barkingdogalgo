package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// Puyo Puyo
public class b_11559 {
    static class Node{
        int y;
        int x;
        char type;

        public Node(int y, int x,char type){
            this.y = y;
            this.x = x;
            this.type = type;
        }
    }

    static char[][] map;
    static int [][] direction = {{1,0},{-1,0},{0,1},{0,-1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[12][6];

        for(int i=0;i<12;i++){
            String s = br.readLine();
            for(int j=0;j<6;j++){
                map[i][j] = s.charAt(j);
            }
        }

        int N = 1;
        for(int time = 0; time < N; time++){
            boolean isMore = false;
            boolean [][] visited = new boolean[12][6];

            for(int i=0;i<12;i++){
                for(int j=0;j<6;j++){
                    if(map[i][j] != '.' && ! visited[i][j]){
                        if(simulationPuyo(i, j, visited)){
                            isMore = true;
                        }
                    }
                }
            }
            if(isMore){
                arrange();
                N++;
            }
        }

        System.out.println(N-1);
    }

    private static void arrange() {
        for(int i=11;i>=0;i--){
            for(int j=5;j>=0;j--){
                if(map[i][j] != '.'){
                    int temY = i;
                    char type = map[i][j];
                    while(true){
                        int dy = temY+1;
                        if(dy > 11 || map[dy][j] != '.'){
                            break;
                        }

                        map[dy][j] = type;
                        map[temY][j] = '.';
                        temY = temY+1;
                    }
                }
            }
        }
    }


    private static boolean simulationPuyo(int y, int x, boolean[][] visited) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(y,x,map[y][x]));
        visited = new boolean[12][6];
        visited[y][x] = true;
        int count = 1;

        while(!q.isEmpty()){
            Node cur = q.poll();
            for(int i=0;i<direction.length;i++){
                int dy = cur.y + direction[i][0];
                int dx = cur.x + direction[i][1];

                if(dy >= 0 && dy < 12 && dx>=0 && dx < 6 && map[dy][dx] == cur.type && !visited[dy][dx]){
                    visited[dy][dx] = true;
                    q.add(new Node(dy,dx,map[dy][dx]));
                    count++;
                }
            }
        }

        if(count >= 4){
            for(int i=0;i<12;i++){
                for(int j=0;j<6;j++){
                    if(visited[i][j]){
                        map[i][j] = '.';
                    }
                }
            }

            return true;
        }

        return false;
    }
}
