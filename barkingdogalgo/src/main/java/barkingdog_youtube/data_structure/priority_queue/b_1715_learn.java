package barkingdog_youtube.data_structure.priority_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 카드 정렬하기
public class b_1715_learn {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            pq.offer(num);
        }

        int result = 0;
        while(pq.size() > 1){ // 가장 작은 값들의 묶음으로 계속 더해나가면 된다. (허프만 코딩)
            int one = pq.poll();
            int two = pq.poll();

            int sum = one+two;
            result += sum;
            pq.offer(sum);
        }

        System.out.println(result);
    }
}
