package it_company_work_book.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 볼 모으기
// 그리디
/**
 * 답지를 확인하였다.
 * 빨강을 왼쪽으로 옮기는 경우, ~ 파랑을 오른쪽으로 옮기는 경우 모든 경우에 대해서 값을 구한다.
 * 연산을 줄이기 위해, 전체 빨강 수, 전체 파랑 수를 구한 다음, 왼쪽, 오른쪽 끝점에 한에서 연속으로 존재하는 개수를 구하고 빼서 옮김 횟수를 구한다.
 * 예를 들면, RRRRBBBB 가 있을 때, 빨강을 왼쪽으로 옮기는건, 4(전체 빨강 수) - 4(왼쪽부터 연속 빨강 수) 이므로 0이된다.
 */
public class BOJ_17615 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();

        int result = 500001;
        int firstBallCount = 0;
        int redCount = 0;
        int blueCount = 0;

        for (int i = 0; i < N; i++) {
            if (input.charAt(i) == 'R') {
                redCount++;
            } else {
                blueCount++;
            }
        }

        // Red가 왼쪽에 오는 경우
        for (int i = 0; i < N; i++) {
            if (input.charAt(i) == 'R') {
                firstBallCount++;
            } else {
                break;
            }
        }

        result = Math.min(result, redCount - firstBallCount);

        // Red 가 오른쪽에 오는 경우
        firstBallCount = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (input.charAt(i) == 'R') {
                firstBallCount++;
            } else {
                break;
            }
        }

        result = Math.min(result, redCount - firstBallCount);

        // Blue 가 왼쪽에 오는 경우
        firstBallCount = 0;
        for (int i = 0; i < N; i++) {
            if (input.charAt(i) == 'B') {
                firstBallCount++;
            } else {
                break;
            }
        }

        result = Math.min(result, blueCount - firstBallCount);

        // Blue 가 오른쪽에 오는 경우
        firstBallCount = 0;
        for (int i = N-1; i >= 0; i--) {
            if (input.charAt(i) == 'B') {
                firstBallCount++;
            } else {
                break;
            }
        }

        result = Math.min(result, blueCount - firstBallCount);

        System.out.println(result);
    }
}
