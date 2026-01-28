package algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// N과 M (7)
public class b_15656 {

    static int [] nums;
    static int N;
    static int M;
    static StringBuilder sb;
    static List<Integer> tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        tmp = new ArrayList<>();

        String []s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        s = br.readLine().split(" ");
        nums = new int[N];
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(s[i]);
        }

        Arrays.sort(nums);

        backtracking(0);

        System.out.println(sb);
    }

    private static void backtracking(int depth) {
        if(depth == M){
            int size = tmp.size();
            for(int i=0; i<size; i++){
                sb.append(tmp.get(i)).append(" ");
            }
            sb.append("\n");
        }else{
            for(int i=0; i<N; i++){
                tmp.add(nums[i]);
                backtracking(depth + 1);
                tmp.remove(tmp.size()-1);
            }
        }
    }
}
