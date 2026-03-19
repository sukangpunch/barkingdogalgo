package it_company_work_book.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 뱀과 사다리 게임
// bfs

/**
 * 시간복잡도 : O(V+E)
 * 사다리의 시작-끝을 가지고 있는 배열과 뱀의 시작-끝을 가지고 있는 배열을 선언하고 채운다.
 * 1부터 시작하여 CNT 값과 함께 BFS 를 돌린다.
 * 주사위는 1~6이 가능하기에 6~1의 숫자를 기반으로 현재 위치에서 이동한다.
 * 이동한 위치에 뱀이나 사다리가 있으면 무조건 타게 한다(뱀, 사다리 중복 x)
 * 위 연산을 locate가 처음으로 100이 될떄의 cnt 값이 최저 cnt 값이 된다.(bfs이므로)
 */
public class BOJ_16928 {

    static class Point {

        int locate;
        int cnt;

        public Point(int locate, int cnt) {
            this.locate = locate;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        int[] ladder = new int[101];
        int[] snake = new int[101];

        for (int i = 0; i < N; i++) {
            s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            ladder[x] = y;
        }

        for (int i = 0; i < M; i++) {
            s = br.readLine().split(" ");
            int u = Integer.parseInt(s[0]);
            int v = Integer.parseInt(s[1]);
            snake[u] = v;
        }

        boolean[] visited = new boolean[101];
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(1, 0));
        visited[1] = true;

        int result = 0;
        while (!q.isEmpty()) {
            Point now = q.poll();
            if (now.locate == 100) {
                result = now.cnt;
                break;
            }

            for (int i = 6; i >= 1; i--) {
                int nextLocate = now.locate + i;
                if (nextLocate <= 100) {
                    int target = nextLocate;

                    if(snake[nextLocate] != 0){
                        target = snake[nextLocate];
                    }else if(ladder[nextLocate] != 0){
                        target = ladder[nextLocate];
                    }

                    if(!visited[target]){
                        visited[target] = true;
                        q.add(new Point(target, now.cnt + 1));
                    }
                }
            }
        }
        System.out.println(result);
    }
}
