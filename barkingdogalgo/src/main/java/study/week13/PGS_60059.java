package study.week13;

// 자물쇠와 열쇠
// 구현, 브루트포스

/**
 * 자물쇠 배열과, 키 배열을 매핑하여 겹치는 부분 없이 자물쇠 배열을 전부 채우면 true, 아니면 false 인 문제
 * 1. key 를 회전시켜서 (0,90, 180, 270) 자물쇠와 대조 할 수 있다.
 * 2. key 를 이동시켜서 키의 부분을 자물쇠와 매핑 가능하다(자물쇠를 넘어가는 부분은 상관 없음)
 * 풀이의 키 포인트는, 모든 경우의 수를 대조 해 보기 위해 배열 확장과, rotate이다.
 * 배열 확장: key의 일부분만 자물쇠에 대조 해 볼 수 있기 때문에, 키가 위치할 수 있는 모든 가능성을 열어둔 N(자물쇠) + (2*(N-1))(키) 사이즈의 배열을 선언한 후 가운데에 자물쇠를 둔다
 * rotate : 열과 행을 반전(회전, 열과 행의 길이가 다를 수 있음), rotate[i][j] = arr[n-1-j][i] 로직으로 시계방향 90도 회전, n은 y값 size
 * 또한, 자물쇠의 좌측 상단 idx를 기반으로 확장 자물쇠 배열의 모든 상황을 테스트 해 봐야 한다. 
 * i < length(확장 자물쇠 배열size) - M(key size), j<length(확장 자물쇠 배열 size) - M(key size)
 * (i, j)에서 key의 배열을 자물쇠 배열에 값을 더한 후, check, check 결과가 true 면 즉시종료
 * check는 자물쇠 범위에서 하나라도 1이 아니면 false, 1이상이 될 수도 있다(자물쇠와 key가 겹치는 부분이 존재해도 false)
 */
public class PGS_60059 {

    class Solution {

        int N;
        int M;
        int length;

        public boolean solution(int[][] key, int[][] lock) {
            N = lock.length;
            M = key.length;

            // 자물쇠를 정중앙에 두고 열쇠가 걸칠 수 있도록 확장 배열 생성
            length = N + (M - 1) * 2;
            int[][] arr = new int[length][length];

            // 1. 확장 배열의 중앙에 자물쇠 값 복사
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i + M - 1][j + M - 1] = lock[i][j];
                }
            }

            // 2. 4가지 방향으로 회전하며 탐색
            for (int r = 0; r < 4; r++) {
                key = rotate(key);

                // 3. 확장 배열 위를 슬라이딩 하며 열쇠 꽃아보기
                // i, j 는 열쇠가 위치할 좌측 상단 좌표
                for (int i = 0; i <= length - M; i++) {
                    for (int j = 0; j <= length - M; j++) {

                        // [열쇠 꽃기] 현재 위치에열쇠 값 더하기
                        for (int x = 0; x < M; x++) {
                            for (int y = 0; y < M; y++) {
                                arr[i + x][j + y] += key[x][y];
                            }
                        }

                        // [검증] 자물쇠 영역이 모두 1이 되었는지 확인
                        if (check(arr)) {
                            return true;
                        }

                        // [원상 복구] 맞지 않다면 다음 탐색을 위해 더했던 열쇠 값 다시 빼기
                        for (int x = 0; x < M; x++) {
                            for (int y = 0; y < M; y++) {
                                arr[i + x][j + y] -= key[x][y];
                            }
                        }
                    }
                }
            }

            // 4방향, 모든 위치를 다 했는데도 true 반환 안되면 열수없는 자물쇠
            return false;
        }

        int[][] rotate(int[][] arr) {
            int n = arr.length;
            int m = arr[0].length;
            int[][] rotate = new int[m][n]; // 새로운 배열은 m행 n열로 선언하여 회전 후 배열 구조를 미리 만들어 놓아야 한다.

            for (int i = 0; i < rotate.length; i++) {
                for (int j = 0; j < rotate[i].length; j++) {
                    rotate[i][j] = arr[n - 1 - j][i];
                }
            }

            return rotate;
        }

        boolean check(int[][] arr) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i + M - 1][j + M - 1] != 1) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
