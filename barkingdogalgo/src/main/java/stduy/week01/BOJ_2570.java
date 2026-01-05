package stduy.week01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 수 정렬하기
public class BOJ_2570 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int [] arr = new int[N];
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
        }

//        selectionSort(arr, N);
//        for(int i = 0; i < N; i++) {
//            sb.append(arr[i]).append("\n");
//        }

        insertSort(arr, N);
        for(int i = 0; i < N; i++) {
            sb.append(arr[i]).append("\n");
        }

        System.out.println(sb);
    }

    private static void insertSort(int[] arr, int n) {
        int j;
        for (int i = 1; i < n; i++) {
            int now = arr[i];
            for(j = i-1; j >= 0 && arr[j] > now; j--) {
                arr[j+1] = arr[j];
            }
            arr[j+1] = now;
        }
    }

    private static void selectionSort(int[] arr, int n) {
        int min;
        for (int i = 0; i < n - 1; i++) {
            min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min]) min = j;
            }
            swap(arr, i, min);
        }
    }

    private static void swap(int[] arr, int i, int min) {
        int tmp = arr[i];
        arr[i] = arr[min];
        arr[min] = tmp;
    }
}
