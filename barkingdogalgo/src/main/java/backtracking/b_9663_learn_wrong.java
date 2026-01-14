package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// N-Queen
// 메모리 초과 뜸
public class b_9663_learn_wrong {

    static class Queen {

        int y;
        int x;

        public Queen(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int N;
    static int result;
    static List<Queen> queens;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        queens = new ArrayList<>();

        backtrack(0);
        System.out.println(result);
    }

    private static void backtrack(int depth) {
        if (depth == N){
            result++;
            return;
        }

        for(int col = 0; col < N; col++){
            if(isAvailable(depth, col)){
                queens.add(new Queen(depth, col));
                backtrack(depth + 1);
                queens.remove(queens.size() - 1);
            }
        }
    }

    private static boolean isAvailable(int row, int col) {
        for (Queen q: queens){
            if(q.x == col) return false;

            if(Math.abs(q.y - row) == Math.abs(q.x - col)) return false;
        }

        return true;
    }
}
