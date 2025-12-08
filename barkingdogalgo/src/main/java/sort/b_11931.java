package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 수 정렬하기 4
public class b_11931 {
    static int []tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int [] nums = new int[N];
        tmp = new int[N];

        for(int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(nums, 0, N-1);

        for(int i = 0 ; i < N ; i++){
            sb.append(nums[i]).append("\n");
        }

        System.out.println(sb);
    }

    private static void mergeSort(int [] nums, int left, int right) {
        if(left < right) {
            int mid = (left + right) / 2;
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);


            int p = left;
            int q = mid + 1;
            int k = left;

            while(p <= mid && q <= right) {
                if(nums[p] >= nums[q]) {
                    tmp[k] = nums[p];
                    p++;
                }else{
                    tmp[k] = nums[q];
                    q++;
                }
                k++;
            }

            if(p > mid){
                for(int i = q; i <= right; i++) {
                    tmp[k] = nums[i];
                    k++;
                }
            }else{
                for(int i = p; i <= mid; i++) {
                    tmp[k] = nums[i];
                    k++;
                }
            }

            for(int i = left; i <= right; i++) {
                nums[i] = tmp[i];
            }
        }
    }

}
