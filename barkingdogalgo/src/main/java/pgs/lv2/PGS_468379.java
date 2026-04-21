package pgs.lv2;

import java.util.ArrayDeque;
import java.util.Deque;

// 선인장 숨기기

/**
 * 처음에 완탐으로 풀었다가 어마어마한 시간초과로 바로 제미나이 호출
 * 2차원 슬라이딩 윈도우 느낌인데 가로 버전을 구한 뒤 해당 값 기반 세로버전을 구해서 만든 테이블 기반으로 답을 찾는다.
 * 1. deque 에는 인덱스를 저장. 해당 데이터가 윈도우 범위를 벗어났는지 체크.
 * 2. 새로 윈도우에 들어온 값이 기존 덱의 뒤쪽에 있는 값보다 작거나 같다면 그 기존 값들은 절대 최솟값이 될 수 없으므로 버린다.\
 * 3. 새 인덱스를 덱 뒤에 추가, 윈도우가 채워 졌을 때, 덱의 가장 앞부분의 인덱스 값을 꺼내 쓰면 그게 바로 윈도우의 최솟값
 * 위 연산으로 가로 세로 최대치 구하고 inf인 부분이 무조건 우선, 그 당므은 최대 값 idx를 리턴하면 된다.
 */
public class PGS_468379 {

    public static void main(String[] args) {
        int m = 4;
        int n = 5;
        int h = 2;
        int w = 2;
        int [][] drops = {{0, 0}, {3, 1}, {1, 3}, {2, 4}, {1, 1}, {2, 2}, {2, 3}, {0, 4}};

        int []answer = solution(m, n, h, w, drops);

        System.out.println(answer[0] + " " + answer[1]);
    }

    static public int[] solution(int m, int n, int h, int w, int[][] drops) {
        int INF = 1_000_001;
        int[][] map = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = INF;
            }
        }

        for (int i = 0; i < drops.length; i++) {
            map[drops[i][0]][drops[i][1]] = i + 1;
        }

        // 1. 가로 방향(Row-wise) 최솟값 산출
        int[][] rowMin = new int[m][n - w + 1];
        for (int i = 0; i < m; i++) {
            Deque<Integer> deque = new ArrayDeque<>();
            for (int j = 0; j < n; j++) {
                if (!deque.isEmpty() && deque.peekFirst() <= j - w) {
                    deque.pollFirst();
                }
                while (!deque.isEmpty() && map[i][deque.peekLast()] >= map[i][j]) {
                    deque.pollLast();
                }
                deque.addLast(j);
                if (j >= w - 1) {
                    rowMin[i][j - w + 1] = map[i][deque.peekFirst()];
                }
            }
        }

        // 2. 세로 방향(Column-wise) 최솟값 산출 -> 2차원 배열(regionMin)에 저장
        int[][] regionMin = new int[m - h + 1][n - w + 1];
        for (int j = 0; j < n - w + 1; j++) {
            Deque<Integer> deque = new ArrayDeque<>();
            for (int i = 0; i < m; i++) {
                if (!deque.isEmpty() && deque.peekFirst() <= i - h) {
                    deque.pollFirst();
                }
                while (!deque.isEmpty() && rowMin[deque.peekLast()][j] >= rowMin[i][j]) {
                    deque.pollLast();
                }
                deque.addLast(i);
                if (i >= h - 1) {
                    regionMin[i - h + 1][j] = rowMin[deque.peekFirst()][j];
                }
            }
        }

        // 3. 최적 좌표 탐색 (행 -> 열 순서로 좌측 상단 완벽 보장)
        int maxVal = -1;
        int[] answer = new int[2];

        for (int i = 0; i < m - h + 1; i++) {
            for (int j = 0; j < n - w + 1; j++) {
                // 비가 오지 않은 곳(INF)을 발견하면 행/열 우선순위에 따라 최초 발견 위치가 정답
                if (regionMin[i][j] == INF) {
                    return new int[]{i, j};
                }

                // > 연산자를 사용하므로, 동일한 maxVal이 나와도 최초 저장된(좌측 상단) 좌표가 유지됨
                if (regionMin[i][j] > maxVal) {
                    maxVal = regionMin[i][j];
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }

        return answer;
    }
}
