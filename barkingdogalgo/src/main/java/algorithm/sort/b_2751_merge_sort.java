package algorithm.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_2751_merge_sort {

    static int [] tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int [] nums = new int[N];
        tmp = new int[N];

        for(int i = 0 ; i < N ; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(nums, 0, N-1);

        for(int i = 0 ; i < N ; i++){
            sb.append(nums[i]).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static void mergeSort(int[] nums, int start, int end) {
        if(start < end){
            int mid = (start + end) / 2;
            mergeSort(nums, start, mid);
            mergeSort(nums, mid + 1, end);

            int p = start;
            int q = mid+1;
            int k  = start;

            // 범위의 두 배열을 비교(p ~ mid) (q~end)
            while(p <= mid && q <= end){
                if(nums[p] <= nums[q]){  // p보다 q 가 크다면?
                    tmp[k] = nums[p];   // p 부터 채워넣는다.
                    p++;
                }
                else{
                    tmp[k] = nums[q];  // p가 더 크다면 q부터 채워 넣는다.
                    q++;
                }
                k++;
            }

            if(p > mid){  // 위 배열에서 채우지 못하고 남은 것들, 찾아서 넣기
                for(int i=q; i<=end; i++){
                    tmp[k] = nums[i];
                    k++;
                }
            }else{
                for(int i=p; i<=mid; i++){
                    tmp[k] = nums[i];
                    k++;
                }
            }

            for(int i=start; i<=end; i++){ // 정렬한 배열을 원본 배열에 옮겨 적기
                nums[i] = tmp[i];
            }
        }
    }
}
