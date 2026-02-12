package it_company_work_book.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 블로그
// 누적합, 슬라이딩 윈도우
/**
 * 누가 봐도 누적합 문제
 * 누적합을 구해서 최대 방문자 수 범위를 구한 다음, max 구간이 같은 경우에 cnt를 증가시키고, 새로운 max값이 등장하면 초기화
 */
public class BOJ_21921 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String []s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int X = Integer.parseInt(s[1]);

        s = br.readLine().split(" ");
        long [] blog = new long[N+1];
        for(int i=1; i<=N;i++){
            int visitant = Integer.parseInt(s[i-1]);
            blog[i] = blog[i-1] + visitant;
        }

        long max = -1;
        int cnt = 0;
        for(int i=X; i<=N; i++){
            long size = blog[i] - blog[i-X];
            if(max < size){
                max = size;
                if(cnt == 0){
                    cnt++;
                }
                else{
                    cnt = 1;
                }
            }else if(max == size){
                cnt++;
            }
        }

        if(max == 0){
            sb.append("SAD");
        }else{
            sb.append(max).append("\n").append(cnt);
        }

        System.out.println(sb);
    }
}
