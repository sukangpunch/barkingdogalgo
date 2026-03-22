package it_company_work_book.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 틱택토
// 구현

/**
 * 시간복잡도 O(N)
 * 그냥 조건문을 잘 설정 하면 되는 구현 문제이다.
 * 틱택토 게임의 최종 조건은 다음과 같다.(X가 먼저 둠)
 * 1. X와 O가 홀수 개일때는 무조건 X가 1개 더 많아야한다.
 * 2. X와 O가 짝수 개일때는 무조건 X와 O가 같아야한다.
 * 3. 칸이 다 꽉차지 않았을 때 종료 조건은 X나 O중 한명이 승리
 * 4. X와 O가 둘다 승리하는 경우는 없다.
 * 5. X가 승리할때는 무조건 O보다 1개 많다.
 * 6. O가 승리할때는 무조건 X와 O 개수가 같다.
 * 해당 조건들을 기반으로 조건문으로 invalid 인지 valid 인지 구분
 */
public class BOJ_7682 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String line = br.readLine();
            if (line.equals("end")) {
                break;
            }
            char[][] map = new char[3][3];
            int xSize = 0;
            int oSize = 0;
            int oneLineSize = 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int lineIdx = (i * oneLineSize) + j;
                    char ch = line.charAt(lineIdx);

                    if (ch == 'X') {
                        xSize++;
                    } else if (ch == 'O') {
                        oSize++;
                    }

                    map[i][j] = ch;
                }
            }

            int sum = xSize + oSize;

            // 홀수개 일 땐, 무조건 x가 1개 더 많아야 한다.
            if (sum % 2 == 1 && xSize != oSize + 1) {
                sb.append("invalid").append("\n");
                continue;
            }
            // 짝수 개 일 땐, 무조건 x와 o의 개수가 같아야 한다.
            else if (sum % 2 == 0 && xSize != oSize) {
                sb.append("invalid").append("\n");
                continue;
            }

            boolean xCheck = xCheck(map);
            boolean oCheck = oCheck(map);

            // 만약 모든 칸이 다 차있지 않다면, x혹은 o 중 하나는 무조건 승리 해야 한다.
            // 즉, 모든 칸이 다 차있지 않은데, x혹은 o가 둘다 승리이거나 둘다 패배이면 invalid
            if (sum != 9 && xCheck == oCheck) {
                sb.append("invalid").append("\n");
                continue;
            }

            // 둘 다 승리인 경우는 불가능
            if (xCheck && oCheck) {
                sb.append("invalid").append("\n");
                continue;
            }

            // O가 승리할 땐 무조건 X와 O 사이즈가 같아야한다.
            if (oCheck && xSize != oSize) {
                sb.append("invalid").append("\n");
                continue;
            }

            // x가 승리할 땐 무조건 x가 o보다 1 커야한다.
            if (xCheck && xSize != oSize + 1) {
                sb.append("invalid").append("\n");
                continue;
            }

            sb.append("valid").append("\n");

        }

        System.out.println(sb);

    }

    private static boolean xCheck(char[][] map) {
        for (int i = 0; i < 3; i++) {
            int width = 0;
            for (int j = 0; j < 3; j++) {
                if (map[i][j] == 'X') {
                    width++;
                }
            }
            if (width == 3) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            int height = 0;
            for (int j = 0; j < 3; j++) {
                if (map[j][i] == 'X') {
                    height++;
                }
            }
            if (height == 3) {
                return true;
            }
        }

        int cross = 0;
        for (int i = 0; i < 3; i++) {
            if (map[i][i] == 'X') {
                cross++;
            }
        }
        if (cross == 3) {
            return true;
        }

        cross = 0;
        for (int i = 0; i < 3; i++) {
            if (map[i][3 - i - 1] == 'X') {
                cross++;
            }
        }
        if (cross == 3) {
            return true;
        }

        return false;
    }

    private static boolean oCheck(char[][] map) {
        for (int i = 0; i < 3; i++) {
            int width = 0;
            for (int j = 0; j < 3; j++) {
                if (map[i][j] == 'O') {
                    width++;
                }
            }
            if (width == 3) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            int height = 0;
            for (int j = 0; j < 3; j++) {
                if (map[j][i] == 'O') {
                    height++;
                }
            }
            if (height == 3) {
                return true;
            }
        }

        int cross = 0;
        for (int i = 0; i < 3; i++) {
            if (map[i][i] == 'O') {
                cross++;
            }
        }
        if (cross == 3) {
            return true;
        }

        cross = 0;
        for (int i = 0; i < 3; i++) {
            if (map[i][3 - i - 1] == 'O') {
                cross++;
            }
        }
        if (cross == 3) {
            return true;
        }

        return false;
    }
}
