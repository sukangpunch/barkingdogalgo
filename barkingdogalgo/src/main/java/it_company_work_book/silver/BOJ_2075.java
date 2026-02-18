package it_company_work_book.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// N번째 큰 수
// 우선순위 큐, 자료구조
/**
 * 최대 힙을 활용하여, 값들을 다 집어넣고, N-1 번째 수를 뺀다음 N번쨰를 출력
 */
public class BOJ_2075 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> i2 - i1);

        for(int i=0; i<N; i++){
            String []s = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                pq.offer(Integer.parseInt(s[j]));
            }
        }

        for(int i=0; i<N-1; i++){
            pq.poll();
        }

        int result = pq.poll();
        System.out.println(result);
    }
}
