package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b_1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] targetArray = new int[N];
        String [] input = br.readLine().split(" ");
        for(int i=0; i < N; i++){
            targetArray[i] = Integer.parseInt(input[i]);
        }

        int M = Integer.parseInt(br.readLine());
        int [] inputArray = new int[M];
        input = br.readLine().split(" ");
        for(int i=0 ; i<M; i++){
            inputArray[i] = Integer.parseInt(input[i]);
        }

        showTargetAndInputSamePart(targetArray, inputArray);
    }

    private static void showTargetAndInputSamePart(int[] targetArray, int[] inputArray) {
        StringBuilder sb = new StringBuilder();

        Arrays.sort(targetArray);
        int startIdx = 0;
        int endIdx = targetArray.length - 1;

        for(int i=0 ; i<inputArray.length ; i++){
            if(checkBinarySearch(targetArray, startIdx, endIdx, inputArray[i])){
                sb.append("1").append("\n");
            }else{
                sb.append("0").append("\n");
            }
        }

        System.out.println(sb);
    }

    private static boolean checkBinarySearch(int[] targetArray, int start, int end, int inputNumber) {
        if(start > end)
            return false;

        int mid = start + (end - start) / 2;

        if(targetArray[mid] == inputNumber){
            return true;
        }

        if(targetArray[mid] < inputNumber){
            return checkBinarySearch(targetArray, mid + 1, end, inputNumber);
        }

        if(targetArray[mid] > inputNumber){
            return checkBinarySearch(targetArray, start, mid -1, inputNumber);
        }

        return false;
    }
}
