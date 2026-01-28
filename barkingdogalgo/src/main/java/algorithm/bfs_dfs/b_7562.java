package algorithm.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

// 답 보기 : x
// 메모리 : 44080 kb
// 시간 : 336 ms
public class b_7562 {
    static class Point{
        private int y;
        private int x;

        public Point(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    static boolean[][] visited;
    static int [][] direction = {{2,1},{2,-1},{1,2},{-1,2},{-2,-1},{-2,1},{1,-2},{-1,-2}};
    static Point start;
    static Point target;
    static int count;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            int size = Integer.parseInt(br.readLine());
            String []input1 = br.readLine().split(" ");
            String []input2 = br.readLine().split(" ");
            visited = new boolean[size][size];
            start = new Point(Integer.parseInt(input1[0]), Integer.parseInt(input1[1]));
            target = new Point(Integer.parseInt(input2[0]), Integer.parseInt(input2[1]));
            bfs(size);
        }

        System.out.println(sb);
    }

    static void bfs(int size){
        count = -1;
        Queue<Point> startQ = new ArrayDeque<>();
        Queue<Point> oneTimeQ = new ArrayDeque<>();
        startQ.add(start);
        while(!startQ.isEmpty()){
            count++;
            int qSize = startQ.size();
            for(int i=0; i<qSize; i++){
                oneTimeQ.add(startQ.poll());
            }
            while(!oneTimeQ.isEmpty()){
                Point p = oneTimeQ.poll();
                if(p.x == target.x && p.y == target.y){
                    sb.append(count).append("\n");
                    return;
                }
                for(int i=0; i<8; i++){
                    int dy = p.y + direction[i][0];
                    int dx = p.x + direction[i][1];

                    if(dy >=0 && dy <size && dx>=0 && dx <size && !visited[dy][dx]){
                        startQ.add(new Point(dy, dx));
                        visited[dy][dx] = true;
                    }
                }
            }
        }
    }
}
