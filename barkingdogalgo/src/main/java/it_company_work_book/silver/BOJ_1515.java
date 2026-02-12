package it_company_work_book.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 수 이어 쓰기
// 그리디, 문자열, 구현, 브루트포스
/**
 * 결국 못풀고 답지 봤다.
 * 내 고질병이, 더 효율적인 방법이 무조건 있을거라는 착각에서 길을 못찾는 듯 하다.
 * 해당 문제는 최대 3000자리 수가 0~9 까지 가능하기에 30000의 경우의수가 존재하는데 이는 컴퓨터상에서 적은 데이터
 * 그래서 바로 그냥 브루트포스 가능성을 열고, 그것부터 해봐야하는데 최대한 효율적인 알고리즘을 사용해야 한다고 착각해버렸다.
 * 본 문제에서는 자릿수를 바라보는 pt 와, 현재 숫자를 나타내는  base 를 두고
 * pt로 숫자를 하나씩 보며, base 를 증가시켜서 매핑이 되면 , 그 숫자가 최솟값 그리고 pt 증가, 매핑이 안되면 base를 증가시켜서 매핑이 될 때까지 반복
 * pt가 끝까지 숫자를 보고 나면 그 시점의 base가 최솟값 N이 된다. 
 */
public class BOJ_1515 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String nums = br.readLine();

        int pt = 0;
        int base = 0;
        while(base++ <= 30000){
            String tmp = String.valueOf(base);
            for(int i=0; i<tmp.length(); i++){
                if(tmp.charAt(i) == nums.charAt(pt)){
                    pt++;
                }
                if(pt == nums.length()){
                    System.out.println(base);
                    return;
                }
            }
        }
    }
}
