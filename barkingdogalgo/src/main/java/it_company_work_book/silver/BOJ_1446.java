package it_company_work_book.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 지름길
// dp, 최단경로
/**
 * 지름길에 대한 클래스를 만들고, List 로 지름길들을 받고 end 값, length 값으로 오름차순 정렬을 한다.
 * 그 다음, 1 ~ D 까지 돌면서 지름길의 end 값이 현재 index 와 동일할 때, 지름길을 통한 값과, 통하지 않은 값 중 적은 값으로 업데이트 한다.
 */
public class BOJ_1446 {

    static class ShortCut{
        int start;
        int end;
        int length;

        public ShortCut(int start, int end, int length){
            this.start = start;
            this.end = end;
            this.length = length;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int D = Integer.parseInt(s[1]);
        List<ShortCut> list= new ArrayList<>();

        for(int i=0; i<N; i++){
            s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            int length = Integer.parseInt(s[2]);

            list.add(new ShortCut(start, end, length));
        }

        list.sort((s1, s2) -> {
            if(s1.end == s2.end){
                return s1.length - s2.length;
            }
            return s1.end - s2.end;
        });

        int [] dp = new int[D+1];

        for(int i = 1; i <= D; i++){
            dp[i] = dp[i-1] + 1;

            for(int j=0; j<N; j++){
                ShortCut shortCut = list.get(j);
                if(shortCut.end > i){
                    break;
                }

                if(shortCut.end == i){
                    if(dp[i] > dp[shortCut.start] + shortCut.length){
                        dp[i] = dp[shortCut.start] + shortCut.length;
                    }
                }
            }
        }

        System.out.println(dp[D]);
    }
}
