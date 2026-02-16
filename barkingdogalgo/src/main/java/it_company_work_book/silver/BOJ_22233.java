package it_company_work_book.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

// 가희와 키워드
// 자료구조, 집합
/**
 *  set 자료구조를 활용하여 빠르게 문자열을 찾고(O(1)평균 ~ O(N)최악), 빠르게 삭제하면(O(1)평균 ~ O(N)최악) 해결되는 문제
 */
public class BOJ_22233 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String []s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        Set<String> keywords = new HashSet<>();
        for(int i=0; i<N; i++){
            String keyword = br.readLine();
            keywords.add(keyword);
        }

        for(int i=0; i<M; i++){
            s = br.readLine().split(",");
            for(int j=0; j<s.length; j++){
                if(keywords.contains(s[j])){
                    keywords.remove(s[j]);
                }
            }
            sb.append(keywords.size()).append("\n");
        }

        System.out.println(sb);
    }
}
