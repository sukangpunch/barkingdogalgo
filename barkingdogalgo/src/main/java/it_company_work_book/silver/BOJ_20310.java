package it_company_work_book.silver;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 타노스
// 그리디, 문자열
/**
 * 어렵지 않은 문제, 그리디라는 것은 알고 풀었다.
 * 사전순으로 우선순위를 가지게 되려면 1은 문자열 앞에 있는 걸지우고
 * 0은 문자열 뒤에서부터 지우면 된다.
 * 각 1과 0 의 절반 개수만큼 지우고 나서 문자열을 출력하면 된다.
 * 편하게 지우기 위해 배열에다가 옮겨 담았다.
 */
public class BOJ_20310 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        List<Character> list = new ArrayList<>();
        for (int i=0; i<input.length(); i++){
            list.add(input.charAt(i));
        }

        int oneCount = 0;
        int zeroCount = 0;

        for(int i=0; i<input.length(); i++){
            if(input.charAt(i) == '1'){
                oneCount++;
            }else{
                zeroCount++;
            }
        }

        int halfOne = oneCount/2;
        int halfZero = zeroCount/2;

        int size = list.size();
        for(int i=0; i<size; i++){
            if(list.get(i).equals('1') && halfOne != 0){
                list.remove(i);
                halfOne--;
                i--;
            }

            if(halfOne == 0){
                break;
            }
        }

        size = list.size();
        for(int i=size-1; i>=0; i--){
            if(list.get(i).equals('0') && halfZero != 0){
                list.remove(i);
                halfZero--;
            }

            if(halfZero == 0){
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<list.size();i++){
            sb.append(list.get(i));
        }

        System.out.println(sb);
    }
}
