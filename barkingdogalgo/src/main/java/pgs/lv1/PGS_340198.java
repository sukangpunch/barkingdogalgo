package pgs.lv1;

import java.util.Arrays;
import java.util.Collections;

// [PCCE] 공원
/**
 * 현재 공원의 빈 자리 중 정사각형 범위로 깔 수 있는 최대 돗자리 사이즈를 구하는 문제.
 * 돗자리 사이즈는 정해져있고(mats) 공원에서 정사각형으로 깔 수 있는 최대 범위를 구한 다음, 해당 범위에 들어갈 수 있는 최대 돗자리 크기를 구하면 된다.
 * 0,0 부터 col, row (공원 크기) 까지 순회하면서 현재 좌표에서 최대 크기의 정사각형 범위를 구하면 된다.
 */

public class PGS_340198 {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        int col = park.length;
        int row = park[0].length;
        int maxSize = 0;

        for (int i = 0; i < col; i++) {
            if(col - i <= maxSize)break;
            for (int j = 0; j < row; j++) {
                if(row - j <= maxSize) break;
                int result = find(i, j, park);
                maxSize = Math.max(maxSize, result);
            }
        }

        mats = Arrays.stream(mats)
                .boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        for (int i = 0; i < mats.length; i++) {
            if (mats[i] <= maxSize) {
                answer = mats[i];
                break;
            }
        }

        return answer;
    }

    public int find(int c, int r, String[][] park) {
        int size = 0;
        int col = park.length;
        int row = park[0].length;

        while (c + size + 1 <= col && r + size + 1 <= row) {
            int next = size+1;
            boolean isSquare = true;
            for (int i = c; i < c + next; i++) {
                for (int j = r; j < r + next; j++) {
                    if (!park[i][j].equals("-1")) {
                        isSquare = false;
                        break;
                    }
                }
                if (!isSquare) break;
            }

            if(!isSquare){
                break;
            }
            size = next;
        }

        return size;
    }

    public static void main(String[] args) {
        PGS_340198 pgs = new PGS_340198();
        int[] mats = {5, 3, 2};
        String[][] park = {
                {"A", "A", "-1", "B", "B", "B", "B", "-1"},
                {"A", "A", "-1", "B", "B", "B", "B", "-1"},
                {"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"},
                {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"},
                {"D", "D", "-1", "-1", "-1", "-1", "-1", "F"},
                {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"}
        };

        int result = pgs.solution(mats, park);
        System.out.println("result = " + result + " (expected = 3)");
    }
}
