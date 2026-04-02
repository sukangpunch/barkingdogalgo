package soma.second;


// 미로 탈출 명령어
// dfs(백트래킹), 그리디, 가지치기

/**
 * 너무 어려워서 ai 로 풀었다. 처음엔 백트래킹 + bfs인줄 알았는데 bfs로는 시간초과가 뜨고, 로직 자체 구현이 무리가 있음
 * 풀이 방법
 * 1. 이동을 위한 dx, dy를 사전순으로 빠른 이동 방향 d(아래), l(왼), r(오른), u(위) 순서에 맞게 초기화
 * 2. 첫 번째 가지치기: result 가 이미 나왔다면 더이상 탐색 없이 종료(사전순으로 빠른 순서로 dfs 탐색을 하기 때문에 처음으로 완성되는 값이 무조건 사전순으로 빠름)
 * 3. 두 번째 가지치기: 현재 거리 + 가야하는 거리 가 k보다 크다면 탐색에 의미가 없으므로 return
 * 4. 세 번째 가지치기: 나에게 남은 총 이동횟수(K-cnt)에서 목적지까지 가기위해 꼭 써야 하는 최소횟수(remainDist)를 - 했을 때, 홀수면 종료
 *    * 만약 남은 횟수가 3번이고 최소 2번 움직여야 한다면 2번으로 도착 후 1번을 꼭 이동해야하기 때문에 도착 불가(3-2 = 1홀수)
 *    * 만약 남은 횟수가 5번이고 최소 3번 움직여야 한다면 3번으로 도착 후 왔다갔다 2번 하면 됨(5-3 = 2짝수)
 */
public class PGS_150365 {

    public static void main(String[] args) {
        String answer = solution(3, 4, 2, 3, 3, 1, 5);
        System.out.println(answer);
    }

    static int N;
    static int M;
    static int R;
    static int C;
    static int K;
    static String result = null;

    static public String solution(int n, int m, int x, int y, int r, int c, int k) {
        N = n;
        M = m;
        R = r;
        C = c;
        K = k;

        dfs(x, y, 0, "");

        if(result == null){
            return "impossible";
        }else{
            return result;
        }
    }

    // dx, dy의 index는 사전순으로 높은 순 d, l, r, u 순으로 배치
    static int [] dx = {1, 0,0,-1};
    static int [] dy = {0, -1, 1, 0};
    static char [] dir = {'d', 'l', 'r', 'u'};

    static void dfs(int x, int y, int cnt, String path){
        // 1. 정답을 찾았으면 즉시 종료
        if(result != null) return;

        // 2. 현재 거리 + 남은 최단거리 > k 면 종료
        int remainDist = Math.abs(x - R) + Math.abs(y - C);
        if(cnt + remainDist > K) return;

        // 3. 남은 이동 횟수와 거리의 차이가 홀수이면 중단
        if(((K - cnt) - remainDist) %2 !=0) return;

        // 목적지 도착
        if(cnt == K){
            if(x == R && y == C) result = path;
            return;
        }

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 왔다 갔다 하는 것도 허용해야 하기 때문에 visited 활용 x 그리고 어짜피 제일 먼저 도착하는 문자열이 곧 정답
            if(nx>=1 && ny>=1 && nx<=N && ny<=M){
                dfs(nx, ny, cnt + 1, path + dir[i]);
            }
        }
    }
}
