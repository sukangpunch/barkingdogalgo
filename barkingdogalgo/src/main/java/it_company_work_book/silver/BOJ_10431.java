package it_company_work_book.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 줄세우기
// 구현, 정렬, 시뮬레이션
/**
 *  삽입 정렬과 매우 유사
 *  현재 위치의 값이 이전 위치의 값중 더 큰 것이 있다면 이전 위치로 값을 옮기고 한칸씩 뒤로 미는것
 *  input 값이 좀 더러워서 복잡해 보이지만 삽입 정렬과 매우 유사
 */
public class BOJ_10431 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int P = Integer.parseInt(br.readLine());

        for(int t=1; t<=P; t++){
            int [] arr = new int[20];
            String [] s = br.readLine().split(" ");
            for(int i=1; i<21; i++){
                arr[i-1] = Integer.parseInt(s[i]);
            }

            int cnt = 0;
            for(int i=1; i<20; i++){
                int tmp = arr[i];
                for(int j=0; j<i; j++){
                    if(arr[j] > tmp){
                        int now = i;
                        while(now>j){
                            arr[now] = arr[now-1];
                            now--;
                            cnt++;
                        }
                        arr[j] = tmp;
                        break;
                    }
                }
            }

            sb.append(t).append(" ").append(cnt).append("\n");
        }

        System.out.println(sb);
    }
}
