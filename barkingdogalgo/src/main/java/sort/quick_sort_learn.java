package sort;

import java.io.IOException;

public class quick_sort_learn {

    static int N;
    static int [] arr;

    public static void main(String[] args) throws IOException {
        N = 10;
        arr = new int[]{-3,3, -1, 6, 12,33,-12,7,4, 19};

        quick_sort(0, N);

        for(int i=0; i<N; i++){
            System.out.print(arr[i] + " ");
        }
    }

    private static void quick_sort(int st, int en) {
        if(en <= st+1) return; // 만약 끝 좌표보다 첫 좌표가 더 커진다면 종료
        int pivot = arr[st]; // 피벗을 배열 가장 첫 부분으로 선택
        int l = st+1; // 피벗 다음부터 시작
        int r = en-1; // 끝 인덱스 부터 시작(N 이 10 일때 끝 인덱스는 9)
        while(true){
            while(l <= r && arr[l] <= pivot) l++; // 왼쪽 인덱스 l 왼쪽에는 무조건 피벗보다 작은 값이 오도록
            while(l <= r && arr[r] >= pivot) r--; // 오른쪽 인덱스 r 오른쪽에는 무조건 피벗보다 큰 값이 오도록
            if(l>r) break; // 만약 왼쪽 인덱스가 오른쪽 인덱스보다 커지면 종료(더이상 탐색은 의미 없기때문)
            swap(l, r); // 각 턴마다 최대한 왼쪽인덱스, 오른쪽 인덱스를 이동시키고, 멈춘 부분(최대한 왼쪽 작은값, 오른쪽 큰값) 을 교환
        }
        swap(st, r); // 위 반복이 끝난 이후, 피벗 값과 오른쪽 인덱스 자리를 교환
        quick_sort(st, r); // 피벗(현재 r) 왼쪽 부분 재귀(마지막 인덱스는 en - 1 로 포함 안시키기 때문에 r 그대로 사용)
        quick_sort(r+1, en); // 피벗 오른쪽 부분 재귀
    }

    private static void swap(int left, int right){
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }

}
