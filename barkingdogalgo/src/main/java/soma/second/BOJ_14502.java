package soma.second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 연구소
// 백트래킹, bfs

/**
 * 백트래킹 + bfs 문제이다.
 * 벽을 3개 세우는 경우를 구하기 위해 backtraking 활용, 독 전파를 구하기 위해 bfs를 활용한다.
 * 독 위치, 벽을 세울 수 있는 위치 등을 미리 List에 담아둔다.
 * 백트래킹에선 벽을 세울 수 있는 위치를 순회하며, 가능한 조합을 구한 다음, depth가 3(최대 3개만 벽 세울 수 있다) 일때, 선택한 위치 targets를 기반으로 bfs 시작
 * bfs에선 독을 전파시켜야 하므로 q에 독 위치등을 담고, 여러 경우를 보기 위해 배열을 깊은 복사 하여 해당 상황에만 벽을 세우도록 한다.
 * 그리고 백트래킹에서 visited를 제거한 이유는, start 기반으로 탐색을 하려고 하기 때문, 이렇게 되면 굳이 이전값이나 현재 값을 또 탐색하는 일이 없어진다.
 * 예: 0(s:0) -> 1(s:1) -> 2(s:2) -> 3(s:3, 여기서는 기저조건) , 0(s:0) -> 1(s:1) -> 3(s:2, start에서 for문 증가) 가 되므로, 모든 조합을 visited 없이 구할 수 있다.
 */
public class BOJ_14502 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String []s = br.readLine().split(" ");

        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        int [][] map = new int[N][M];

        for(int i=0; i<N; i++){
            String [] input = br.readLine().split(" ");
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        int result = solution(N, M, map);

        System.out.println(result);
    }


    static class Point{
        int x;
        int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static List<Point> points;
    static List<Point> poisons;
    static List<Point> targets;
    //static boolean []visited;
    static int result;

    private static int solution(int n, int m, int [][] map) {
        result = 0;
        points = new ArrayList<>();
        poisons = new ArrayList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j]==0){
                    points.add(new Point(i, j));
                }else if(map[i][j] == 2){
                    poisons.add(new Point(i,j));
                }
            }
        }

        targets = new ArrayList<>();
        //visited = new boolean[points.size()];
        backtrack(0,0, map);
        return result;
    }

    private static void backtrack(int start, int depth, int [][]map) {
        if(depth == 3){
            result = Math.max(result, bfs(map));
            return;
        }

        for(int i=start; i<points.size(); i++){
            //if(visited[i])continue;

            targets.add(points.get(i));
            //visited[i] = true;
            backtrack(i+1, depth+1, map);
            targets.remove(targets.size()-1);
            //visited[i] = false;
        }
    }

    private static int bfs(int[][] map) {
        int n = map.length;
        int m = map[0].length;

        int [][] copyMap = new int[n][m];
        for(int i=0; i<n; i++){
            copyMap[i] = map[i].clone();
        }

        for(int i=0; i<targets.size(); i++){
            Point point = targets.get(i);
            copyMap[point.x][point.y] = 1;
        }

        Queue<Point> q = new LinkedList<>(poisons);

        while(!q.isEmpty()){
            Point now = q.poll();

            for(int i=0; i<4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx>=0 && nx<n && ny>=0 && ny<m && copyMap[nx][ny] == 0){
                    copyMap[nx][ny] = 2;
                    q.offer(new Point(nx,ny));
                }
            }
        }

        return counting(copyMap);
    }

    private static int counting(int[][] map) {
        int cnt = 0;
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[i].length; j++){
                if(map[i][j] == 0){
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
