package algorithm.sort;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class b_5648 {

    public static void main(String[] args) throws IOException {
       Scanner sc = new Scanner(System.in);
       StringBuilder sb = new StringBuilder();

       int N = sc.nextInt();
       String[] str = new String[N];
       long[] arr = new long[N];
       for(int i=0; i<N; i++){
           str[i] = sc.next();
       }

       for(int i=0; i<N; i++){
           String s = str[i];
           String reversed = reversed(s);
           arr[i] = Long.parseLong(reversed);
       }

       Arrays.sort(arr);

       for(int i=0; i<N; i++){
           sb.append(arr[i]).append("\n");
       }

       System.out.println(sb);
    }

    private static String reversed(String str) {
        char[] arr = str.toCharArray();
        int start = 0;
        int end = arr.length - 1;

        while(start < end){
            swap(arr, start, end);
            start++;
            end--;
        }

        String reversed = new String(arr);


        int cutIdx = 0;
        for(int i=0; i< reversed.length(); i++){
            if(reversed.charAt(i) == '0'){
                cutIdx++;
            }else{
                break;
            }
        }

        reversed = reversed.substring(cutIdx);

        return reversed;
    }

    private static void swap(char[] arr, int start, int end) {
        char temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
