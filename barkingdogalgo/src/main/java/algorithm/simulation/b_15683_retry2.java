package algorithm.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 감시
public class b_15683_retry2 {

    static class CCTV{
        int y;
        int x;
        int type;

        public CCTV(int y, int x, int type){
            this.y = y;
            this.x = x;
            this.type = type;
        }
    }

    static int [][] direction = {
            {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };
    static int N;
    static int M;
    static List<CCTV> cctvs;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        int [][] office = new int[N][M];
        cctvs = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            s = br.readLine().split(" ");
            for(int j = 0; j < M; j++) {
                int num = Integer.parseInt(s[j]);
                if(num > 0 && num < 6){
                    cctvs.add(new CCTV(i, j, num));
                }
                office[i][j] = Integer.parseInt(s[j]);
            }
        }

        result = Integer.MAX_VALUE;
        findBlindSpot(0, office);

        System.out.println(result);
    }

    private static void findBlindSpot(int depth, int [][] office) {
        if(depth == cctvs.size()) {
            result = Math.min(result, countOfficeBlindSpot(office));
            return;
        }

        CCTV cctv = cctvs.get(depth);
        int rotationCount = findRotationCount(cctv);

        for(int rotation = 0; rotation < rotationCount; rotation++) {
            int [][] snapshotOffice = copyOfficesStatus(office);
            checkCctvWatchRangeByRotation(rotation, cctv, snapshotOffice);
            findBlindSpot(depth + 1, snapshotOffice);
        }
    }

    private static int countOfficeBlindSpot(int [][] office) {
        int count = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(office[i][j] == 0){
                    count++;
                }
            }
        }
        return count;
    }

    private static void checkVisibilityOfCctvInTheOffice(int rotation, CCTV cctv, int[][] snapshotOffice){
        int y = direction[rotation][0];
        int x = direction[rotation][1];

        int cctvY = cctv.y;
        int cctvX = cctv.x;

        while(true){
            cctvY += y;
            cctvX += x;
            if(cctvY >= N || cctvX >= M || cctvY < 0 || cctvX < 0 || snapshotOffice[cctvY][cctvX] == 6){
                return;
            }

            if(snapshotOffice[cctvY][cctvX] == 0){
                snapshotOffice[cctvY][cctvX] = -1;
            }
        }
    }

    private static void checkCctvWatchRangeByRotation(int rotation, CCTV cctv, int[][] snapshotOffice) {
        int cctvType = cctv.type;

        if(cctvType == 1) {
            checkVisibilityOfCctvInTheOffice(rotation, cctv, snapshotOffice);
            return;
        }

        if(cctvType == 2) {
            checkVisibilityOfCctvInTheOffice(rotation, cctv, snapshotOffice);
            checkVisibilityOfCctvInTheOffice(rotation+2, cctv, snapshotOffice);
            return;
        }

        if(cctvType == 3){
            checkVisibilityOfCctvInTheOffice(rotation, cctv, snapshotOffice);
            checkVisibilityOfCctvInTheOffice((rotation+1)%4, cctv, snapshotOffice);
            return;
        }

        if(cctvType == 4){
            checkVisibilityOfCctvInTheOffice(rotation, cctv, snapshotOffice);
            checkVisibilityOfCctvInTheOffice((rotation+1)%4, cctv, snapshotOffice);
            checkVisibilityOfCctvInTheOffice((rotation+2)%4, cctv, snapshotOffice);
            return;
        }

        if(cctvType == 5){
            checkVisibilityOfCctvInTheOffice(0, cctv, snapshotOffice);
            checkVisibilityOfCctvInTheOffice(1, cctv, snapshotOffice);
            checkVisibilityOfCctvInTheOffice(2, cctv, snapshotOffice);
            checkVisibilityOfCctvInTheOffice(3, cctv, snapshotOffice);
        }
    }

    private static int[][] copyOfficesStatus(int [][] office) {
        int [][] newOffice = new int[N][M];
        for(int i=0; i< N; i++){
            for(int j=0; j<M; j++){
                newOffice[i][j] = office[i][j];
            }
        }
        return newOffice;
    }

    private static int findRotationCount(CCTV cctv) {
        if(cctv.type == 2) return 2;
        if(cctv.type == 5) return 1;
        return 4;
    }
}

/*
    동작 방식
    1. office를 입력 받고, cctv의 좌표 및 type을 클래스로 묶어 리스트로 저장
    1.2 최솟값을 담을 result 변수화, 좌표를 탐색하기 위한 direction 배열 선언(cctv 방향 고려하여 셋팅)
    2. [백트래킹 시작] depth, office 배열을 기반으로 재귀
    3. cctv 별로 rotation 횟수를 구함(하나의 depth 에서 탐색할 횟수를 구하는것)
    4. 0부터 rotation 횟수만큼 반복, 이 때, 현재 상황의 office 배열을 복사해놈
       - 복사를 해놓는 이유는, 각 회전 경우마다 독립적인 상태가 필요하기 때문이다.
       - 예, rotation = 0 이고, type 1 일 때, 오른쪽 탐색의 경우,
       -     rotation = 1 이고 ,type 1 일 때, 왼쪽 탐색의 경우를 다르게 가져가기 위해서이다.
    5.그 다음 rotation 과 cctv type 에 맞게 office 배열 탐색을 시도한다.
    5.2 cctv 별로 탐색해야 하는 방향이 존재하므로 그에 맞게 탐색
        - 예: 만약 type 2 라면? x축+1 방향으로 탐색을 하면, 다음엔 x축-1 방향을 탐색해야 정상적인 동작
        - 여기서 고려해야 할 점은, rotation 0일때 x축을 관장 했다면, rotation 1일때는 y축을 관장해야한다.
    6. 이를 재귀로 반복하여, 각 상황별로 값을 result 와 비교하여 최솟값을 업데이트 한다.
 */
