package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 좌표 압축
public class b_18870_learn {

    static int [] arr;
    static int [] sortArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        Set<Integer> set = new HashSet<>();
        String [] s = br.readLine().split(" ");

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(s[i]);
            arr[i] = num;
            set.add(num);
        }

        sortArr = set.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        Arrays.sort(sortArr);

        for(int i=0; i<N; i++){
            int index = findIndex(0, sortArr.length - 1, arr[i]);
            sb.append(index).append(" ");
        }

        System.out.println(sb);
    }

    private static int findIndex(int start, int end, int target) {
        while(start <= end){
            int mid = (start+end)/2;

            if(sortArr[mid] == target){
                return mid;
            }else if(sortArr[mid] > target){
                end = mid-1;
            }else if(sortArr[mid] < target){
                start = mid+1;
            }
        }

        return 0;
    }
}
