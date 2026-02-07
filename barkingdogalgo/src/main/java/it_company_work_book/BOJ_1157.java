package it_company_work_book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

// 단어 공부
// 구현, 문자열
/**
 * 문제의 핵심은 toUpperCase, toLowerCase
 * 대문자 소문자를 구분하는지 문제를 잘 읽어야함.
 * Map에서 새로 들어온 key에 대해선, defaultValue로 0을, 이미 존재한다면 존재하는 key의 Value를 가져오는  getOrDefault 활용
 * 오직 하나의 max cnt의 문자가 존재하는 것이 아니라면 ? 를 리턴해야 하므로 onlyOne 플래그로 관리
 * 마지막의 onlyOne 상태가 중요(비교 중에 max==cnt인 경우가 존재하지만, 마지막에 max값이 업데이트 될 수도 있기 때문)
 */
public class BOJ_1157 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine().toLowerCase();
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        int max = 0;
        char alphabet = ' ';
        boolean onlyOne = true;
        for(Entry<Character, Integer> entry: map.entrySet()){
            int cnt = entry.getValue();
            char c = entry.getKey();
            if(max < entry.getValue()){
                max = cnt;
                alphabet = c;
                onlyOne = true;
            }else if(max == cnt){
                onlyOne = false;
            }
        }

        if(onlyOne){
            System.out.println(String.valueOf(alphabet).toUpperCase());
        }else{
            System.out.println('?');
        }
    }
}
