package algorithm.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class b_2295 {

    static int N;
    static int [] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }

        Set<Integer> set = new HashSet<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                set.add(nums[i] + nums[j]);
            }
        }

        int max = Integer.MIN_VALUE;

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(set.contains(nums[i] - nums[j])){
                    max = Math.max(max, nums[i]);
                }
            }
        }

        System.out.println(max);
    }

//    private static void findMaxNum() {
//
//        for(int i=0; i<N; i++){
//            for(int j=i; j<N; j++){
//                for(int k=j; k<N; k++){
//                    int sum = nums[i] + nums[j] + nums[k];
//                    if(binarySearch(0,N-1,sum)){
//                        maxNum = sum;
//                    }
//                }
//            }
//        }
//    }
//
//    private static boolean binarySearch(int left, int right, int sum) {
//        int mid = (left + right) / 2;
//
//        if(left > right){
//            return false;
//        }
//
//        if(sum == nums[mid]){
//            return true;
//        }
//
//        if(sum > nums[mid]){
//            return binarySearch(mid+1, right, sum);
//        }
//
//        if(sum < nums[mid]){
//            return binarySearch(left, mid-1, sum);
//        }
//
//        return false;
//    }
}
