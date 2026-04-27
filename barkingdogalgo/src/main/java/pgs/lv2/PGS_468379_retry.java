package pgs.lv2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

// 선인장 숨기기

/**
 * 두 번째 풀이
 * 또 답을 봐버렸당.
 * 풀이 방식은 알고 있었는데 슬라이딩 덱을 활용한 슬라이딩 윈도우가 익숙하지 않아서 쉽지않음
 * 행 기준 map 을 만들어서 선인장 가로 범위(w) 에 맞게 각 좌표범위마다 최솟값을 구한다. (dq 인덱스는 무조건 오름차순 유지)
 * 그렇게 만들어진 값 기반으로 선인장 세로 범위를 동일하게 최솟값을 구한 다음, 만들어진 배열에서 최댓값이 정답
 */
public class PGS_468379_retry {
    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        int INF = Integer.MAX_VALUE;

        int [][] map = new int[m][n];

        for(int i=0; i<m; i++){
            Arrays.fill(map[i], INF);
        }

        for(int i=0; i<drops.length; i++){
            map[drops[i][0]][drops[i][1]] = i+1;
        }

        int [][]rows = new int[m][n - w + 1];

        for(int i=0; i<m; i++){
            Deque<Integer> dq = new ArrayDeque<>();
            for(int j=0; j<n; j++){
                if(!dq.isEmpty() && dq.peekFirst() <= j-w){
                    dq.pollFirst();
                }

                while(!dq.isEmpty() && map[i][dq.peekLast()] >= map[i][j]){
                    dq.pollLast();
                }

                dq.addLast(j);
                if(j >= w-1){
                    rows[i][j-w+1] = map[i][dq.peekFirst()];
                }
            }
        }

        int [][]result = new int[m-h+1][n-w+1];

        for(int j=0; j<n-w+1; j++){
            Deque<Integer> dq = new ArrayDeque<>();
            for(int i=0; i<m; i++){
                if(!dq.isEmpty() && dq.peekFirst() <= i - h){
                    dq.pollFirst();
                }
                while(!dq.isEmpty() && rows[dq.peekLast()][j] >= rows[i][j]){
                    dq.pollLast();
                }
                dq.addLast(i);
                if(i >= h-1){
                    result[i-h+1][j] = rows[dq.peekFirst()][j];
                }
            }
        }

        int maxVal = -1;
        int[] answer = new int[2];

        for(int i=0; i< m - h + 1; i++){
            for(int j=0; j<n - w + 1; j++){
                if(result[i][j] == INF){
                    return new int[]{i,j};
                }

                if(result[i][j] > maxVal){
                    maxVal = result[i][j];
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }

        return answer;

    }
}
