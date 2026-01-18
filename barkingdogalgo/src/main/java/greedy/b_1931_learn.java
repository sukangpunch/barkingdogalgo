package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 회의실 배정
public class b_1931_learn {

    static class Meeting implements Comparable<Meeting> {

        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            if (this.end == o.end) { // 1,3 - 2,3 - 3,3 이 있을 때, 1,3 혹은 2,3 을 먼저 골라야, 3,3 까지 선택이 가능해진다.
                return this.start - o.start;
            }

            return this.end - o.end;
        }
    }

    static List<Meeting> meetings;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        meetings = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            meetings.add(new Meeting(start, end));
        }

        Collections.sort(meetings);

        int cnt = 0;
        int preEnd = 0;
        for (int i = 0; i < meetings.size(); i++) {
            Meeting now = meetings.get(i);
            if (now.start < preEnd) {
                continue;
            }

            preEnd = now.end;
            cnt++;
        }

        System.out.println(cnt);

    }

}
