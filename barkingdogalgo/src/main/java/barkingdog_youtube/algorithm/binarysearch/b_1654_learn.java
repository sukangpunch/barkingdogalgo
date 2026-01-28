package barkingdog_youtube.algorithm.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 랜선 자르기
public class b_1654_learn {

    static int K;
    static int N;
    static long [] cables;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] s = br.readLine().split(" ");
        K = Integer.parseInt(s[0]);
        N = Integer.parseInt(s[1]);

        cables = new long[K];
        for(int i=0; i<K; i++){
            cables[i] = Integer.parseInt(br.readLine());
        }

        long kCables = findKCables(1, Integer.MAX_VALUE);
        System.out.println(kCables);
    }

    private static long findKCables(long start, long end) {
        while(start < end){
            long mid = (start + end + 1)/2;
            if(solve(mid)) start = mid;
            else end = mid - 1;
        }
        return start;
    }

    private static boolean solve(long mid) {
        long cur = 0;
        for(int i=0; i<K; i++){
            cur += cables[i] / mid;
        }

        return cur >= N;
    }

}
