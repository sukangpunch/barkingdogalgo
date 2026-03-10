package it_company_work_book.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

// 숨바꼭질 3
// dp, bfs
/**
 * 메모리 초과 이슈로 시간이 오래 걸렸다.
 * 현재 위치 N 에서 K까지 가는 최소의 경우를 구하면 된다.
 * N과 K 의 위치가 동적이기 때문에 dp 배열을 선언할 때, 문제에서 모든 값을 처리 가능한 배열 사이즈로 초기화
 * 현재 위치에서 x2 를 하는 방식이 최소 이동 방식이기 때문에 먼저 진행한다. 배열 범위 내에서 x2 가 가능하다면 dp 를 업데이트하고 큐에 넣는다.
 * -1 과 1 은 cost가 1 증가하므로 이를 고려하여 dp 를 업데이트하고 q에 넣는다.
 * q에서 꺼낸 Point가 K와 같다면 현재 cost를 출력하고 종료한다.
 */
public class BOJ_13549 {

    static class Point {

        int idx;
        int cost;

        public Point(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);

        if(N == K){
            System.out.println(0);
            return;
        }

        int []dp = new int[100001];
        Arrays.fill(dp, Integer.MAX_VALUE);
        PriorityQueue<Point> pq = new PriorityQueue<>((p1, p2) -> {
            return p1.cost - p2.cost;
        });

        pq.offer(new Point(N, 0));
        dp[N] = 0;

        while (!pq.isEmpty()) {
            Point point = pq.poll();
            int now = point.idx;
            int cost = point.cost;
            if(now == K){
                System.out.println(cost);
                return;
            }

            if (now * 2 < 100001 && cost < dp[now*2]) {
                dp[now*2] = dp[now];
                pq.offer(new Point(now * 2, dp[now*2]));
            }

            if (now - 1 >= 0 && cost + 1< dp[now-1]) {
                dp[now-1] = dp[now]+1;
                pq.offer(new Point(now - 1, dp[now-1]));
            }

            if (now + 1 < 100001 && cost + 1 < dp[now+1]) {
                dp[now+1] = dp[now]+1;
                pq.offer(new Point(now + 1, dp[now+1]));
            }
        }
    }
}
