package soma.second;

// 자물쇠와 열쇠
// 구현

/**
 * 저번에 한번 푼 문제라 다시 풀 수 있었다.
 * key를 lock 에 대입하여 lock이 전부 1이면 되는 문제이다.
 * key를 대입하는 방법은 90도 회전을 허용하며, lock의 모든 부분에 대하여 key의 값을 더한다.
 * key의 모든 부분을 lock의 모든 부분에 대입해보기 위해서 map을 (keySize-1)*2 + lockSize 로 선언
 * 그래야, 최소 1개(모서리부분) 부터 전체 매핑이 가능해지기 떄문
 * 1. 가장 바깥의 rotation 만큼 rotate함수를 호출하여 key를 회전시킨다.
 *    rotate함수는 우측으로 회전한다 했을 때, tmp[i][j] = key[j][키사이즈-1-i] 로 회전할 수 있다.
 * 2. i, j 반복문으로 시작점을 잡고, 해당 위치부터 keySize만큼(r,c 반복문), map에 값을 더한다.
 * 3. 만약 map에서 lock 범위만 확인 했을 때, 전부 1이면 바로 true 리턴 종료, 아니라면 더했던 key만큼 다시 빼줘서 롤백
 * 4. 모든 로테이션까지 돌렸을 때도 return true가 안된다면, 키로 열 수 없는 자물쇠로 false 리턴
 */
public class PGS_60059 {

    static public boolean solution(int[][] key, int[][] lock) {
        int keySize = key.length;
        int lockSize = lock.length;
        int size = (keySize-1)*2 + lockSize;
        int [][] map = new int[size][size];

        for(int i=keySize-1; i<keySize-1+lockSize; i++){
            for(int j=keySize-1; j<keySize-1+lockSize; j++){
                map[i][j] = lock[i-(keySize-1)][j-(keySize-1)];
            }
        }

        for(int rotation = 0; rotation<4; rotation++){
            key = rotate(key);
            for(int i=0; i<size-(keySize-1); i++){
                for(int j=0; j<size-(keySize-1); j++){
                    // keySize 만큼 순회
                    for(int r=i; r<i+keySize; r++){
                        for(int c=j; c<j+keySize; c++){
                            map[r][c] += key[r-i][c-j];
                        }
                    }

                    boolean check = true;
                    for(int r=keySize-1; r<keySize-1+lockSize; r++){
                        for(int c=keySize-1; c<keySize-1+lockSize; c++){
                            if(map[r][c] != 1){
                                check = false;
                                break;
                            }
                        }
                        if(!check){
                            break;
                        }
                    }

                    if(check){
                        return true;
                    }

                    // keySize 만큼 순회
                    for(int r=i; r<i+keySize; r++){
                        for(int c=j; c<j+keySize; c++){
                            map[r][c] -= key[r-i][c-j];
                        }
                    }

                }
            }
        }

        return false;
    }

    static int[][] rotate(int[][]key){
        int size = key.length;
        int [][]tmp = new int[size][size];

        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                tmp[i][j] = key[j][(size-1)-i];
            }
        }

        return tmp;
    }
}
