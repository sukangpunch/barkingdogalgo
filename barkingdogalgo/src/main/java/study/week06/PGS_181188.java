package study.week06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 요격 시스템
// 그리디, 구간 스케쥴링
// 시간복잡도 : O(NlogN)
/**
 * 답지 봄
 * 그리디 라는건 알았으나, 정렬 기준과 로직을 떠올리지 못했다. 
 * 가장 일찍 끝나는 지점에 요격하면 그 지점을 지나는 다른 구간들도 동시에 커버 가능하다.
 * end가 늦은 구간으로 요격하면, 일찍 끝나는 구간들은 이미 통과해버려 별도 요격이 필요해지기 때문.
 * end 를 기준으로 정렬하고 pre 값보다 start 값이 크다면 answer 증가, pre = now.end 로 업데이트
 * start >= pre 일 때, 새로 요격하는 이유는, 개구간 이기 때문에 end == start 라면 요격이 불가능해진다.
 * 즉, end 기준 정렬은 가장 빨리 사라질 구간부터 처리 하는 전략
 */
public class PGS_181188 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int [][]target = new int[][]{
                {4,5},
                {4,8},
                {10,14},
                {11,13},
                {5,12},
                {3,7},
                {1,4}
        };

        int result = solution(target);
        System.out.println(result);
    }

    static class Missile implements Comparable<Missile>{
        int start;
        int end;

        public Missile(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Missile o) {
            return this.end - o.end;
        }
    }

    static int solution(int[][] targets) {
        int answer = 0;
        List<Missile> missiles = new ArrayList<>();
        for(int i=0; i<targets.length;i++){
            missiles.add(new Missile(targets[i][0], targets[i][1]));
        }

        missiles.sort(Missile::compareTo);
        int pre = 0;
        for(int i=0; i<missiles.size(); i++){
            if(pre <= missiles.get(i).start){
                pre = missiles.get(i).end;
                answer++;
            }
        }

        return answer;
    }
}
