package study.week09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

//Aging
// 우선순위 큐
/**
 * ai 활용했음
 * 우선순위 큐에서는 weight = order - start 를 이용해서, 실질적인 우선순위를 나타나게 할 수 있다.
 * 현재 우선순위 큐에는 현재 시간 기반 처리할 수 있는(now >= start) 인 프로세스만 pq에 추가하게 한다.
 * 이때 weight, time 기반으로 높은 우선순위를 poll 하고 sb에 추가하는 것을 반복하면 해결.
 * 여기서 order - start가 우선순위로 사용되는 이유는 다음과 같다.
 * (start, order) 가 (0, 5) 인것과 (3, 7) 인 것을 비교한다고 가정 해 보자.
 * 5-0 > 7-3 이므로 (0,5) 가 더 높은 우선순위를 가지는데 이유는,
 * 현재 시간 기반으로 비교가 되는데, now가 최소 3이어야 한다. 3이라 가정하면 start가 0인 프로세스는 그 전까지 선택되지 못했다는 뜻이므로
 * 5+3 이 되어 우선순위가 8이 되어 있다고 판단 할 수 있는 것이다.
 */
public class BOJ_23088 {

    static class Process implements Comparable<Process> {
        int id;
        int start;
        int order;
        int time;
        int weight;

        public Process(int id, int start, int order, int time) {
            this.id = id;
            this.start = start;
            this.order = order;
            this.time = time;
            this.weight = order - start;
        }

        @Override
        public int compareTo(Process o) {
            if(this.weight != o.weight){
                return Integer.compare(o.weight, this.weight); // 내림차순
            }

            if(this.time != o.time){
                return Integer.compare(this.time, o.time);
            }

            return Integer.compare(this.id, o.id);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Process[] processes = new Process[N];

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int order = Integer.parseInt(s[1]);
            int time = Integer.parseInt(s[2]);

            processes[i] = new Process(i + 1, start, order, time);
        }

        Arrays.sort(processes, (a, b) -> {
            if(a.start != b.start) return Integer.compare(a.start, b.start);
            return Integer.compare(a.id, b.id);
        });

        PriorityQueue<Process> pq = new PriorityQueue<>();

        int now = 0;
        int idx = 0;

        // 큐가 비어있지 않거나, 아직 큐에 넣지 않은 프로세스가 남아있는 동안 반복
        while (idx < N || !pq.isEmpty()) {

            // 큐가 비어있다면, CPU가 쉬고 있는 상태이므로 다음 프로세스 도착 시간으로 점프
            if (pq.isEmpty() && now < processes[idx].start) {
                now = processes[idx].start;
            }

            // '현재 시간(now)' 이하에 도착한 모든 프로세스를 우선순위 큐에 삽입
            while (idx < N && processes[idx].start <= now) {
                pq.offer(processes[idx]);
                idx++;
            }

            // 우선순위가 가장 높은 프로세스를 꺼내서 실행
            Process current = pq.poll();
            sb.append(current.id).append(" ");

            // 1씩 더하지 않고 실행 시간만큼 한 번에 시간을 증가 (비선점형 스케줄링)
            now += current.time;
        }

        System.out.println(sb);
    }
}
