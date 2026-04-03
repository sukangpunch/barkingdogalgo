package soma.second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 로봇 청소기
// 구현

/**
 *  전에 한번 풀어본 문제인데 기억이 안남(구현 문제 특)
 *  로봇의 현재 위치와 방향을 저장할 규격인 Robot 클래스 생성
 *  1. 현재 위치가 청소 가능하다면 청소
 *  2. 로봇의 방향 기반으로 반시계 90도 회전((현재 위치 + 3 - i)%4) 현재 위치가 0이라면 3->2->1->0 순으로 탐색
 *     각 방향순회 중, 청소가 가능한 곳으로 이동 및 방향 수정
 *  3. 만약 청소가 가능한 방향이 없다면, 현재 방향 유지한 채 뒤로 한칸
 *     가야하는 방향이 벽이라면 그대로 종료
 *  check 와 isOver 상태 플래그를 관리하면서 현재 청소하려고 이동을 한 상태인지, 백스텝을 했는데 벽인지를 체크
 */
public class BOJ_14503 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        s = br.readLine().split(" ");
        int x = Integer.parseInt(s[0]);
        int y = Integer.parseInt(s[1]);
        int dir = Integer.parseInt(s[2]);

        int [][] map = new int[N][M];
        for(int i=0; i<N; i++){
            s = br.readLine().split(" ");
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        int result = solution(N,M,x,y,dir,map);

        System.out.println(result);
    }

    static class Robot{
        int x;
        int y;
        int dir;

        public Robot(int x, int y, int dir){
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }

    // 북, 동, 남, 서
    static int []dx = {-1, 0, 1, 0};
    static int []dy = {0, 1, 0, -1};

    private static int solution(int n, int m, int x, int y, int dir, int[][] map) {
        Robot robot = new Robot(x,y,dir);
        int result = 0;
        boolean isOver = false;

        while(true){
            if(isOver){
                break;
            }

            if(map[robot.x][robot.y] == 0){
                map[robot.x][robot.y] = -1;
                result++;
            }

            boolean check = false;
            for(int i=0; i<4; i++){
                int idx = (robot.dir + 3 - i) % 4;

                int nx = robot.x + dx[idx];
                int ny = robot.y + dy[idx];

                if(nx>=0 && nx<n && ny>=0 && ny<m && map[nx][ny] == 0){
                    robot.x = nx;
                    robot.y = ny;
                    robot.dir = idx;
                    check = true;
                    break;
                }
            }

            if(!check){
                int idx = (robot.dir + 2) % 4;
                int nx = robot.x + dx[idx];
                int ny = robot.y + dy[idx];

                if(nx>=0 && nx<n && ny>=0 && ny<m && map[nx][ny] != 1){
                    robot.x = nx;
                    robot.y = ny;
                }else{
                    isOver = true;
                }
            }
        }

        return result;
    }
}
