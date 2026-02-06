package study.week05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 컵라면
public class BOJ_1781 {

    static class Problem implements Comparable<Problem> {

        int deadLine;
        int cup;

        public Problem(int deadLine, int cup) {
            this.deadLine = deadLine;
            this.cup = cup;
        }

        @Override
        public int compareTo(Problem o) {
            if (this.deadLine == o.deadLine) {
                return o.cup - this.cup;
            }
            return this.deadLine - o.deadLine;
        }
    }

    static PriorityQueue<Problem> pq;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            int deadLine = Integer.parseInt(s[0]);
            int cup = Integer.parseInt(s[1]);
            pq.add(new Problem(deadLine, cup));
        }

        PriorityQueue<Integer> select = new PriorityQueue<>();

        while(!pq.isEmpty()){
            Problem problem = pq.poll();
            int deadLine = problem.deadLine;
            int cup = problem.cup;

            if(select.size() < deadLine){
                select.offer(cup);
            }else{
                if(!select.isEmpty() && select.peek() < cup){ // 만약 선택한 문제 중 가장 적은 컵라면보다 현재 추가하려는 problem 의 컵라면 개수가 더 많다면
                    select.poll();
                    select.offer(cup);
                }
            }
        }

        long result = 0;
        for(int cup : select){
            result += cup;
        }

        System.out.println(result);
    }
}
