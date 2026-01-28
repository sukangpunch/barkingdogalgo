package algorithm.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 불
public class b_5427_retry {

    static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int n;
    static int m;
    static Point person;
    static List<Point> fires;
    static boolean [][] pVisited;
    static boolean [][] fVisited;
    static int [][] direction = {{0,1}, {0,-1}, {1,0}, {-1,0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            pVisited = new boolean[m][n];
            fVisited = new boolean[m][n];
            fires = new LinkedList<>();

            for(int j=0; j<m; j++) {
                String line = br.readLine();
                for (int k = 0; k < n; k++) {
                    char ch = line.charAt(k);
                    switch (ch) {
                        case '#':
                            pVisited[j][k] = true;
                            fVisited[j][k] = true;
                            break;
                        case '*':
                            fires.add(new Point(j, k));
                            break;
                        case '@':
                            person = new Point(j, k);
                            break;
                    }
                }
            }

            int result = fireBfs();
            if(result == -1) {
                sb.append("IMPOSSIBLE").append("\n");
            }else{
                sb.append(result).append("\n");
            }
        }
        System.out.println(sb);
    }

    static int fireBfs(){
        if(person.y == 0 || person.x == 0 || person.y == m - 1 || person.x == n - 1) {
            return 1;
        }
        Queue<Point> personQ = new LinkedList<>();
        Queue<Point> personNowQ = new LinkedList<>();
        personQ.offer(person);
        Queue<Point> firesQ = new LinkedList<>();
        Queue<Point> firesNowQ = new LinkedList<>();
        for(Point f : fires) {
            firesQ.offer(f);
        }

        int turn = 0;
        while(!personQ.isEmpty()) {
            turn++;
            if(!firesQ.isEmpty()) {
                int fSize = firesQ.size();
                for(int i=0; i<fSize; i++) {
                    firesNowQ.add(firesQ.poll());
                }
            }

            int pSize = personQ.size();
            for(int i=0; i<pSize; i++) {
                personNowQ.add(personQ.poll());
            }

            while(!firesNowQ.isEmpty()) {
                Point now = firesNowQ.poll();
                fVisited[now.y][now.x] = true;
                for(int i=0; i<direction.length; i++) {
                    int dy = now.y + direction[i][0];
                    int dx = now.x + direction[i][1];

                    if(dy >= 0 && dy < m && dx >= 0 && dx < n && !fVisited[dy][dx]) {
                        fVisited[dy][dx] = true;
                        firesQ.offer(new Point(dy, dx));
                    }
                }
            }

            while(!personNowQ.isEmpty()) {
                Point now = personNowQ.poll();
                pVisited[now.y][now.x] = true;
                for(int i=0; i<direction.length; i++) {
                    int dy = now.y + direction[i][0];
                    int dx = now.x + direction[i][1];

                    if(dy >= 0 && dy < m && dx >= 0 && dx < n && !pVisited[dy][dx]) {
                        if(!fVisited[dy][dx]) {
                            pVisited[dy][dx] = true;
                            if(dy == 0 || dx == 0 || dy == m-1 || dx == n-1){
                                turn++;
                                return turn;
                            }
                            personQ.offer(new Point(dy, dx));
                        }
                    }
                }
            }
        }
        return -1;
    }
}
