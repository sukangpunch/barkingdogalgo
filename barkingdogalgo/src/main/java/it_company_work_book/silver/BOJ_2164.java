package it_company_work_book.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

// 카드 2
// 큐, 자료구조

/**
 * 이번 문제는 간단하게 덱으로 구현할 수 있는 문제
 */
public class BOJ_2164 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> q = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());

        for(int i=1; i<=N; i++){
            q.offer(i);
        }

        while(q.size() != 1){
            q.poll();
            int card = q.poll();
            q.addLast(card);
        }

        System.out.println(q.poll());
    }
}
