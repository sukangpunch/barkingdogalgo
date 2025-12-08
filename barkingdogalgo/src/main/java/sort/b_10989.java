package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 수 정렬하기 3
public class b_10989 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int [] nums = new int[N];
        for(int i=0; i<N; i++) {
            int num = Integer.parseInt(br.readLine());
            nums[i] = num;
        }

        Arrays.sort(nums);

        for(int i=0; i<N; i++) {
            sb.append(nums[i]).append("\n");
        }

        System.out.println(sb);
    }

}
