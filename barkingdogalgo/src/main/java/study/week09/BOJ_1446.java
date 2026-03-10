package study.week09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 지름길
// dp

/**
 * 1부터 D까지 순회하면서 현재 i값에 대하여 지름길의 end 가 같을 때, 해당 지름길을 이용하는 것이 작다면 업데이트
 * 지름길 리스트를 end기준으로 오름차순 정렬을 하는데, i는 1부터 D까지 증가하므로 end 값이 작은 것부터 봐야 다른 지름길까지 순회 할 필요가 없기 때문
 */
public class BOJ_1446 {

    static class ShortCut {

        int start;
        int end;
        int len;

        public ShortCut(int start, int end, int len) {
            this.start = start;
            this.end = end;
            this.len = len;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int D = Integer.parseInt(s[1]);

        List<ShortCut> shortCuts= new ArrayList<>();

        for (int i = 0; i < N; i++) {
            s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            int len = Integer.parseInt(s[2]);

            shortCuts.add(new ShortCut(start, end, len));
        }

        shortCuts.sort((s1,s2) -> {
            if(s1.end == s2.end){
                return s2.len - s1.len;
            }

            return s1.end - s2.end;
        });

        int [] dp = new int[D+1];


        for(int i=1; i<=D; i++){
            dp[i] = dp[i-1] + 1;

            for(int j=0; j<N; j++){
                ShortCut shortCut = shortCuts.get(j);
                if(shortCut.end > i){
                    break;
                }

                if(shortCut.end == i){
                    if(dp[i] > dp[shortCut.start] + shortCut.len){
                        dp[i] = dp[shortCut.start] + shortCut.len;
                    }
                }
            }
        }

        System.out.println(dp[D]);

    }

}
