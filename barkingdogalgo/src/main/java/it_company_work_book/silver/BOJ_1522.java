package it_company_work_book.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 문자열 교환
// 브루토포스, 슬라이딩윈도우

/**
 * 슬라이딩 윈도우 문제이다.
 * 문자열에서 a의 size를 구한 다음 aSize 기반으로 배열을 탐색한다.
 * aSize 범위에 들어있는 b의 개수가 최소가 되는 부분을 result에 업데이트 한다.
 * 원형 배열이므로 현재 (위치+aSize) % 전체 문자열 길이 로 끝점을 구한다.
 */
public class BOJ_1522 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int result = 0;
        int aSize = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'a') {
                aSize++;
            }
        }

        int bCount = 0;
        for (int i = 0; i < aSize; i++) {
            if (input.charAt(i) == 'b') {
                bCount++;
            }
        }
        result = bCount;

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i - 1) == 'b') {
                bCount--;
            }

            if (input.charAt((i + aSize-1) % input.length()) == 'b') {
                bCount++;
            }

            result = Math.min(bCount, result);
        }

        System.out.println(result);
    }
}
