package soma.second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

// 단어 변환
// bfs, 구현, 문자열

/**
 * bfs + 문자열
 * 1. target이 words에 없으면 바로 0 리턴 , 있으면 transfer 시작
 * 2. begin에서 시작하는 것 보다, target에서 시작하는게 보기 편해서 탐색 target 부터 시작.
 * 3. Set 을 활용하여 방문한 문자열을 체크, 변환 depth를 구하는 문제이므로 Word 클래스를 선언하고 cnt 필드 추가, bfs 를 돌리기 위해 Queue 선언 후 target 값을 래핌한 Word 추가
 * 4. bfs를 돌면서, 방문하지 않은 문자열에 대해서 for문으로 list를 돌고, 알파벳의 차이가 1개인 문자라면 q에 추가하고, visited처리, q에 추가할 땐, 현재 cnt + 1
 * 5. 만약에 Word now 값이 begin과 동일하다면 cnt를 리턴, bfs를 다 돌았는데 begin 인 문자열까지 가지 못한다면 0 리턴
 */
public class PGS_43163 {

    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        int result = solution(begin, target, words);
        System.out.println(result);
    }

    static public int solution(String begin, String target, String[] words) {
        boolean contains = false;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(target)) {
                contains = true;
                break;
            }
        }

        if (!contains) {
            return 0;
        } else {
            return transfer(begin, target, words);
        }
    }

    static class Word {

        String word;
        int cnt;

        public Word(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }
    }

    static int transfer(String begin, String target, String[] words) {
        List<String> list = new ArrayList<>(Arrays.asList(words));
        list.add(begin);

        Set<String> visited = new HashSet<>();
        Queue<Word> q = new LinkedList<>();

        q.offer(new Word(target, 0));
        visited.add(target);
        while (!q.isEmpty()) {
            Word now = q.poll();

            if (now.word.equals(begin)) {
                return now.cnt;
            }

            for (int i = 0; i < list.size(); i++) {
                String next = list.get(i);
                if (!visited.contains(next)) {
                    int diffCount = 0;
                    for (int j = 0; j < next.length(); j++) {
                        if (next.charAt(j) != now.word.charAt(j)) {
                            diffCount++;
                            if(diffCount > 1)break;
                        }
                    }

                    if (diffCount == 1) {
                        q.offer(new Word(next, now.cnt + 1));
                        visited.add(next);
                    }
                }
            }
        }

        return 0;
    }
}
