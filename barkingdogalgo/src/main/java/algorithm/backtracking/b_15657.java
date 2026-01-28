package algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// N과 M (8)
public class b_15657 {

    static int N;
    static int M;
    static int [] nums;
    static List<Integer> tmp;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        String [] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        nums = new int[N];
        tmp = new ArrayList<>();

        s = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(s[i]);
        }

        Arrays.sort(nums);

        backtracking(0,0);

        System.out.println(sb);
    }

    private static void backtracking(int depth, int idx) {
        if(depth == M){
            int size = tmp.size();
            for(int i=0; i<size; i++){
                sb.append(tmp.get(i)).append(" ");
            }
            sb.append("\n");
        }else{
            for(int i = idx; i<N; i++){
                tmp.add(nums[i]);
                backtracking(depth+1, i);
                tmp.remove(tmp.size()-1);
            }
        }
    }
}
