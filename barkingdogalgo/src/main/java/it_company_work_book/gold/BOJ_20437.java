package it_company_work_book.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 문자열 게임 2
// 슬라이딩 윈도우
/**
 * 시간복잡도 : O(N)
 * 특정 알파벳이 등장하는 '인덱스 위치들이 모인 리스트' 위에서 크기가 K로 고정된 윈도우를 한 칸씩 옆으로 밀면서 탐색한다.
 * 알파벳 범위인 0~26까지의 배열에 각 리스트를 두어서, 문자열에 해당 알파벳이 등장 할 때, 알파벳과 맞는 인덱스의 리스트에 문자열에서 위치값을 저장합니다.
 * 즉, a가 k개 있는 문자열의 길이를 확인하고 싶으면, charIdx[0]의 리스트에 존재하는 idx 중에, k개 만큼 선택하여 비교하면 된다.
 * 모든 알파벳에 대하여 이를 확인하며 최대값, 최소값을 갱신하면 된다.
 * 키 포인트는 일일히 범위를 탐색하지 않고, 미리 모든 문자의 위치 값을 저장해 놓는것이다.
 */
public class BOJ_20437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String w = br.readLine();
            int K = Integer.parseInt(br.readLine());

            if(K == 1){
                sb.append(1).append(" ").append(1).append("\n");
                continue;
            }

            List<Integer>[] charIdx = new ArrayList[26];
            for(int i=0; i<26; i++){
                charIdx[i] = new ArrayList<>();
            }

            // 1. 문자열을 한 번만 순회하면서 각 문자의 인덱스를 저장합니다.
            for (int i = 0; i < w.length(); i++) {
                int idx = w.charAt(i) - 'a';
                charIdx[idx].add(i);
            }

            int minLen = Integer.MAX_VALUE;
            int maxLen = -1;

            for(int i=0; i<26; i++){
                List<Integer> index = charIdx[i];

                if(index.size() >= K){
                    for(int j=0; j<=index.size() -K; j++){
                        int startIdx = index.get(j);
                        int endIdx = index.get(j+K -1);
                        int length = endIdx - startIdx +1;

                        minLen = Math.min(minLen, length);
                        maxLen = Math.max(maxLen, length);
                    }
                }
            }

            if (minLen == Integer.MAX_VALUE) {
                sb.append("-1\n");
            } else {
                sb.append(minLen).append(" ").append(maxLen).append("\n");
            }
        }
        System.out.println(sb);
    }

}
