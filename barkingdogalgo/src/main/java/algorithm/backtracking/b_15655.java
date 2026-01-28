package algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class b_15655 {
    static int N;
    static int M;
    static int [] nums;
    static int count;
    static StringBuilder sb = new StringBuilder();
    static List<Integer> temp = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        backtracking();

        System.out.println(sb);
    }

    static void backtracking() {
        if(count == M){
            int size = temp.size();
            for(int i = 0; i < size; i++){
                sb.append(temp.get(i)).append(" ");
            }
            sb.append("\n");
        }else{
            for(int i = 0; i < N; i++){
                if(!temp.contains(nums[i])){
                    if(!temp.isEmpty() && temp.get(temp.size()-1) >= nums[i]){
                        continue;
                    }
                    temp.add(nums[i]);
                    count += 1;
                    backtracking();
                    temp.remove(temp.size()-1);
                    count -= 1;
                }
            }
        }
    }
}
