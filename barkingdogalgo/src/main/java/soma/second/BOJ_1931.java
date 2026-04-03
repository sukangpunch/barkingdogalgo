package soma.second;

// 회의실 배정
// 그리디
/**
 * 과거에 풀었던 경험 있음
 * 회의실을 끝나는 시간 기준, 같으면 시작하는 기준 (둘다 오름차순) 으로 정렬을 한다.
 * 강의 끝나는 시간을 변수에 기록하고 정렬된 회의실 스케줄 중, 현재 끝나는 시간 < 다음 시작 시간인 회의실 스케줄만 선택
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_1931 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int [][]schedule = new int[N][2];

        for(int i=0; i<N; i++){
            String []s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            schedule[i][0] = start;
            schedule[i][1] = end;
        }

        int result = solution(N, schedule);
        System.out.println(result);
    }

    static class Schedule implements Comparable<Schedule>{
        int start;
        int end;

        public Schedule(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Schedule s){
            if(this.end == s.end){
                return this.start - s.start;
            }
            return this.end - s.end;
        }
    }

    private static int solution(int n, int[][] schedule) {
        List<Schedule> schedules = new ArrayList<>();

        for(int i=0; i<n; i++){
            schedules.add(new Schedule(schedule[i][0], schedule[i][1]));
        }

        Collections.sort(schedules);

        int nowEnd = 0;
        int result = 0;
        for(int i=0; i<n; i++){
            Schedule now = schedules.get(i);
            if(nowEnd <= now.start){
                nowEnd = now.end;
                result++;
            }
        }

        return result;
    }
}
