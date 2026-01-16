package stduy.week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 줄 서는 방법
public class pgs_12936 {

    static List<Integer> list;
    static int N;
    static long K;
    static StringBuilder sb = new StringBuilder();
    static int count;
    static int [] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        result = new int[N];

        backtrack(0);
        System.out.println(Arrays.toString(list.stream().mapToInt(Integer::intValue).toArray()));
    }

    private static boolean backtrack(int depth) {
        if (depth == N) {
            count++;
            if(count == K){
                return true;
            }
            return false;
        }

        for (int i = 1; i <= N; i++) {
            if (list.contains(i)) {       // 해당 조건으로, 각 부분에 맞는 index를 쭉 돌다가 없는 원소만 넣을 수 있다.
                continue;                 // 즉, 1(i=1), 2(i=1x, i=2), 3(i=1x, i=2x, i=3) -> 탈출 하지만 3은 이미 반복문 다 돌아서 2 부분으로 바로 복귀
            }
            list.add(i);
            if(backtrack(depth + 1)){
                return true;
            }
            list.remove(list.size() - 1);
        }
        return false;
    }

}
