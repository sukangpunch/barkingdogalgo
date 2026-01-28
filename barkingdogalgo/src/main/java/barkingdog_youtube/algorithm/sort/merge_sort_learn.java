package barkingdog_youtube.algorithm.sort;

// 합병 정렬
public class merge_sort_learn {

    static int [] arr;
    static int [] tmp;

    public static void main(String[] args) {
        arr = new int[]{-2,5,2,10,32,-11,-6, 10, 18, -3};
        tmp = new int[arr.length];

        merge_sort(0, arr.length);

        for(int i=0; i<arr.length; i++){
            System.out.print(tmp[i] + " ");
        }
    }

    private static void merge_sort(int st, int en) {
        if(en == st+1)return;
        int mid = (st+en)/2;
        merge_sort(st, mid);
        merge_sort(mid, en);
        merge(st, en);
    }

    private static void merge(int st, int en) {
        int mid = (st+en)/2;
        int l = st; // 0
        int r = mid; // 1
        int idx = st;

        for(int i=st; i<en; i++){
            if(r == en) tmp[idx++] = arr[l++];
            else if(l == mid) tmp[idx++] = arr[r++];
            else if(arr[l] <= arr[r]) tmp[idx++] = arr[l++];
            else tmp[idx++] = arr[r++];
        }

        for(int i= st; i<en; i++){
            arr[i] = tmp[i];
        }
    }
}
