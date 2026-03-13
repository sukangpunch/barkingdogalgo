package study.week09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// Aging
public class BOJ_23088_time_over {

    static class Process {

        int start;
        int order;
        int time;

        public Process(int start, int order, int time) {
            this.start = start;
            this.order = order;
            this.time = time;
        }
    }

    static List<Process> processes;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        processes = new ArrayList<>();
        visited = new boolean[N + 1];

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int order = Integer.parseInt(s[1]);
            int time = Integer.parseInt(s[2]);

            processes.add(new Process(start, order, time));
        }

        int now = 0;
        int count = 0;
        while (true) {
            int targetId = -1;
            int targetOrder = -1;
            int targetTime = 0;
            for (int i = 0; i < N; i++) {
                if (now >= processes.get(i).start && processes.get(i).time > 0) {
                    if (targetOrder < processes.get(i).order) {
                        targetOrder = processes.get(i).order;
                        targetId = i;
                        targetTime = processes.get(i).time;
                    } else if (targetOrder == processes.get(i).order && targetTime > processes.get(i).time) {
                        targetOrder = processes.get(i).order;
                        targetId = i;
                        targetTime = processes.get(i).time;
                    }
                }
            }

            if (!visited[targetId+1]) {
                count++;
                visited[targetId+1] = true;
                sb.append(targetId+1).append(" ");
            }

            if (count == N) {
                break;
            }

            for (int i = 0; i < N; i++) {
                if (processes.get(i).time > 0) {
                    if (i != targetId && now >= processes.get(i).start) {
                        processes.get(i).order += 1;
                    } else if (i == targetId) {
                        processes.get(i).time -= 1;
                    }
                }
            }

            now++;
        }

        System.out.println(sb);
    }
}
