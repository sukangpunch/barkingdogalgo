package it_company_work_book.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 돌 게임
// dp, 수학
/**
 * dp 문제라고는 하는데, dp 를 쓸 필요가 없는 문제
 * 그리고 문제 해석이 너무 어려웠다...
 * 당연히 배스킨 라빈스 31 게임과 동일하다고 생각했는데.
 * 1. 마지막에 가져가는 사람이 승리
 * 2. 1, 3 개씩만 가져갈 수 있다. 즉, 내 턴에 2개가 남아있다면 2개를 못가져감
 * 승리 조건은 내 턴이 아닐 때, 4개가 남으면 승리 또한 dp[1] ~ dp[4] 까지는 번갈아가면서 승리이다.
 * 즉, dp[i] 일때, d[i-4] 의 승리자가 결국 d[i] 일때도 승리한다는 것
 * d[5-4] = dp[1] 의 승리자는 상근, dp[6-4] 승리자는 창영..
 * 결국은 N이 홀수일때는 상근 승, 짝수일때는 창영 승인것이다...
 */
public class BOJ_9655 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        if(N%2 == 1){
            System.out.println("SK");
        }else {
            System.out.println("CY");
        }
    }
}
