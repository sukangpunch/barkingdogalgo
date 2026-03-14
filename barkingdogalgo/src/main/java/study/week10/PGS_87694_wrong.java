package study.week10;

import java.util.LinkedList;
import java.util.Queue;

// 아이템 줍기
// BFS
public class PGS_87694_wrong {

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
        static int[] dy = {0,1,0,-1};

        static Point start;
        static Point item;
        static boolean [][] visited;

        public int solution(
                int[][] rectangle,
                int characterX,
                int characterY,
                int itemX,
                int itemY
        ) {
            int answer = 0;
            start = new Point(characterX, characterY, 0);
            item = new Point(itemX, itemY, 0);
            visited = new boolean[51][51];

            answer = bfs(rectangle);

            return answer;
        }

        private static int bfs(int[][] rectangle){
            Queue<Point> q = new LinkedList<>();
            q.add(start);
            visited[start.x][start.y] = true;

            while(!q.isEmpty()){
                Point now = q.poll();

                if(now.x == item.x && now.y == item.y){
                    return now.cnt;
                }
                for(int i=0; i<4; i++){
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];

                    if(!visited[nx][ny] && check(rectangle, nx, ny)){
                        q.offer(new Point(nx, ny, now.cnt + 1));
                        visited[nx][ny] = true;
                    }
                }
            }
            return 0;
        }

        private static boolean check(int [][] rectangle, int x, int y){
            if(x > 50 || x<0 || y>50 || y<0)return false; // 여기서 & 연산으로 처리해서 걸릴 수 없는 조건 걸어서 실수함

            boolean isLine = false;
            // 여기서 체크 할 때, ㄷ 자 모양으로 테두리가 만들어지면 실제로 이어지지 않아도 건너뛰는 현상 발생(접근 자체가 잘못된 로직)
            for(int i=0; i<rectangle.length; i++){
                int [] oneRec = rectangle[i];
                for(int j=0; j<oneRec.length; j++){
                    int downX = oneRec[0];
                    int downY = oneRec[1];
                    int upX = oneRec[2];
                    int upY = oneRec[3];

                    if(x > downX && x < upX && y > downY && y < upY){
                        return false;
                    }else if((x == downX && y >= downY && y <= upY) ||
                            (x == upX && y>=downY && y<=upY) ||
                            (y == downY && x >=downX && x <= upX) ||
                            (y == upY && x >= downX && x <= upX)){
                        isLine = true;
                        continue;
                    }
                }
            }

            if(isLine){
                return true;
            }else{
                return false;
            }
        }
    }
}
