package it_company_work_book.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// ZOAC 4
// 알고리즘: 수학 사칙연산
/**
 *  N-Queen 문제처럼 한줄씩 visited 하고 좌표당 하나씩 체크를 해야 하나 싶었는데,
 *  체크한 좌표 기준 에서 M 행만큼 아니라, 그냥 행 단위로 떨어지면 되는거라
 *  대각선을 고려하지 않아도 되기에 인덱스 증가량으로 처리
 */
public class BOJ_23971 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] s = br.readLine().split(" ");
        int H = Integer.parseInt(s[0]);
        int W = Integer.parseInt(s[1]);
        int N = Integer.parseInt(s[2]);
        int M = Integer.parseInt(s[3]);

        int result = 0;
        for(int i=0; i<H; i += N+1){
            for(int j=0; j<W; j += M+1){
                result++;
            }
        }

        System.out.println(result);
    }
}
