package study.week10;

// 아이템 줍기
// BFS

import java.util.LinkedList;
import java.util.Queue;

/**
 * 시간복잡도 : O(N*W*H)
 * ㄷ 자 처럼 공간 건너뛰는 문제를 해결하기 위해 모든 좌표(사각형, 시작점, 아이템위치) 를 전부 2배하였다.
 * 그러면 최소 차이나는 위치가 2가 되므로 공간 뛰어넘는 문제를 해결할 수 있다.
 * 또한 각 좌표마다 사각형의 테두리 유효를 보지 않고, 미리 테두리만 딴 map 배열을 두고 하는 것이 효율적
 * 사각형 내부면 2, 테두리면 1로 두는데, 테두리가 다른 사각형 내부일 수 있으므로 2는 1을 덮을 수 있지만, 1은 2를 덮지 못하게 한다.
 * 이렇게 map 을 구한 다음 bfs를 진행하면 된다. map 1인부분, 방문 안한지점, 최대 최소 범위를 벗어나지 않은 좌표를 조건으로 탐색한다.
 * 만약 start와 item 의 위치가 같다면 cnt/2 의 값을 리턴하면 정답(모든 좌표를 2배했기에 탐색 거리도 2배가 된다)
 */
public class PGS_87694 {
    static class Solution {
        static class Point{
            int x;
            int y;
            int cnt;

            public Point(int x, int y, int cnt){
                this.x = x;
                this.y = y;
                this.cnt = cnt;
            }
        }

        static int[] dx = {1,0,-1,0};
        static int[] dy=  {0,1,0,-1};

        public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
            int answer = 0;
            // 2배로 범위를 잡고, 각 사각형 및 좌표를 2배씩 하는 이유는, ㄷ 자처럼 공간을 뛰어넘는 문제를 해결하기 위함이다.
            int[][] map = new int[102][102];

            // 각 사각형들 순회하면서 map 만들기
            for(int[] rec: rectangle){
                int downX = rec[0] * 2;
                int downY = rec[1] * 2;
                int upX = rec[2] * 2;
                int upY = rec[3] * 2;

                // 여기서 범위를 직사각형으로 가둬서 테두리 외부는 아에 가능성 x
                for (int x = downX; x <= upX; x++) {
                    for (int y = downY; y <= upY; y++) {
                        // 직사각형의 내부인 경우 2로 채움 (테두리가 덮어쓰지 못하도록)
                        if (x > downX && x < upX && y > downY && y < upY) {
                            map[x][y] = 2;
                        }
                        // 직사각형의 테두리인 경우, 다른 직사각형의 내부(2)가 아닐 때만 1로 채움
                        // 만약 1번 직사각형의 테두리가, 다른 직사각형의 내부일 수도 있으므로 !=2 일때만 채움
                        else if (map[x][y] != 2) {
                            map[x][y] = 1;
                        }
                    }
                }
            }

            return bfs(map, characterX * 2, characterY * 2, itemX * 2, itemY * 2);
        }

        private static int bfs(int[][] map, int startX, int startY, int itemX, int itemY) {
            Queue<Point> q = new LinkedList<>();
            boolean[][] visited = new boolean[102][102];

            q.add(new Point(startX, startY, 0));
            visited[startX][startY] = true;

            while (!q.isEmpty()) {
                Point now = q.poll();

                // 아이템 위치에 도달하면, 거리를 2배로 뻥튀기 했었으므로 다시 2로 나누어 반환
                if (now.x == itemX && now.y == itemY) {
                    return now.cnt / 2;
                }

                for (int i = 0; i < 4; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];

                    // 맵 범위를 벗어나지 않고, 방문한 적 없으며, 테두리(1)인 곳만 이동
                    if (nx >= 0 && nx <= 100 && ny >= 0 && ny <= 100) {
                        if (!visited[nx][ny] && map[nx][ny] == 1) {
                            visited[nx][ny] = true;
                            q.offer(new Point(nx, ny, now.cnt + 1));
                        }
                    }
                }
            }
            return 0;
        }
    }
}
