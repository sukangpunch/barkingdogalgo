package barkingdog_youtube.algorithm.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 수 고르기
public class b_2230_learn {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int st = 0;
        int en = 0;
        int min = Integer.MAX_VALUE;
        while (true) {
            if (arr[en] - arr[st] >= M) {
                min = Math.min(min, arr[en] - arr[st]);
                st++;
            } else if (arr[en] - arr[st] < M){
                en++;
            }

            if(st > en || en >= N){
                break;
            }
        }

        System.out.println(min);
    }
}
