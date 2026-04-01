package soma.second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 인구 이동
// bfs

/**
 * 1. map 을 순회하며, 방문하지 않는 나라를 기반으로 bfs를 돌린다.
 * 2. bfs 를 돌릴 때, 연합이 가능한 나라들을 List에 넣고 해당 사이즈가 1 보다 크면(시작점 포함) 연합이 이루어지므로 평균화 및 방문처리
 * 3. 방문처리가 안된 나라면 다시 bfs(독립적인 연합이 또 생길 수 있으므로)
 * 4. 모든 반복이 끝나면 days++ 
 * 5. 평균화 작업 이후, 또 조건에 맞게 평균화 가능성이 생길 수 있으므로, visited배열 초기화 후 재반복
 * 6. 만약 모든 반복을 돌았는데 isMoved가 false(평균화 대상이 없음) 이면 종료
 */
public class BOJ_16234 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int L = Integer.parseInt(s[1]);
        int R = Integer.parseInt(s[2]);

        int [][] map = new int[N][N];

        for(int i=0; i<N; i++){
            s = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        int result = solution(N, L, R, map);
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

    static int [] dx = {0, 1, 0, -1};
    static int [] dy = {1, 0, -1, 0};
    static boolean [][] visited;
    static List<Point> union;
    private static int solution(int n, int l, int r, int[][] map) {

        int days = 0;
        while(true){
            visited = new boolean[n][n];
            boolean isMoved = false;

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(!visited[i][j]){
                        if(bfs(n,l,r,i,j,map)){
                            isMoved = true;
                        }
                    }
                }
            }

            if(!isMoved){
                break;
            }
            days++;
        }

        return days;
    }

    private static boolean bfs(int n, int l, int r, int x, int y, int[][] map) {
        Queue<Point> q = new LinkedList<>();
        List<Point> currentUnion = new ArrayList<>(); // 만약 독립적인 연합이 여럿 생길 수 있기에, 한번의 bfs 에서 가능한 경우를 다 처리

        Point start = new Point(x, y);
        q.add(start);
        currentUnion.add(start);
        visited[x][y] = true;

        int totalPopulation = map[x][y];

        while(!q.isEmpty()){
            Point now = q.poll();

            for(int i=0; i<4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx>=0 && nx<n && ny>=0 && ny < n && !visited[nx][ny]){
                    int diff = Math.abs(map[now.x][now.y] - map[nx][ny]);
                    if(diff >= l && diff <= r){
                        visited[nx][ny] = true;
                        Point next = new Point(nx, ny);
                        q.add(next);
                        currentUnion.add(next);
                        totalPopulation += map[nx][ny];
                    }
                }
            }
        }

        if(currentUnion.size() > 1){
            int avg = totalPopulation/currentUnion.size();
            for (Point p : currentUnion){
                map[p.x][p.y] = avg;
            }

            return true;
        }
        return false;
    }

}
