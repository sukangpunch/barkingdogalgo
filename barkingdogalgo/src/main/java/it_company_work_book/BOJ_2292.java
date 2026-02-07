package it_company_work_book;

import java.io.BufferedReader;
import java.io.InputStreamReader;


// 벌집
// 수학
/**
 * 규칙을 찾는 문제
 * depth가 존재하고, 각 뎁스가 변경되기 전의 idx는 1 - 7 - 19 와 같았다.
 * 육각형이다 보니 6을 기준으로 생각하니 1 + 6*1 = 7, 7 + 6*2 = 19 와 같은 규칙을 찾아서
 * 입력한 N이 now + 6*idx 보다 크다면, idx를 1씩 늘려가며 사이즈가 같거나, 작을 경우를 찾으면 된다.
 */
public class BOJ_2292 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int idx = 1;
        int size = 1;
        while(true){
            if(N > size){
                size += 6*idx;
                idx++;
            }else{
                break;
            }
        }
        System.out.println(idx);
    }
}
