package it_company_work_book.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

// 임스와 함께하는 미니게임
// 자료구조, 문자열, 집합과 맵

/**
 * 이것도 쉬운 구현문제
 * 이미 플레이했던 유저를 관리하는 set과, 현제 게임 플레이를 위해 쌓인 set을 둘다 관리하면서 count를 증가시킴
 */
public class BOJ_25757 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String []s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        String game = s[1];
        int size = 0;

        if(game.equals("Y")){
            size = 2;
        }else if(game.equals("F")){
            size = 3;
        }else{
            size = 4;
        }

        Set<String> set = new HashSet<>();
        Set<String> now = new HashSet<>();
        int count = 0;

        for(int i=0; i<N; i++){
            String input = br.readLine();
            if(set.contains(input)){
                continue;
            }
            set.add(input);
            now.add(input);

            if(size-1 == now.size()){
                count++;
                now = new HashSet<>();
            }
        }
        System.out.println(count);
    }
}
