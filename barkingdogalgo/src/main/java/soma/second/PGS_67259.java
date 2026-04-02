package soma.second;

import java.util.PriorityQueue;

// 경주로 건설
// bfs, 구현

/**
 * 처음에 2차원 배열 visited 로 구현했다가 틀렸다.
 * 이유:
 * 현재 그리디하게, 현재 좌표 기준에서 가장 cost가 적거나 같은 값으로 업데이트하고 pq 에 추가하는 방식인데, 현재의 그리디한 선택이 나중에까지 효율적으로 남지 않는다(코너가 후반부에 많아질수도 있기 때문)
 * 2차원 visited[x][y]: "여기까지 1000원에 왔어"라는 정보만 남음.
 * 3차원 visited[dir][x][y]: "여기까지 동쪽 방향으로 1100원에 왔어"라는 정보를 남김.
 * 그래서 해결방법은 각 방향에 대한 visited를 다 따로 두는 것(3차원배열). + Road 클래스에서 direction 방향을 가지고 있는 것
 * 4가지 방향에 따라서 각 visited에 nextCost를 업데이트 한다. 즉, 서로 다른 방향에 대해서는 visited 비교 연산에 활용되지 않는 것.
 * 그렇게 4가지 방향에 대한 bfs가 끝나면 visited[i][n-1][n-1] 중 가장 최소 값을 리턴 하면 된다.
 * 즉, Road에서 현재 상황의 방향, cost정보를 들고 있고, visited 배열에서는 각 방향별로 그 정보를 기록해 놓는 것.
 */
public class PGS_67259 {

    public static void main(String[] args) {
        int [][] board = {{0,0,1,0}, {0,0,0,0}, {0,1,0,1},{1,0,0,0}};
        int result = solution(board);

        System.out.println(result);
    }

    public static int solution(int[][] board) {
        return bfs(board);
    }

    static class Road implements Comparable<Road> {

        int x;
        int y;
        int cost;
        int direction;

        public Road(int x, int y, int cost, int direction) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.direction = direction;
        }

        @Override
        public int compareTo(Road r) {
            return this.cost - r.cost;
        }
    }

    // 동(0), 서(1), 남(2), 북(3);
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static int [][][] visited;

    static int bfs(int[][] board) {
        int n = board.length;
        visited = new int[4][n][n];

        for(int i=0; i<4; i++){
            for(int j=0; j<n; j++){
                for(int k = 0; k<n; k++){
                    visited[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }

        PriorityQueue<Road> pq = new PriorityQueue<>();
        // 시작점에서 동쪽(0)과 남쪽(2)으로 출발 가능할 때 초기값 설정
        // 시작점 (0,0) 자체는 방향이 없으므로, 처음 이동하는 칸에 방향을 부여하며 시작
        if (board[0][1] == 0) {
            pq.offer(new Road(0, 1, 100, 0));
            visited[0][0][1] = 100;
        }
        if (board[1][0] == 0) {
            pq.offer(new Road(1, 0, 100, 2));
            visited[2][1][0] = 100;
        }

        while (!pq.isEmpty()) {
            Road now = pq.poll();

            if(visited[now.direction][now.x][now.y] < now.cost)continue;

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n && board[nx][ny] == 0) {
                    int nextCost = (now.direction == i) ? now.cost + 100 : now.cost + 600;

                    if(visited[i][nx][ny] > nextCost){
                        visited[i][nx][ny] = nextCost;
                        pq.offer(new Road(nx,ny, nextCost, i));
                    }
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for(int i=0; i<4; i++){
            result = Math.min(result, visited[i][n-1][n-1]);
        }
        return result;
    }
}
