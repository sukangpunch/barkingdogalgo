package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 카드
public class b_11652_learn_no_map {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long [] arr = new long[N];

        for(int i=0; i<N; i++){
            arr[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(arr);

        int cnt = 0;
        long maxValue = Long.MIN_VALUE;
        int maxCnt = 0;

        for(int i=0; i<N; i++){
            if(i==0 || arr[i-1] == arr[i]){
                cnt++;
            }else{
                if(cnt > maxCnt){
                    maxCnt = cnt;
                    maxValue = arr[i-1];
                }
                cnt = 1;
            }
        }

        if(cnt > maxCnt) maxValue = arr[N-1];
        System.out.println(maxValue);
    }

}
