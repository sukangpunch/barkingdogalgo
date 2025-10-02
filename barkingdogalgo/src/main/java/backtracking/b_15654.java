package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class b_15654 {
    static int N;
    static int M;
    static int [] nums;
    static List<Integer> temp;
    static int count;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input1 = br.readLine().split(" ");

        N = Integer.parseInt(input1[0]);
        M = Integer.parseInt(input1[1]);

        nums = new int[N];

        String [] input = br.readLine().split(" ");

        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(nums);

        count = 0;
        temp = new ArrayList<>();

        backtrack();

        System.out.println(sb);
    }

    private static void backtrack() {
        if(count == M){
            int size = temp.size();
            for(int i=0; i<size; i++){
                int num = temp.get(i);
                sb.append(num).append(" ");
            }

            sb.append("\n");
        }

        for(int i = 0; i < N; i++){
            int num = nums[i];
            if(temp.contains(num)){
                continue;
            }
            temp.add(num);
            count++;
            backtrack();
            temp.remove(temp.size()-1);
            count--;
        }
    }
}
