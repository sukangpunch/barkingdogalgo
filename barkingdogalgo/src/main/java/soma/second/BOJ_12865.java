package soma.second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 평범한 배낭
// dp

/**
 * 동작 원리
 * 1. item 을 받아서 List에 넣고 가중치 기반으로 정렬한다.
 * 2. 배열을 선언하는데 행은 n+1(아이템 개수+1), 열은(가방용량+1) 로 선언(계산의 편의를 위해)
 * 3. 각 item 별로 dp를 돌리는데, 해당 item만 사용했을 경우 dp[i][] 값들을 채우고 다음 아이템 탐색 시 해당 값을 활용한다.
 * 4. dp의 동작의 예는 다음과 같다.
 * 4_1 첫번쨰 아이템 사용 후 0 0 3 3 3 3 3 이라면 -> 다음 아이템 사용 후 0 0 3 4 4 4 7
 * 4_2 즉, dp[i][j] 는 Max(dp[i-1][j]{이전 아이템 사용 가치}, dp[i-1][j-현재아이템무게] + 현재 아이템 가치) 가 된다.
 * 5. 최종적으로 dp[n][k] 에는 모든 아이템을 고려한 k 용량의 배낭에 채울 수 있는 최대값만 남게 된다.
 */
public class BOJ_12865 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String []s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);

        int [][] items = new int[N][2];
        for(int i=0; i<N; i++){
            s = br.readLine().split(" ");
            int W = Integer.parseInt(s[0]);
            int V = Integer.parseInt(s[1]);
            items[i][0] = W;
            items[i][1] = V;
        }

        int result = solution(N, K, items);
        System.out.println(result);
    }

    static class Item implements Comparable<Item>{
        int w;
        int v;

        public Item(int w, int v){
            this.w = w;
            this.v = v;
        }

        @Override
        public int compareTo(Item i){
            return this.w - i.w;
        }
    }

    static List<Item> list;
    private static int solution(int n, int k, int[][] items) {
        list = new ArrayList<>();
        for(int i=0; i<n; i++){
            list.add(new Item(items[i][0], items[i][1]));
        }

        Collections.sort(list);

        int [][]dp = new int[n+1][k+1];

        for(int i=1; i<=n; i++){
            Item now = list.get(i-1);
            for(int j=1; j<=k; j++){
                if(now.w <= j){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-now.w] + now.v);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][k];
    }
}
