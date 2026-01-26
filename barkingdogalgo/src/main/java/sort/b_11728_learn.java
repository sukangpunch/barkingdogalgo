package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 배열 합치기
public class b_11728_learn {

    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String [] s = br.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        int [] A = new int[N];
        int [] B = new int[M];

        s = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(s[i]);
        }

        s = br.readLine().split(" ");
        for(int i=0; i<M; i++){
            B[i] = Integer.parseInt(s[i]);
        }

//        Arrays.sort(A);
//        Arrays.sort(B);
        int[] merge = merge(A, B);

        for(int i=0; i<merge.length; i++){
            sb.append(merge[i]).append(" ");
        }

        System.out.println(sb);
    }

    private static int[] merge (int[] a, int[] b) {
        int size = N+M;
        int [] newArr = new int[size];

        int newLeft = 0;
        int aLeft = 0;
        int bLeft = 0;

        while(aLeft < N && bLeft < M){
            if(a[aLeft] > b[bLeft]){
                newArr[newLeft] = b[bLeft];
                bLeft++;
                newLeft++;
            }else{
                newArr[newLeft] = a[aLeft];
                aLeft++;
                newLeft++;
            }
        }

        if(aLeft < N){
            for(int i=aLeft; i<N; i++){
                newArr[newLeft] = a[i];
                newLeft++;
            }
        }

        if(bLeft < M){
            for(int i=bLeft; i<M; i++){
                newArr[newLeft] = b[i];
                newLeft++;
            }
        }

        return newArr;
    }
}
