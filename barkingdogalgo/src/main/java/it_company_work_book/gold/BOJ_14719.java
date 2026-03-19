package it_company_work_book.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 빗물
// 구현, 시뮬레이션

/**
 * 시간복잡도 : O(N^2)
 * 가장 왼쪽, 가장 오른쪽에는 물이 고일 수 없으므로 비교하지 않는다.
 * 1 ~ W-1 범위의 블럭들 중에 현재 자기 idx 기준 왼쪽에서 가장 높은 블럭, 오른쪽에서 가장 높은 블럭을 구한다.
 * 두 블럭 중 낮은 블럭만큼 물이 고일 수 있으므로, 낮은 블럭 - 자기 블럭 높이 만큼이 해당 위치에서 고일수 있는 물이다.
 * 만약 높은 블럭 중 낮은 블럭보다 자기 블럭이 같거나 높으면 물이 고일 수 없으므로 넘어간다.
 **/
public class BOJ_14719 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int H = Integer.parseInt(s[0]);
        int W = Integer.parseInt(s[1]);

        s = br.readLine().split(" ");
        int[] map = new int[W];
        for (int i = 0; i < W; i++) {
            map[i] = Integer.parseInt(s[i]);
        }

        int waters = 0;
        for (int i = 1; i < W - 1; i++) {
            int leftMax = 0;
            int rightMax = 0;

            for (int left = i; left >= 0; left--) {
                if (leftMax < map[left]) {
                    leftMax = map[left];
                }
            }

            for (int right = i; right < W; right++) {
                if (rightMax < map[right]) {
                    rightMax = map[right];
                }
            }

            int min = Math.min(leftMax, rightMax);
            if (map[i] < min) {
                waters += min - map[i];
            }
        }

        System.out.println(waters);
    }
}
