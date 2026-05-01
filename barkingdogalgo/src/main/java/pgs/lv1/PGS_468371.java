package pgs.lv1;

import java.util.ArrayList;
import java.util.List;

// 노란불 신호등

/**
 * 또 ai 활용
 * 1. 모듈러 연산의 직관성을 위해 1초 시작을 내부적으로 0초 시작으로 간주
 * 2. 1 번 신호등부터 n번 신호등까지 순차적으로 확인
 *  - 이전 신호등들 의 노란불 조건을 만족했던 시간 REM에서 출발
 *  - 이전까지의 통합 주기 M 만큼 점프하여 다음 통합 주기 nextM 내의 후보 시간 (x) 들을 생성
 *  - 새롭게 갱신되는 통합 주기(nextM) 는 기존 주기 M 과 현재 신호등 주기 cycle의 최소 공배수
 * 3. 노란불 판별
 *  - 후보 시간(x) 를 현재 신호등 주기(cycle) 로 나눈 나머지 (mod) 가 노란불 지속 구간(green <= mod < green + yellow) 에 속하는지 판별
 *  - 모든 순회가 끝난 후 남아있는 유효 시간 중 가장 작은 값이 최초의 정전 시간.
 */
public class PGS_468371 {

    public static void main(String[] args) {
        int [][] signals = {{3, 3, 3}, {5, 4, 2}, {2, 1, 2}};

        int result = solution(signals);
        System.out.println(result);
    }

    static public int solution(int[][] signals) {
        long M = 1;
        List<Long> validRems = new ArrayList<>();
        validRems.add(0L);

        for(int [] signal: signals){
            long green = signal[0];
            long yellow = signal[1];
            long red = signal[2];
            long cycle = green + yellow + red;

            long nextM = lcm(M, cycle);
            List<Long> nextValidRems = new ArrayList<>();

            for(long rem : validRems){
                for(long k = 0; k < nextM / M; k++){ // 정답시간 rem 이고, 공통 주기가 M이라면 rem + M, rem + 2M ... 도 조건 만족
                    long x = rem + k * M;            // 즉, M씩 k 번 점프해서 nextM 범위까지만 탐색하는 것, 그 이후부터는 주기가 반복됌
                    long mod = x % cycle;

                    if(mod >= green && mod < green + yellow){
                        nextValidRems.add(x);
                    }
                }
            }

            if(nextValidRems.isEmpty()){
                return -1;
            }

            validRems = nextValidRems;
            M = nextM;
        }

        long answerT = validRems.get(0);
        for(long rem : validRems){
            if(rem < answerT) answerT = rem;
        }

        return (int)(answerT + 1);
    }

    static private long gcd(long a, long b){
        while(b != 0){
            long temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    static private long lcm(long a, long b){
        return (a / gcd(a, b)) * b;
    }
}
