package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 수 정렬하기
public class b_2750 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int [] nums = new int[N];

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            nums[i] = num;
        }

        for(int i = 0 ; i < N-1 ; i++){
            for(int j = i+1 ; j < N ; j++){
                if(nums[i] > nums[j]){
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }

        for(int i = 0 ; i < N ; i++){
            sb.append(nums[i]).append("\n");
        }

        System.out.println(sb);
    }
}
