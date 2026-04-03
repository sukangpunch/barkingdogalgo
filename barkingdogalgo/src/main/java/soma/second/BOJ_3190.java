package soma.second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

// 뱀
// 구현

/**
 * ai 활용함
 * 문제의 키 포인트는, 1. 뱀의 이동 2. 사과 위치및 이동처리, 3. rotation 방식
 * 1. 뱀의 이동을 위해, Deque<int[]> 를 활용해서, 머리(peekFirst), 꼬리(pollLast) 로 확인 및 방향 별 이동처리(dir 기반)
 * 2. 사과의 위치를 저장한 배열을 활용, 만약 뱀의 이동에 사과가 존재한다면 꼬리를 남기고(head위치에 꼬리 유지), 사과가 없다면,덱의 pollLast 부분의 꼬리를 제거
 * 3. rotationIdx를 관리하여, 순서대로(시간별 정렬되어있음) 이동 이후 time이 맞다면 L, D 구분하여 회전
 * 3_1. 현재 dx,dy 기반으로 왼쪽(반시계방향) 은 (dir+1)%4, 오른쪽(시계방향) 은 (dir+3)%4 가 된다.
 */
public class BOJ_3190 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int [][] apple = new int[N+1][N+1];

        for(int i=0; i<K; i++){
            String []s = br.readLine().split(" ");
            int r = Integer.parseInt(s[0]);
            int c = Integer.parseInt(s[1]);
            apple[r][c] = 1;
        }

        int L = Integer.parseInt(br.readLine());

        int [] times = new int[L];
        char [] rotate = new char[L];

        for(int i=0; i<L; i++){
            String [] s = br.readLine().split(" ");
            int X = Integer.parseInt(s[0]);
            char C = s[1].charAt(0);
            times[i] = X;
            rotate[i] = C;
        }

        int result = solution(N,K,apple,L,times,rotate);
        System.out.println(result);
    }

    // 오, 위, 왼, 아
    static int []dx = {0, -1, 0, 1};
    static int []dy = {1, 0, -1, 0};

    private static int solution(int n, int k, int[][] apple, int l, int[] times, char[] rotates) {
        Deque<int[]> snake = new ArrayDeque<>();
        snake.addFirst(new int[]{1,1});

        int [][] map = new int[n+1][n+1];
        map[1][1] = 1;

        int curDir = 0;
        int time = 0;
        int rotationIdx = 0;

        while(true){
            time++;

            // 1. 머리를 다음 칸으로 이동
            int[] head = snake.peekFirst();
            int nx = head[0] + dx[curDir];
            int ny = head[1] + dy[curDir];

            // 2. 벽에 부딪히거나 자신의 몸에 부딪히는지 체크
            if (nx < 1 || ny < 1 || nx > n || ny > n || map[nx][ny] == 1) {
                return time;
            }

            // 3. 이동할 칸에 사과가 있는지 확인
            if(apple[nx][ny] == 1){
                apple[nx][ny] = 0; // 꼬리는 그대로 두기
            }else{
                int[] tail = snake.pollLast();
                map[tail[0]][tail[1]] = 0; // 사과가 없으면 꼬리 자름
            }

            // 머리 추가
            snake.addFirst(new int[]{nx, ny});
            map[nx][ny] = 1;

            // 4. 회전 시간인지 확인
            if(rotationIdx < l && times[rotationIdx] == time){
                if(rotates[rotationIdx] == 'L'){
                    curDir = (curDir + 1) % 4;
                }else{
                    curDir = (curDir + 3) % 4;
                }
                rotationIdx++;
            }
        }
    }
}
