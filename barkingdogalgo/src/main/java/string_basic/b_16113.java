package string_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_16113 {
    public static int[][] num;
    public static StringBuilder sb;
    private static final int ROWS = 5;
    private static final int COLS = 3;
    private static final int[][][] patterns = {
            {   // 0
                    {1, 1, 1},
                    {1, 0, 1},
                    {1, 0, 1},
                    {1, 0, 1},
                    {1, 1, 1}
            },
            {   // 1
                    {0, 1, 0},
                    {0, 1, 0},
                    {0, 1, 0},
                    {0, 1, 0},
                    {0, 1, 0}
            },
            {   // 2
                    {1, 1, 1},
                    {0, 0, 1},
                    {1, 1, 1},
                    {1, 0, 0},
                    {1, 1, 1}
            },
            {   // 3
                    {1, 1, 1},
                    {0, 0, 1},
                    {1, 1, 1},
                    {0, 0, 1},
                    {1, 1, 1}
            },
            {   // 4
                    {1, 0, 1},
                    {1, 0, 1},
                    {1, 1, 1},
                    {0, 0, 1},
                    {0, 0, 1}
            },
            {   // 5
                    {1, 1, 1},
                    {1, 0, 0},
                    {1, 1, 1},
                    {0, 0, 1},
                    {1, 1, 1}
            },
            {   // 6
                    {1, 1, 1},
                    {1, 0, 0},
                    {1, 1, 1},
                    {1, 0, 1},
                    {1, 1, 1}
            },
            {   // 7
                    {1, 1, 1},
                    {0, 0, 1},
                    {0, 0, 1},
                    {0, 0, 1},
                    {0, 0, 1}
            },
            {   // 8
                    {1, 1, 1},
                    {1, 0, 1},
                    {1, 1, 1},
                    {1, 0, 1},
                    {1, 1, 1}
            },
            {   // 9
                    {1, 1, 1},
                    {1, 0, 1},
                    {1, 1, 1},
                    {0, 0, 1},
                    {1, 1, 1}
            }
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int rowSize = N/5;
        String signal = br.readLine();

        num = new int[ROWS][rowSize];

        for(int i=0;i<ROWS; i++){
            for(int j = 0; j<rowSize; j++){
                num[i][j] = (signal.charAt(i * rowSize + j)) == '#' ? 1 : 0;
            }
        }

        findNum(rowSize);
        System.out.println(sb);
    }

    private static void findNum(int rowSize) {
        for(int i=0; i < rowSize; i++){ // 첫 번째 줄만 확인
            if(num[0][i] == 0)continue;  // 숫자가 시작되는 부분이 아니라면

            if(i + 3 > rowSize){  // 숫자가 시작되는 부분인데 해당 칸 포함 칸 여부가 3 미만이라면(1 말고는 전부 3칸이 필요)
                sb.append(1);
                break;
            }

            for(int j=0; j<10; j++){  // 0~9 숫자를 비교
                if(j==1) continue;  // 1은 비교 할 필요가 없음.
                boolean matched = matchesPattern(i, j);
                if(matched){     // k 번째(0~9) 숫자에서 isRight 가 true 를 유지하였다면
                    sb.append(j);
                    i += 2;     // i 인덱스에서 i+1, i+2 까지를 확인하였으므로 해당 부분은 검증 불필요
                    break;
                }
                if(j==9){  // 마지막 숫자까지 다 돌았는데 매칭되는게 없으면 유일하게 1열로 처리하는 1 밖에 없다.
                    sb.append(1);
                    break;
                }
            }
        }
    }

    private static boolean matchesPattern(int i, int j) {
        for(int r = 0; r<ROWS; r++){ // 비교 군 총 5행
            for(int c = 0; c<COLS; c++){  // 비교 군 총 3열
                if(patterns[j][r][c] != num[r][c + i]){ // 패턴과 현재 num 부분을 비교 5행 3열 비교
                    return false;
                }
            }
        }
        return true;
    }
}
