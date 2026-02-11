package it_company_work_book.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// 영단어 암기는 괴로워
// 자료구조, 문자열, 정렬, 집합과 맵
/**
 * 쉽네 하고 풀었다가, 정렬 조건 잘못 지정해서 오류 발생
 * 우선순위 큐 + Comparator 람다 식을 활용
 * 1. count 수가 큰 대로 내림차순으로 우선적으로 정렬을 처리 해야하는데
 * (w1.count > w2.count) return w2.count - w1.count 라는 정렬 조건을 걸었다.
 * 즉, w1이 w2보다 작은 경우에서는  아에 count 조건을 정렬을 하지 않으므로, 오류
 * w1과 w2의 count가 다를 때! Integer.compare(w2, w1) 를 활용하여 두 경우의 수를 다 고려한 내림차순으로 정렬하도록 해야한다.
 * 문자 길이 정렬도 마찬가지, 또한 사전순 우선순위는 연산상 오름차순이므로 w1.compareTo(w2) 로 구현한다.
 */
public class BOJ_20920 {
    static class Word{
        String word;
        int count;

        public Word(String word, int count){
            this.word = word;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String []s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<N; i++){
            String input = br.readLine();
            map.put(input, map.getOrDefault(input, 0) + 1);
        }

        PriorityQueue<Word> pq = new PriorityQueue<>((w1, w2) -> {
            if(w1.count != w2.count){ // (w1과 w2의 count 값이 다를 때 내림차순)
                return Integer.compare(w2.count, w1.count);
            }

            if(w1.word.length() != w2.word.length()){ //count가 같고, w1과 w2의 , word.length 기반 내림차순
                return Integer.compare(w2.word.length(), w1.word.length());
            }

            return w1.word.compareTo(w2.word); // 사전순으로 높은 우선순위가 더 작은 값이므로, compare(w1, w2) 시, 오름차순으로 이루어진다.
        });

        for(String str: map.keySet()){
            if(str.length() >= M){
                pq.offer(new Word(str, map.get(str)));
            }
        }

        while(!pq.isEmpty()){
            sb.append(pq.poll().word).append("\n");
        }

        System.out.println(sb);
    }
}
