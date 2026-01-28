package algorithm.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 과자 나눠주기
public class b_16401 {

    static int M;
    static int N;
    static int [] snacks;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] s = br.readLine().split(" ");
        M = Integer.parseInt(s[0]);
        N = Integer.parseInt(s[1]);

        snacks = new int[N];
        s = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            snacks[i] = Integer.parseInt(s[i]);
        }

        Arrays.sort(snacks);

        int maxSnackLength = findMaxSnackLength();
        System.out.println(maxSnackLength);
    }

    private static int findMaxSnackLength() {
        int left = 1;
        int right = snacks[N-1];
        int result = 0;

        while(left <= right) {
            int cnt = 0;
            int mid = (left + right) / 2;
            for(int i = 0; i < snacks.length; i++) {
                cnt += snacks[i]/mid;
            }

            if(cnt >= M){
                result = mid;
                left = mid+1;
            }else{
                right = mid-1;
            }
        }

        return result;
    }
}
