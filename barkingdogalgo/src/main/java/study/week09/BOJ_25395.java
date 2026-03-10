package study.week09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 커넥티드 카 실험
// bfs, 투포인터

/**
 * 답지를 확인하였다.
 * 시작 커넥트 카 부터 왼쪽, 오른쪽으로 갈 수 있는 최저, 최대 값을 구한다.
 * 그래서 해당 범위의 locate에 해당하는 커넥트 카들은 방문 처리를 하고, 다음 탐색 지점으로 이용하기 위해 Queue 에 넣는다.
 * 또한 minLeftLocation, maxRightLocation 의 값을 게속 최저, 최대만 남기게 하는데, 그 이유는 새로운 커넥트 카에서 탐색을 한다 하여도,
 * 모든 경우의 수를 따지는 문제이기 때문에 가장 작고, 큰 locate, idx 범위는 이미 처리가 되었다는 뜻이기 때문이다.
 * 그래서 계속 업데이트 되는 최대 범위에 있어서 포함이 되면 visited에 표시하고, 포함이 되지 않으면 넘어간다.
 * 최종적으로 visited 배열에는 연결이 가능한 connected car 만 체크가 된다.
 */
public class BOJ_25395 {

    private static int now;

    static class Connector {

        int locate;
        int fuel;

        public Connector(int locate, int fuel) {
            this.locate = locate;
            this.fuel = fuel;
        }
    }

    static boolean[] visited;
    static int N;
    static int S;
    static Connector[] connectors;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        S = Integer.parseInt(s[1]);
        visited = new boolean[N + 1];
        connectors = new Connector[N+1];

        String [] strLocates = br.readLine().split(" ");
        String [] strFuels = br.readLine().split(" ");

        for(int i=0; i<N; i++){
            int locate = Integer.parseInt(strLocates[i]);
            int fuel = Integer.parseInt(strFuels[i]);
            connectors[i+1] = new Connector(locate, fuel);
        }

        findConnects();

        for(int i=1; i<=N; i++){
            if(visited[i])sb.append(i).append(" ");
        }

        System.out.println(sb);
    }

    private static void findConnects() {
        Queue<Integer> q = new LinkedList<>();
        int minLeftLocate = connectors[S].locate;
        int maxRightLocate = connectors[S].locate;
        int minLeftIdx = S;
        int maxRightIdx = S;
        visited[S] = true;
        q.add(S);
        while (!q.isEmpty()){
            now = q.poll();
            minLeftLocate = Math.min(minLeftLocate, connectors[now].locate - connectors[now].fuel);
            maxRightLocate = Math.max(maxRightLocate, connectors[now].locate + connectors[now].fuel);

            for(int left = minLeftIdx-1; left > 0; left--){
                if(connectors[left].locate < minLeftLocate) break;
                if(visited[left]) continue;

                minLeftIdx = Math.min(minLeftIdx, left);
                visited[left] = true;
                q.add(left);
            }

            for(int right = maxRightIdx+1; right <= N; right++){
                if(connectors[right].locate > maxRightLocate)break;
                if(visited[right]) continue;

                maxRightIdx = Math.max(maxRightIdx, right);
                visited[right] = true;
                q.add(right);
            }
        }
    }
}
