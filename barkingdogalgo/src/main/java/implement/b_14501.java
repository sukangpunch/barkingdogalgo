package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 답 보기 : x(질문게시판 확인)
// 메모리 :  kb
// 시간 :  ms
public class b_14501 {

    static class Counsel{
        int time;
        int money;

        public Counsel(int time, int money) {
            this.time = time;
            this.money = money;
        }
    }
    static List<Counsel> counsels;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int []dp = new int[N+1];
        counsels = new ArrayList<>();

        counsels.add(new Counsel(0,0));
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int money = Integer.parseInt(st.nextToken());
            counsels.add(new Counsel(time, money));
        }

        for(int i=N; i>=1; i--){
            Counsel c = counsels.get(i);
            if(i+c.time > N + 1)continue;

            dp[i] = c.money;

            int newI = i + c.time;
            int dpCount;

            if(newI <= N){
                dpCount = dp[i] + dp[newI];
                dp[i] = Math.max(dp[i+1], dpCount);
            }
        }

        int max = 0;
        for(int i=1; i<=N; i++){
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
