package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// 세 수의 합(이진탐색 활용)
public class b_2295_learn {

    static List<Integer> two;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int [] arr = new int[N];
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
        }
        Arrays.sort(arr);

        two = new ArrayList<>();
        for(int i=0; i<N; i++){
            for(int j=i; j<N; j++){
                two.add(arr[i] + arr[j]);
            }
        }

        Collections.sort(two);

        for(int i=N-1; i > 0; i--){ // arr을 내림차순으로 탐색(처음 true 인 값이 정답이 된다)
            for(int j=0; j < i; j++){
                if(findMaxK(0, two.size()-1, arr[i] - arr[j])){
                    // 정렬된 배열 arr 의 마지막 값이 가장 큰 값(k) 가 될 수 있고, 마지막 부터 k를 탐색하기 때문에 처음 걸리는 값이 가장 큰 값이 된다.
                    System.out.println(arr[i]);
                    return;
                }
            }
        }
    }

    private static boolean findMaxK(int start, int end, int k) {
        while(start <= end){
            int mid = (start+end)/2;

            if(two.get(mid) == k){
                return true;
            }else if(two.get(mid) > k){
                end = mid-1;
            }else if(two.get(mid) < k){
                start = mid+1;
            }
        }

        return false;
    }

}
