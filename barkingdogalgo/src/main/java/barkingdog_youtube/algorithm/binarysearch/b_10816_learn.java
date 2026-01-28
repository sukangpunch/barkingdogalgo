package barkingdog_youtube.algorithm.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 숫자 카드 2
public class b_10816_learn {

    static int [] cards;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        cards = new int[N];
        String [] s = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            cards[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(cards);

        int M = Integer.parseInt(br.readLine());
        s = br.readLine().split(" ");
        for(int i=0; i < M; i++){
            int target = Integer.parseInt(s[i]);
            int left = findLeftNumCount(0, N, target);
            int right = findRightNumCount(0, N, target);
            int result = right - left;
            sb.append(result).append(" ");
        }

        System.out.println(sb);
    }

    private static int findLeftNumCount(int start, int end, int target) {
        while(start < end){
            int mid = (start+end)/2;

            if(cards[mid] >= target){
                end = mid;
            }else if(cards[mid] < target){
                start = mid + 1;
            }
        }

        return start;
    }

    private static int findRightNumCount(int start, int end, int target) {
        while(start < end){
            int mid = (start+end)/2;

            if(cards[mid] > target){
                end = mid;
            }else if(cards[mid] <= target){
                start = mid+1;
            }
        }

        return start;
    }
}
