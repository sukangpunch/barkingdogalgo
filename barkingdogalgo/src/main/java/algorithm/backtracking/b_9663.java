package algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 답 보기 :x (질문게시판 힌트)
// 메모리 : 15704 kb
// 시간 : 6452 ms
public class b_9663 {
    static int result;
    static int count;
    static int N;
    static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N];
        for (int i = 0; i < N; i++) {
            map[i] = -1;
        }

        backtrack(0);
        System.out.println(result);
    }

    private static void backtrack(int depth) {
        if (count == N) {
            result++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (checkQueen(depth, i)) {
                count++;
                backtrack(depth + 1);
                count--;
                map[depth] = -1;
            }
        }
    }

    private static boolean checkQueen(int depth, int x) {
        if (count != 0) {
            for (int i = 0; i < N; i++) {
                if(map[i] == -1){
                    continue;
                }
                if (map[i] == x || i == depth) {
                    return false;
                } else {
                    int levelL = i - map[i];
                    int levelR = i + map[i];
                    int myL = depth - x;
                    int myR = depth + x;

                    if (levelL == myL || levelR == myR) {
                        return false;
                    }
                }
            }
        }
        map[depth] = x;
        return true;
    }
}
