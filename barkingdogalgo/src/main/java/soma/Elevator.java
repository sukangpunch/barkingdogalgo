package soma;

// 엘리베이터 문제

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * [가정 및 조건]
 * 건물: 1층부터 N층까지 존재하며, 엘리베이터는 시작 시 1층에 정지해 있습니다.
 * 이동 속도: 엘리베이터가 한 층을 이동하는 데 1초가 걸린다고 가정합니다. (문이 열리고 닫히는 시간은 0초로 간주)
 * 입력: requests 배열은 [누른 시간, 목적지 층수] 정보를 담고 있습니다.
 * 동작 규칙 (LOOK 알고리즘):
 * 상승 중(Up): 현재 층보다 높은 층의 요청이 남아있다면 계속 올라갑니다. 더 이상 높은 층의 요청이 없으면 내려갈지, 정지할지 결정합니다.
 * 하강 중(Down): 현재 층보다 낮은 층의 요청이 남아있다면 계속 내려갑니다. 더 이상 낮은 층의 요청이 없으면 올라갈지, 정지할지 결정합니다.
 * 정지(Idle): 멈춰있을 때 새로운 요청이 들어오면, 가장 먼저 들어온 요청의 방향으로 이동을 시작합니다.
 * 출력: 정확히 시간 M이 되었을 때 엘리베이터가 위치한 층수를 반환합니다.
 */
public class Elevator {

    static public int solution(int N, int[][] requests, int M){
        int currentFloor = 1;
        int direction = 0; // 정지 0, 상승 1, 하강 -1

        // 매초마다 전체 배열을 뒤지지 않도록, 특정 시간(t) 를 키로 층수 리스트를 값으로 묶어둠
        Map<Integer, List<Integer>> reqMap = new HashMap<>();
        for(int [] req: requests){
            reqMap.computeIfAbsent(req[0], k -> new ArrayList<>()).add(req[1]);
        }

        // 엘리베이터가 이동하면서 "이번 층에 서야 하는가?"를 즉각적으로(O(1) 시간) 확인하는 데 사용
        boolean[] targets = new boolean[N+1];
        // 엘리베이터가 멈춰있을 때(direction == 0), 어느 방향으로 먼저 출발해야 할지 결정하기 위해 '가장 먼저 들어온 요청'의 순서를 기억하는 대기열
        List<Integer> waitList = new ArrayList<>();

        // O초부터 M초까지 1초 단위로 시뮬레이션 진행
        for(int t=0; t<=M; t++) {

            // 1. 현재 시간에 들어온 새로운 요청 등록
            if (reqMap.containsKey(t)) {
                for (int floor : reqMap.get(t)) { // t초에 눌린 버튼이 n개 있을 수 있으므로
                    if (!targets[floor]) { // 만약 targets가 true 가 아니라면
                        targets[floor] = true; // 방문 해야한다고 표시
                        waitList.add(floor); // 멈춤 리스트에 추가
                    }
                }
            }

            // 2. 현재 층에 도착했다면 요청 완료 처리 (문 열림/닫힘 시간은 0초로 가정)
            if(targets[currentFloor]){
                targets[currentFloor] = false;
                waitList.removeAll(Collections.singleton(currentFloor));
            }

            // 목표 시간 M초가 되면 반복문을 멈추고 현재 층을 반환
            if(t == M){
                break;
            }

            // 3. 다음 방향 결정 로직(Look 알고리즘 기반)
            // 현재 위치에서 위쪽에 타겟이 존재한다면
            boolean hasUp = false;
            for(int f = currentFloor + 1; f <= N; f++){
                if(targets[f]){
                    hasUp = true;
                    break;
                }
            }

            // 현재 위치에서 아래쪽에 타겟이 존재한다면
            boolean hasDown = false;
            for(int f = currentFloor - 1; f >= 1; f--){
                if(targets[f]) {
                    hasDown = true;
                    break;
                }
            }

            // 이동 중일 때의 방향 전환 확인
            // 올라가는 중일 때, hasUp이 false 라면 hasDown 유무로 내려가거나 멈추거나
            if(direction == 1){
                if(!hasUp) direction = hasDown ? -1 : 0; 
            }else if(direction == -1){ // 내려가는 중일 때 hasDown이 false 라면 hasUp 유무로 올라가거나 멈추거나
                if(!hasDown) direction = hasUp ? 1: 0;
            }

            // 정지 상태(0) 일 때 새로운 요청이 남아있다면 방향 설정
            if(direction == 0 && !waitList.isEmpty()){
                int oldestReq = waitList.get(0);
                if(oldestReq > currentFloor) direction = 1; // waitList의 첫번째 층수가 현재보다 높다면 올라가고 낮다면 내려간다.
                else if(oldestReq < currentFloor) direction = -1;
            }

            // 4. 엘리베이터 이동
            currentFloor += direction;
        }

        return currentFloor;
    }

    public static void main(String[] args) {
        int N = 20;
        int [][] requests = {{1,10}, {2,2}, {4,15}, {6,3}, {10,18}, {15, 2}, {20, 12}};
        int M = 25;

        System.out.println(solution(N,requests, M));
    }
}
