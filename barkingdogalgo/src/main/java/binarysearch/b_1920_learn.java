package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 수 찾기 (재귀보다 반복문이 더빠름)
public class b_1920_learn {

    static int [] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        A = new int[N];
        String [] s = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(s[i]);
        }

        Arrays.sort(A);

        int M = Integer.parseInt(br.readLine());
        s = br.readLine().split(" ");

        for(int i=0; i<M; i++){
            int target = Integer.parseInt(s[i]);
            int result = findNum(0, N-1, target);
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

    private static int findNum(int start, int end, int target) {

        while(start <= end){
            int mid = (start + end)/2;

            if(A[mid] == target){
                return 1;
            }else if(A[mid] < target){
                start = mid+1;
            }else if(A[mid] > target){
                end = mid-1;
            }
        }

        return 0;
    }

}
