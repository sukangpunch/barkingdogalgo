package stduy.week01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 수 찾기
public class BOJ_1920 {

    static int [] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String [] s = br.readLine().split(" ");
        A = new int[N];
        for(int i=0;i<N;i++){
            A[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(A);

        int M = Integer.parseInt(br.readLine());
        s = br.readLine().split(" ");

        for(int i=0;i<M;i++){
            int num = Integer.parseInt(s[i]);
            int result = findNumByBinarySearch(0, N - 1, num);
            sb.append(result).append("\n");
        }

        System.out.println(sb);

    }

    private static int findNumByBinarySearch(int start, int end, int target) {
        if(start > end){
            return 0;
        }

        int mid = (start + end) / 2;

        if(A[mid] == target){
            return 1;
        }else if(A[mid] > target){
            return findNumByBinarySearch(start, mid - 1, target);
        }else{
            return findNumByBinarySearch(mid + 1, end, target);
        }
    }

}
