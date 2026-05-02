package pgs.lv1;

import java.util.HashSet;
import java.util.Set;

// 중요한 단어를 스포 방지

/**
 * 스포일러 처리된 문자열리스트, 스포일러 처리 안된 문자열 리스트 를 따로 관리한 다음, 스포일러 처리 된 문자열이 스포일러 처리되지 않은 문자열 리스트에 있다면 중요하지 않은 문자
 * 스포일러에 해당하는 단어는, 단어의 start 보다 스포일러의 end가 더 작은경우, 단어의 end 보다 스포일러의 start가 더 큰 경우
 */
public class PGS_468370 {

    class Solution {
        public int solution(String message, int[][] spoiler_ranges) {
            Set<String> spoilerWords = new HashSet<>();
            Set<String> nonSpoilerWords = new HashSet<>();

            int wordStartIdx = 0;

            for (int i = 0; i <= message.length(); i++) {
                // 공백을 만나거나 문자열 끝에 도달했을 때
                if (i == message.length() || message.charAt(i) == ' ') {

                    // 단어의 길이가 1 이상일 때만 처리 (빈 문자열 및 후행 공백 런타임 에러 방지)
                    if (wordStartIdx < i) {
                        // strs 배열을 참조하는 대신 substring으로 직접 단어를 추출
                        String currentWord = message.substring(wordStartIdx, i);
                        int wordEndIdx = i - 1;

                        boolean isSpoiler = false;

                        for (int[] range : spoiler_ranges) {
                            int rStart = range[0];
                            int rEnd = range[1];

                            if (!(wordEndIdx < rStart || wordStartIdx > rEnd)) {
                                isSpoiler = true;
                                break;
                            }
                        }

                        if (isSpoiler) {
                            spoilerWords.add(currentWord);
                        } else {
                            nonSpoilerWords.add(currentWord);
                        }
                    }

                    wordStartIdx = i + 1;
                }
            }

            int result = 0;
            for (String word : spoilerWords) {
                if (!nonSpoilerWords.contains(word)) {
                    result++;
                }
            }

            return result;
        }
    }
}
